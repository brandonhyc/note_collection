# DBS

## XML vs. JSON

|                       | XML                  | JSON         |
|-----------------------|----------------------|--------------|
| Verbosity/Complexity  | Harder               | Easier       |
| Validity              | DTD.. Widely used    | JSON Schema  |
| Programming Interface | Clunky               | Good         |
| Querying              | Strong. XPath XQuery | JSON Path... |


## Relational Algebra
![avatar](https://i.imgur.com/oDUHI6f.png)
![avatar](https://i.imgur.com/pAzF0rf.png)


# 常见面试题
1. PRIMARY KEY / FOREIGN KEY
The *PRIMARY KEY* constraint uniquely identifies each record in a database table. (UNIQUE AND NON-NULL)
The *FOREIGN KEY* is a key used to link two tables together, 
it is a field in table A that refers to the PRIMARY KEY in table B.

2. JOIN
* (INNER) JOIN: Returns records that have matching values in *both tables*
* LEFT (OUTER) JOIN: Return all records from the left table, and the matched records from the right table, if not match, it will be filled with null
* RIGHT (OUTER) JOIN: Return all records from the right table, and the matched records from the left table
* FULL (OUTER) JOIN: Return all records when there is a match in either left or right table
https://www.jianshu.com/p/e7e6ce1200a4

