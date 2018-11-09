<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=default"></script>

### HashCode and equal()
1. 如果两个对象相等，则 hashcode 一定也是相同的
2. 两个对象相等,对两个对象分别调用 equals 方法都返回true
3. 两个对象有相同的 hashcode 值，它们也不一定是相等的
4. 因此，equals方法被覆盖过，则hashCode方法也必须被覆盖
5. hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）

### unchecked / checked
1) Checked: are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using throws keyword.
2) Unchecked are the exceptions that are not checked at compiled time.

### final, finally and finalize
a) Final is a keyword. Final is used to apply restrictions on class, method and variable. Final class can't be inherited, final method can't be overridden and final variable value can't be changed.	
b) Finally is a block. Finally is used to place important code, it will be executed whether exception is handled or not.	
c) Finalize is a method. Finalize is used to perform clean up processing just before object is garbage collected.


### String, StringBuilder, StringBuffer
StringBuffer is thread safe, only allow one thread at a time
StringBuffer allows multiple thread at a time


### polymorphism
    Salary s = new Salary();
    Employee e = new Salary();
    s.mailCheck();
    e.mailCheck();
at this time, s and e use the same method.



### What is the difference between public, protected, package-private and private in Java?

            │ Class │ Package │ Subclass │ Subclass │ World
            │       │         │(same pkg)│(diff pkg)│ 
────────────┼───────┼─────────┼──────────┼──────────┼────────
public      │   +   │    +    │    +     │     +    │   +     
────────────┼───────┼─────────┼──────────┼──────────┼────────
protected   │   +   │    +    │    +     │     +    │         
────────────┼───────┼─────────┼──────────┼──────────┼────────
no modifier │   +   │    +    │    +     │          │    
────────────┼───────┼─────────┼──────────┼──────────┼────────
private     │   +   │         │          │          │    

+ : accessible
blank : not accessible



## String vs StringBuilder vs StringBuffer
|         | String               | StringBuilder                                      | StringBuffer                                       |
|---------|----------------------|----------------------------------------------------|----------------------------------------------------|
| mutable | :(                   | yes                                                | yes                                                |
| feature | :)                   | API, fast                                          | thread support                                     |
| concat  | s1 = s1 + "text" | s2.append("text")                                  | s3.append("text")                                  |
| del     | str.substring(0, 20) | delete(int start, int end)/deleteChatAt(int index) | same |

https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/


## String 奇淫巧技


### List to String
```java
List<String> list = Arrays.asList("foo", "bar", "baz");
String joined = String.join(" and ", list); 
```

### startsWith 
Tests if this string starts with the specified prefix.

### String Char plus, to Char Array, char At 
```java
String str = "";
char n = 'abc';
str += n; 
// 1. output: "abc"
str.toCharArray();
// 2. output: ['a', 'b', 'c']
str.charAt(str.length() - 1);
// 3. output: "ab"
String b = new String(a); // char[] a = {'a','b'}; 
// 4. char Array to String
```

### Char to Int
```java
Integer.parseInt(str);

charNum - '0';
str.charAt(startIndex) - '0';
```