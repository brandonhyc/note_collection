
class maxQueue {
    PriorityQueue<Node> queue;
    DoubleLinkedList list;
    public maxQueue() {
        queue = new PriorityQueue<>((a,b)->(b.val-a.val));
        list = new DoubleLinkedList();
    }


    public int size() {
        return list.length();
    }
    public void inQueue(int val) {
        list.addLast(val);
        queue.offer(list.getTail());
    }
    public int deQueue() throws Exception {
        if (list.length() <= 0) { throw new Exception("Empty!"); }
        Node node = list.popLast();
        queue.remove(node);
        return node.val;
    }
    public int getMax() throws Exception {
        if (list.length() <= 0) { throw new Exception("Empty!"); }
        Node node = queue.poll();
        list.remove(node);
        return node.val;
    }

public static void main(String[] args) throws Exception {
     maxQueue maxQ = new maxQueue();
        maxQ.inQueue(5);
        maxQ.inQueue(3);
        maxQ.inQueue(4);
        maxQ.inQueue(9);
        maxQ.inQueue(25);
        maxQ.inQueue(1);
        maxQ.inQueue(0);
        System.out.println(maxQ.getMax());
        System.out.println(maxQ.deQueue());
        System.out.println(maxQ.deQueue());
        System.out.println(maxQ.getMax());
        System.out.println(maxQ.deQueue());
        System.out.println(maxQ.deQueue());
        System.out.println(maxQ.deQueue());
    }

}

class Node {
    int val;
    Node prev;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}


class DoubleLinkedList {
    private int size;
    private Node head;
    private Node tail;
    public DoubleLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int length() {
        return size;
    }
    public Node getTail() {
        return tail;
    }
    public boolean addFirst(int val) {
        // check whether list is empty
        if (size == 0) {
            head = new Node(val);
            head.next = head;
            head.prev = head;
            tail = head;
        } else {
            Node node = new Node(val);
            node.next = head;
            node.prev = head.prev;
            head.prev = node;
            node.prev.next = node;
            head = node;
        }
        size++;
        return true;
    }
    public boolean addLast(int val) {
        // check size
        if (size == 0) {
            head = new Node(val);
            head.next = head;
            head.prev = head;
            tail = head;
        } else {
            Node node = new Node(val);
            node.prev = tail;
            tail.next = node;
            node.next = head;
            head.next = node;
            tail = node;
        }
        size++;
        return true;
    }
    public Node popFirst() {
        if (size == 0) { return null; }
        Node node = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return node;
    }
    public Node popLast() {
        if (size == 0) { return null; }
        Node node = tail;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        return node;
    }

    public void remove(Node node) {
        if (node == head) {
            popFirst();
        } else if (node == tail) {
            popLast();
        } else {
            Node prev = node.prev;
            prev.next = node.next;
            prev.next.prev = prev;
            size--;
        }

    }



public static String minWindow(String s, Set<Character> t) {
   if (s.length() < t.size()) {
          return "";
      }            
      char[] scArr = s.toCharArray();               
      int[] hash = new int[256];            
      for(char c:t) {
          hash[c]++;
      }                    
      int left = 0, count = t.size(), min = s.length() + 1;
      String res = "";
      for (int right = 0; right < scArr.length; ++right) {
          hash[scArr[right]]--;               
          if (hash[scArr[right]] >= 0) {
              count--;
          }               
          while (left < right && hash[scArr[left]] < 0) {
              hash[scArr[left]]++;
              left++;
          }               
          if (count == 0 && min > right - left + 1) {
           min = right - left + 1;
              res = s.substring(left, right + 1);
          }
      }

      return res;
   }


public static void main(String[] args) {
  // TODO Auto-generated method stub
  Set<Character> set=new HashSet<>();
  set.add('B');set.add('A');set.add('C');

   System.out.println(minWindow("ADOBECODEBANC", set));
}


public static int evalRPN(String[] tokens) {         
        int res = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        res = Integer.valueOf(stack.pop());
        return res;
    }


public static void main(String[] args) {
  // TODO Auto-generated method stub
    System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"}));
}






public class FirstUniqueCharacterInAString {
  public int firstUniqChar(String s) {
         int[] cnt = new int[26];
         for (char c : s.toCharArray()) {
             cnt[c - 'a']++;
         }
         for (int i = 0; i < s.length(); i++) {
             if (cnt[s.charAt(i) - 'a'] == 1) {
                 return i;
             }
         }
         return -1;
     }
}



public class ValidNumber_noExp {
public static boolean isNumber(String s){
        s = s.trim();
        boolean signSeen = false,
                digitSeen = false,
                dotSeen = false;

        for(char c : s.toCharArray()) {
            if ( c == '-' || c == '+') {
                if (signSeen || digitSeen || dotSeen) {
                    return false;
                }                        
                signSeen = true;
            }
            else if ( c == '.') {
                if (dotSeen )    return false;            
                dotSeen = true;
            }
            else if ( c >= '0' && c <= '9') {         
                digitSeen = true;
            }
            else {
                return false;
            }
        }


        if (!digitSeen) {
            return false;
        }
        else {
           return true;
        }


    }
}



public boolean isNumber(String s){
        s = s.trim();
        boolean signSeen = false,
                digitSeen = false,
                digitSeenAfterExp = false,
                expSeen = false,
                dotSeen = false;
        char prev = ' ';

        for(char c : s.toCharArray()) {
            if ( c == '-' || c == '+') {
                if( (signSeen || digitSeen || dotSeen) && prev != 'e') {
                    return false;
                }                        
                signSeen = true;
            }
            else if ( c == 'e') {
                if(expSeen || !digitSeen) {
                    return false;
                }
                expSeen = true;
            }
            else if ( c == '.') {
                if (dotSeen || expSeen) {
                    return false;
                }
                dotSeen = true;
            }
            else if ( c >= '0' && c <= '9') {
                if(expSeen) {
                    digitSeenAfterExp = true;
                }
                digitSeen = true;
            }
            else {
                return false;
            }
            prev = c;
        }


        if (!digitSeen) {
            return false;
        }
        else if(expSeen && !digitSeenAfterExp) {
            return false;
        }
        else {
           return true;
        }


    }


public class MaximumProductSubarray_needReturnTheSubarray {
public static int maxProduct(int[] nums,int limit) {
     int[] max = new int[nums.length];
     int[] min = new int[nums.length];

     max[0] = min[0] = nums[0];
     int res = nums[0];

     for(int i=1; i<nums.length; i++){
         if(nums>0){
             max=Math.max(nums, max[i-1]*nums);
             min=Math.min(nums, min[i-1]*nums);
         }else{
             max=Math.max(nums, min[i-1]*nums);
             min=Math.min(nums, max[i-1]*nums);
         }

         if(max<=limit)res = Math.max(res, max);
     }

     return res;
}




public static void main(String [] args){
  System.out.println(maxProduct(new int[] {1,-2,3,-4,4,-3},60));
}
        

public class MaximumSubarray_needReturnTheSubarray {

    static int[] maxSubArraySum(int[] nums) {
     int maxSum = Integer.MIN_VALUE,
        sum = 0,left = 0,
        right = 0, s = 0;
     int[] res=new int[3];
        for (int i = 0; i < nums.length; i++){
         sum += nums;
            if (maxSum < sum){
             maxSum = sum;
             left = s;
             right = i;
            }  
            if (sum < 0){
             sum = 0;
                s = i + 1;
            }
        }
        res[0]=left;
        res[1]=right;
        res[2]=maxSum;
        return res;
    }

    static int maxSubArrayLengthAtLeastK(int[] nums,int k) {
     int maxSum[]=new int[nums.length];
     maxSum[0]=nums[0];
     int curMax=nums[0];
     for(int i=1;i<nums.length;i++) {
      curMax=Math.max(nums, curMax+nums);
      maxSum=curMax;
     }
     int sum=0;
     for(int i=0;i<k;i++)sum+=nums;
     int res=sum;
     for(int i=k;i<nums.length;i++) {
      sum=sum+nums-nums[i-k];
      res=Math.max(res, sum);
      res=Math.max(res, sum+maxSum[i-k]);
     }
     //System.out.print("maxSum");
        //for(int i:maxSum) {
        //    System.out.print(i+" ");
        //    System.out.println();
       // }
        //System.out.print("maxSum");
     return res;
    }

    // dp, array end at current i which length
    //at least k

    public static int maxSubK(int[] nums,int k) {
     int[] dp=new int[nums.length];
     dp[0]=nums[0];
     for(int i=1;i<nums.length;i++) {
      dp=Math.max(dp[i-1]+nums,nums);
     }
     int twoSum=0;
     for(int i=0;i<k;i++)twoSum+=nums;
     int res=twoSum;
     for(int i=k;i<nums.length;i++) {
      twoSum+=nums;
      twoSum-=nums[i-k];
      res=Math.max(twoSum+Math.max(0, dp[i-k]), res);
     }
     return res;
    }

public static void main(String[] args) {
  // TODO Auto-generated method stub
  int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
  int[] res=maxSubArraySum(nums);

        for(int i:res) {
            System.out.print(i+" ");
            System.out.println();
        }
        System.out.println(maxSubArrayLengthAtLeastK(nums,7));
        System.out.println(maxSubArrayLengthAtLeastK(new int[] {1,2,3,4,5},2));
        System.out.println(maxSubArrayLengthAtLeastK(new int[] {-1,-1,-2,-3,-4},2));
        System.out.println(maxSubArrayLengthAtLeastK(new int[] {7,9,-3,-4,-8,16},2));
        System.out.println(maxSubArrayLengthAtLeastK(new int[] {-1,32},2));
        System.out.println(maxSubK(new int[] {1,2,3,4,5},2));
        System.out.println(maxSubK(new int[] {-1,-1,-2,-3,-4},2));
        System.out.println(maxSubK(new int[] {7,9,-3,-4,-8,16},2));
        System.out.println(maxSubK(new int[] {-1,32},2));
}

}



   public static String textJustify(String text,int maxLength) {
     String[] words=text.split(" ");
     if(words.length==1) {
      return words[0]+fillWithSpace(maxLength-words[0].length());
     }
     int totalSpace=maxLength-countCharInWords(words);
     int numSpace=words.length-1;
     String aveSpace=fillWithSpace(totalSpace/numSpace);
     int remain=totalSpace%numSpace;
     StringBuilder line=new StringBuilder();
     for(int i=0;i<words.length-1;i++) {
      line.append(words);
      line.append(aveSpace);
      line.append(remain-->0?" ":"");
     }
     line.append(words[words.length-1]);
     line.append(fillWithSpace(maxLength-line.length()));
     return line.toString();
    }

    public static String fillWithSpace(int n) {
     StringBuilder sb=new StringBuilder();
     for(int i=0;i<n;i++) {
      sb.append(" ");
     }
     return sb.toString();
    }

    public static int countCharInWords(String[] words) {
     int res=0;
     for(String word:words) {
      res+=word.length();
     }
     return res;
    }



public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
         List<String> res = new ArrayList<String>();
         List<String> list = new ArrayList<String>();
         int length = 0;
         for(String w: words) {
             if((length + w.length() + (list.size()-1)) >= maxWidth) {
                 adjustOneLine(res, list, length, maxWidth, false);
                 length = 0;
                 list.clear();
             }

             length += w.length();
             list.add(w);
         }               
         adjustOneLine(res, list, length, maxWidth, true);      
         return res;
     }

     private void adjustOneLine(List<String> res, List<String> cWords, int wLength, int maxWidth, boolean lastLine) {
         StringBuilder sb = new StringBuilder();
         int spaces = maxWidth - wLength;
         int wCount = cWords.size();
         int spaceBetween = (wCount == 1) ? spaces : spaces/(wCount-1);
         int rem = (wCount == 1) ? 0 : spaces%((wCount-1));
         if(lastLine) { spaceBetween = 1; rem = 0; }
         for(String w: cWords) {
             sb.append(w);
             if(rem-- > 0) sb.append(" ");
             for(int i=0; i<spaceBetween && sb.length() < maxWidth; i++) sb.append(" ");
         }
         for(int i=sb.length(); i<maxWidth; i++) sb.append(" ");              
         res.add(sb.toString());
     }

     public static void main(String [] args){
      TextJustification test=new TextJustification();
      String[] words1= {"This", "is", "an", "example", "of", "text", "justification."};
      //String[] words2= {"What","must","be","acknowledgment","shall","be"};
      List<String>  res1=test.fullJustify(words1, 16);
     //        List<String>  res2=test.fullJustify(words2, 16);
      System.out.println(res1);
      //System.out.println(res2);
     }




}
