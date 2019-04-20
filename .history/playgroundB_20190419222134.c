/* Michell Li   mli88@jhu.edu
SCRAM Assembler
functions.c
*/

#include <string>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <fstream>
#include <iostream>
#include <math.h>
#include "functions.h"
#include <stdint.h>
#include <vector>

using std::string;
using std::cin;
using std::endl;
using std::stoi;
using std::to_string;
using std::size_t;
using std::vector;

/*
labels: 2D vector
[label name] [line number]
*/
vector<string> labels;
string input[256] = {""};
int line_count = 0; //length of file input
int org = 0;

/* first pass, read labels */
int implement(ifstream& fp) {
  string output;
  string instruct;
  bool cont = true; //for checking space/tabs

  while (fp.good()) { //reads filenames correctly
    if (line_count > 255) {
      fprintf(stderr, "The program is too large.\n");
      return 4;
    }
    
    string s; //reads entire line
    getline(fp, s);
    
    char first = s.at(0);
    int comment = 0;

    if (first == '\n') { //empty line
      continue;
    }
    //cut out comments
    if (s.find(";") != std::string::npos) {
      comment = s.find(";");
      if (comment == 0) { //starts with comment
        continue; //next line
      }
      s = s.substr(0, comment); //take out comments
    }
    //only spaces/tabs?
    if (s.find_first_of("ABCDEFGHIJKLMNOPQRSTUVWXYZ:1234567890") == std::string::npos) { //invalid anyway
      cont = false;
    }
    if (!cont) { //only spaces/tabs
      continue;
    } else { //cont = true
      if (((s.at(0) > 40) && (s.at(0) < 90)) || ((s.at(0) > 60) && (s.at(0) < 122))) { //has label
        int colon;
        size_t space = s.find(" ");
        size_t tab = s.find("\t");
        size_t  eol = s.find("\n");
        //find how long label is
        if (space == std::string::npos && tab == std::string::npos) {
          colon = eol; //label:\n
        } else if (space == std::string::npos && tab != std::string::npos) {
          colon = tab; //label:\t
        } else if (space != std::string::npos && tab == std::string::npos) {
          colon = space; //label:_
        } else if (space != std::string::npos && tab != std::string::npos) {
          if (space < tab) {
            colon = space;
          } else {
            colon = tab;
          }
        }
        string lab = s.substr(0, colon); //lab = label:
        if (lab.length() == 1) {
          fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
          return 7;
        }
        char last = lab.at(lab.length() - 1); //last = ':'
        if (last == ':') { //label end with colon?
          lab = s.substr(0, colon - 1);
          //check label name
          for (int k = 0; k < (int) lab.length(); k++) {
            char d = lab.at(k);
            if (d < 48) {
              fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
              return 7;
            } else if ((d != '_') && (d > 90) && (d < 97)) {
              fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
              return 7;
            } else if (d > 122) {
              fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
              return 7;
            }
          }
          //check if label name is taken
          for (int i = 0; i < (int) labels.size(); i += 2) {
            string w = labels.at(i);
            if (lab.compare(w) == 0) {
              fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
              return 7;
            }
          }
        } else { //no colon at end of label
          fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
          return 7;
        } //label ok
        labels.push_back(lab);
        labels.push_back(to_string(line_count));

        //cut out label, look at remaining stuff
        s = s.substr(colon-1);
        if (s.find_first_of("ABCDEFGHIJKLMNOPQRSTUVWXYZ") != std::string::npos) {
          //has instruction
          int alpha = s.find_first_of("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
          s = s.substr(alpha); //cuts out empty space before instruction
        } else { //only has label
          continue;
        }
      } else { //no label, find instruction
        int alpha = s.find_first_of("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        s = s.substr(alpha);
      }
      //check ORG
      if (s.length() > 2) { //ORG at least
        string ch = s.substr(0,3);
        string tem = s.substr(3);
        string org_arg = "";
        if (ch.compare("ORG") == 0) { //is ORG
          for (int k = 1; k < (int) labels.size(); k += 2) { //check label: ORG
            string lc = labels.at(k);
            if (lc.empty() == 0) {
              int r = stoi(lc);
              if (r == line_count) {
                fprintf(stderr, "An invalid label was encountered (bad label format or duplicate).\n");
                return 7;
              }
            }
          }
          size_t ar = tem.find_first_of("1234567890-");
          if (tem.find(".") != std::string::npos) { //is float
            fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
            return 6;
          }
          if (ar == std::string::npos) { //no argument
            fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
            return 6;
          } else if ('-' == (char) tem.at(ar)) { //ORG negative#
            fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
            return 6;
          } else { //ORG input ok, change to decimal
            org_arg = "";
            int j = 0;
            while (j < (int) tem.length()){
              org_arg += tem.at(j);
              j++;
            }
            long l = stol(org_arg, NULL, 0);
            if ((l > 255) || (l < 0)) { //ex. ORG 257
              fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
              return 6;
            }
            org = (int) l;
            continue;
          }
        }
      } //end of checkORG
      input[line_count] = s;
      line_count++;
    } //end of if (cont)
  } //end of while loop
fp.close();
if (org > line_count) { //>256?
  fprintf(stderr, "The program is too large.\n");
  return 4;
}
 return 0;
} //end of implement();

/* 2nd pass, produce output */
int readLines(ofstream& fw) {
  string out = "";
  int msb = 0;
  bool lab_found = false;
  int lsb = 0;

  //fill with HLT, from 0 to ORG_arg
  if (org != 0) {
    int zero = 0;
    int w = 0;
    char y = (char) zero;
    while (w < org) { //print 00000000
      fputc(y, fw);
      w++;
    }
  }

//read each line of input, break down
  for (int i = org; i < line_count; i++) {
    string s = input[i];
    string instruct = s.substr(0, 3);
    int dec_instruct = findOp(instruct); //match opcode

    msb = dec_instruct;
    if (dec_instruct < -5) {
      fprintf(stderr, "An invalid op-code was encountered (this includes EXT 0).\n");
      return 5;
    }
    string remain = s.substr(3); //starts from a space
    size_t alpha2 = remain.find_first_of(
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890+-");
      if (alpha2 == 0) { //ex. LDAA
        fprintf(stderr, "An invalid op-code was encountered (this includes EXT 0).\n");
        return 5;
      }

      if (dec_instruct < 15) { //opcode needs argument
        if (alpha2 == std::string::npos) { //has no argument but need arg
          fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
          return 6;
        }
        //get argument
        remain = remain.substr(alpha2);
        size_t space = remain.find(" ");
        size_t tab = remain.find("\t");
        size_t  eol = remain.find("\n");
        int  eoa = 0;
        string arg;
        if (space == std::string::npos && tab == std::string::npos) {
          eoa = eol; //arg\n
        } else if (space == std::string::npos && tab != std::string::npos) {
          eoa = tab; //arg\t
        } else if (space != std::string::npos && tab == std::string::npos) {
          eoa = space; //arg_
        } else if (space != std::string::npos && tab != std::string::npos) {
          if (space < tab) {
            eoa = space;
          } else {
            eoa = tab;
          }
        }
        arg = remain.substr(0, eoa); //only includes argument
        //make sure rest of line is blank
        string emp = remain.substr(eoa);
        for (int j = 0; j < (int) emp.length(); j++) {
          char c = emp.at(j);
          if ((isblank(c) == 0) && (c != '\n')) {
            fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
            return 6;
          }
        }
        //is argument label or number?
        int arg_start = remain.find_first_of(
          "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

          if (arg_start == 0) { //argument is label
            //check to see if it is in labels
            for (int k = 0; k < (int) labels.size(); k+=2) {
              string q = labels.at(k);
              if (arg.compare(q) == 0) {
                string z = labels.at(k+1);
                int x = stoi(z, nullptr, 0);
                if (x == i) { // label4: OPC label4
                  fprintf(stderr, "An invalid op-code was encountered (this includes EXT 0).\n");
                  return 5;
                }
                lab_found = true;
                lsb = x;
                if (dec_instruct == 0) { //EXT label
                  if (lsb < 15) { //0000xxxx
                    fprintf(stderr, "An invalid op-code was encountered (this includes EXT 0).\n");
                    return 5;
                  }
                }
              }
            }
            if (lab_found == false) {
              fprintf(stderr, "There was an unresolved reference (missing label).\n");
              return 8;
            }
          } else { //not label, change to decimal
            if (arg.find(".") != std::string::npos) {
              fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
              return 6;
            }
            long l = stol(arg, nullptr, 0);
          //check argument range
          //is JMP or JMZ or DAT
          if ((dec_instruct == 7) || (dec_instruct == 8) || (dec_instruct == -1)) {
            if ((l < -128) || (l > 255)) {
              fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
              return 6;
            }
          } else if (dec_instruct == 0) { //is EXT
            if (l == 0) {
              fprintf(stderr, "An invalid op-code was encountered (this includes EXT 0).\n");
              return 5;
            }
          } else { //all other operations
            if ((l < -8) || (l > 15)) {
              fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
              return 6;
            }
          }
          lsb = (int) l;
        }
      } else if (dec_instruct > 14) { //opcode doesn't need argument
      if (alpha2 != std::string::npos) {
        fprintf(stderr, "An invalid argument was encountered (for instance it’s too large or it’s not an integer).\n");
        return 6;
      }
      msb = 15;
      lsb = dec_instruct - 15;
    }
    //change HLT from 16 to 0
    if (instruct.compare("HLT") == 0) {
      msb = 0;
      lsb = 0;
    } else if (instruct.compare("DAT") == 0) { //entire 8 bit is stored
      msb = 0;
    }

    //convert dec to binary, print
    if (lsb < 0) {
      lsb = ~lsb + 1;
    }
    msb = msb << 4;
    int d = msb + lsb;
    char y = (char) d;
    fputc(y, fw);
  } //end of for loop

  //fill remaining bytes with HLT
  if ((line_count - 1) < 255) {
    int zero = 0;
    char z = (char) zero;
    int e = line_count - 1;
    while (e < 255) { //print 00000000
      fputc(z, fw); //0000
      e++;
    }
  }
  fw.close();
  return 0;
} //end of function

/* find opcode and return integer */
int findOp(std::string instruct) {
  if (instruct.compare("DAT") == 0) {
    return -1;
  }
  if (instruct.compare("HLT") == 0) {
    return 31;
  }
  if (instruct.compare("EXT") == 0) {
    return 0;
  }
  if (instruct.compare("LDA") == 0) {
    return 1;
  }
  if (instruct.compare("LDI") == 0) {
    return 2;
  }
  if (instruct.compare("STA") == 0) {
    return 3;
  }
  if (instruct.compare("STI") == 0) {
    return 4;
  }
  if (instruct.compare("ADD") == 0) {
    return 5;
  }
  if (instruct.compare("SUB") == 0) {
    return 6;
  }
  if (instruct.compare("JMP") == 0) {
    return 7;
  }
  if (instruct.compare("JMZ") == 0) {
    return 8;
  }
  if (instruct.compare("AND") == 0) {
    return 9;
  }
  if (instruct.compare("IOR") == 0) {
    return 10;
  }
  if (instruct.compare("XOR") == 0) {
    return 11;
  }
  if (instruct.compare("ADL") == 0) {
    return 12;
  }
  if (instruct.compare("ADC") == 0) {
    return 13;
  }
  if (instruct.compare("SBB") == 0) {
    return 14;
  }
  if (instruct.compare("NEG") == 0) { // NO ARG
    return 15;
  }
  if (instruct.compare("COM") == 0) {
    return 16;
  }
  if (instruct.compare("CLR") == 0) {
    return 17;
  }
  if (instruct.compare("SET") == 0) {
    return 18;
  }
  if (instruct.compare("RTL") == 0) {
    return 19;
  }
  if (instruct.compare("RTR") == 0) {
    return 20;
  }
  if (instruct.compare("LSL") == 0) {
    return 21;
  }
  if (instruct.compare("LSR") == 0) {
    return 22;
  }
  if (instruct.compare("ASR") == 0) {
    return 23;
  }
  if (instruct.compare("TST") == 0) {
    return 24;
  }
  if (instruct.compare("CLC") == 0) {
    return 25;
  }
  if (instruct.compare("SEC") == 0) {
    return 26;
  }
  if (instruct.compare("TCA") == 0) {
    return 27;
  }
  if (instruct.compare("TVA") == 0) {
    return 28;
  }
  if (instruct.compare("JAL") == 0) {
    return 29;
  }
  if (instruct.compare("NOP") == 0) {
    return 30;
  }
  return -10;
} //end of function
