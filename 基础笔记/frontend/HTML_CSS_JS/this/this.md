参考文章： http://www.cnblogs.com/TomXu/archive/2012/01/17/2310479.html

### 判断方法
(non-strict mode)
1. if referenceType, this = reference.base
2. if (new) object, this = that object 
3. if null, this = global
4. else this = undefined (global);


## 常见错误示例
```js
var foo = {x: 10};
 
var bar = {
  x: 20,
  test: function () {
    alert(this === bar); // true
    alert(this.x); // 20
  }
};
 
// 在进入上下文的时候
// this被当成bar对象
 
bar.test(); // true, 20
 
foo.test = bar.test;
 
// 不过，这里this依然不会是foo
// 尽管调用的是相同的function
 
foo.test(); // false, 10
```

```js
var foo = {
  bar: function () {
    alert(this);
    alert(this === foo);
  }
};
 
foo.bar(); // foo, true
 
var exampleFunc = foo.bar;
 
alert(exampleFunc === foo.bar); // true
 
// 再一次，同一个function的不同的调用表达式，this是不同的
 
exampleFunc(); // global, false
```