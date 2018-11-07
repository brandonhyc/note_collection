<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=default"></script>

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