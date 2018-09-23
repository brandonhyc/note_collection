<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=default"></script>


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