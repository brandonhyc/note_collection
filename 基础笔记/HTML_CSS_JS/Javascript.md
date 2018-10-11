### Pros and Cons of JS
Pros: less server interaction, increase interactive; Cons:  file support in client size. no mutithreading capability

## what is event
The event is created when the user or browser manipulate the page. g.g.: onload, onclick
### How to use addEventListener
```js
// <input type="button" id="a" />
var ele = document.getElementById("a");
ele.addEventListener(function() {
    console.log("clicked");
});
```
### onkeydown, onkeypress, onkeyup
onkeydown is when key is press, onkeyup is when key is release and onkeypress is pressed and release


### Array modification
1. push/pop, modify from the back
2. unshift/shift, modify from the front
3. splice/slice, splice to remove in-place, slice is substring

### Where to put <script> tag?
Either head or body. But if it is linked to DOM, we have to put it within or after body.  

### What is block scope, local scope, global scope
* The block scope refers to if/for block where have access to all declared variable within it.
* The local scope refers to function block where have access to all declared variable within it.
* The global scope refers to variables can be read in local scope.

### 必考 let vs var
var can be read outside the block scope, let can be only read within a block scope. In strict mode, let can't redeclare, but var can.

### 必考 JS Declarations, Initialization and Hoisting
1. Hoisting is JavaScript's default behavior of moving all declarations to the top of the current scope. Function can be called before the declaration.
2. JavaScript only hoists declarations, not initialization (literal expression)

```javascript
x = 5; // Assign 5 to x
elem = document.getElementById("demo"); // Find an element 
elem.innerHTML = x;                     // Display x in the element
var x; // Declare x
// Result: 5
```
```javascript
var x = 5; // Initialize x
var y;     // Declare y
elem = document.getElementById("demo"); // Find an element 
elem.innerHTML = x + " " + y;           // Display x and y
y = 7;    // Assign 7 to y
//Result: 5, undefined
```
### 必考 闭包 Closure
An inner function always has assess to all parameters(scope) of the outer function 

定义一个函数能够读取其他函数内部变量的函数和该函数的创建环境. 
一个是可以读取函数内部的变量，另一个就是让这些变量始终保持在内存中，即闭包可以使得它诞生环境一直存在。
闭包的另一个用处，是封装对象的私有属性和私有方法。

### What is Cookie, and fields
In stateless HTTP protocol, web pages using Cookie to maintain session information among pages to track user behaviors. 5 fields, expire, domain, path, secure, key/value pairs

### JSON
JSON is a format for storing and exchanging data, easy to read and write for human and generate and parse by machine.


# JS PROTOTYPE
# IIFE
定义一个IIFE如下. 
```javascript
(function () {
  var tmp = 10;
  processData(tmp);
  storeData(tmp);
}());
```

### fetch
https://segmentfault.com/a/1190000003810652

### Pure JS way
````javascript
    function foo(){}
    foo.prototype = {
        foo_prop: "foo val"
    };
    function bar(){}
    var proto = new foo;
    proto.bar_prop = "bar val";
    bar.prototype = proto;
    var inst = new bar;
    console.log(inst.foo_prop);
    console.log(inst.bar_prop);
````

### ES5 Object.create()
````javascript
    function foo(){};
    foo.prototype = {
        foo_prop: "foo val"
    }
    function bar(){}
    var proto = Object.create(foo.prototype);
    proto.bar_prop = "bar val";
    bar.prototype = proto;
    var inst = new bar;
    console.log(inst.foo_prop);
    console.log(inst.bar_prop);
````

### ES6 Class
````javascript
    'use strict';

    class Polygon {
        constructor(height, width) {
            this.height = height;
            this.width = width;
        }
    }

    class Square extends Polygon {
        constructor(sideLength) {
            super(sideLength, sideLength);
        }
        get area() {
            return this.height * this.width;
        }
        set sideLength(newLength) {
            this.height = newLength;
            this.width = newLength;
        }
    }

    var square = new Square(2);

````

# AJAX
### 什么是AJAX? 
Asynchronous JavaScript and XML，意思就是用JavaScript执行异步网络请求。

假如我们使用Form, 用户submit后会出现白页, 等待返回并刷新网页, 可能会很慢, 有不好的用户体验. 如果采用ajax,用户可以停留在当前页, 在返回数据后再用js刷新数据, 体验会好很多.

### XMLHttpRequest对象
过去 AJAX 主要依靠 XMLHttpRequest对象实现的:
```js
"use strict"
let request = new XMLHttpRequest();
request.onreadystatechange = requestReadyCallback;
request.open('GET', '/api/categories');
request.send();

function requestReadyCallback() {
    requestReady(success, fail);

    function requestReady(success, fail) {
        if (request.readyState == 4) {
            (request.status === 200) ? 
                success(request.responseText) : fail(request.status);
        } else {
            console.log("HTTP request: still waiting for response ")
        }
    };

    function success(text) {
        let textarea = document.querySelector("#test-response-text");
        textarea.value = text;
    }
    function fail(code) {
        let textarea = document.querySelector("#test-response-text");
        textarea.value = 'Error code: ' + code;
    }
}


```

参考: JS教程, AJAX, 廖雪峰 https://www.liaoxuefeng.com/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001434499861493e7c35be5e0864769a2c06afb4754acc6000


## 跨域

### 安全限制
进行跨域URL请求, 无效. 这是因为默认情况下，JavaScript 在发送AJAX请求时，URL的域名必须和当前页面完全一致。<br>
非跨域, 即要求以下相同 n级域名(www), http协议(https不同), 端口号.
* 一是FLASH
* 二是通过在同源域名下架设一个代理服务器来转发，JavaScript负责把请求发送到代理服务器. 弊端是涉及后端开发.
```
'/proxy?url=http://www.sina.com.cn'
```
* 三是JSONP，限制是只能用GET请求，并且要求返回JavaScript。利用script可以跨域加载的方式. 
* 四是CORS, 全称Cross-Origin Resource Sharing，HTML5的跨域新规范。也要求后端开发.


### JSONP
```html
<body>
    <button onclick="updateData()">点</button>
    <p id="test-jsonp">假如成功的话, 这里更新</p>
</body>
<script>
    function refreshPrice(data) { // callback function
        var p = document.getElementById('test-jsonp');
        p.innerHTML = '当前价格：' + data['1399001'].name + ': ' + data['1399001'].price;
    }
    function updateData() {
        // dynamically insert script. Two functions by using this: 
        // 1. fetch data from api 2. callback(refreshPrice) 
        var js = document.createElement('script'), head = document.getElementsByTagName('head')[0];
        js.src = 'http://api.money.126.net/data/feed/0000001,1399001?callback=refreshPrice';
        head.appendChild(js);
    }
</script>
```

# Promise

````javascript
doSomething().then(function(result) {
  return doSomethingElse(result);
})
.then(function(newResult) {
  return doThirdThing(newResult);
})
.then(function(finalResult) {
  console.log('Got the final result: ' + finalResult);
})
.catch(failureCallback);
````

````javascript

  function imgLoad(url) {
    // Create new promise with the Promise() constructor;
    // This has as its argument a function
    // with two parameters, resolve and reject
    return new Promise(function(resolve, reject) {
      // Standard XHR to load an image
      var request = new XMLHttpRequest();
      request.open('GET', url);
      request.responseType = 'blob';
      // When the request loads, check whether it was successful
      request.onload = function() {
        if (request.status === 200) {
        // If successful, resolve the promise by passing back the request response
          resolve(request.response);
        } else {
        // If it fails, reject the promise with a error message
          reject(Error('Image didn\'t load successfully; error code:' + request.statusText));
        }
      };
      request.onerror = function() {
      // Also deal with the case when the entire request fails to begin with
      // This is probably a network error, so reject the promise with an appropriate message
          reject(Error('There was a network error.'));
      };
      // Send the request
      request.send();
    });
  }
  // Get a reference to the body element, and create a new image object
  var body = document.querySelector('body');
  var myImage = new Image();
  // Call the function with the URL we want to load, but then chain the
  // promise then() method on to the end of it. This contains two callbacks
  imgLoad('myLittleVader.jpg').then(function(response) {
    // The first runs when the promise resolves, with the request.response
    // specified within the resolve() method.
    var imageURL = window.URL.createObjectURL(response);
    myImage.src = imageURL;
    body.appendChild(myImage);
    // The second runs when the promise
    // is rejected, and logs the Error specified with the reject() method.
  }, function(Error) {
    console.log(Error);
  });

````