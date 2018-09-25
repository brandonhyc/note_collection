# 前端面试总结
1. inline element vs block element 不同之处
2. button vs input type submit 不同之处 & form 里面的method 的区别 get and post. 
3. css position : static, relative, absolute, sticky. 不知道为什么这个考官说没有sticky这个值。。明明MDN里面看到过
4. js prototype， inheritance, promise
5. jquery $ 可以用什么代替.

6. angularjs 里面的controller作用


# HTML
1. link和@import有什么区别？
    1. link除了加载css外，还可以定义RSS等其他事务；@impor t属于CSS范畴，只能加载CSS
    2. link引用CSS时候，页面载入时同时加载；@import需要在页面完全加载以后加载，而且@import被引用的CSS会等到引用它的CSS文件被加载完才加载

2. HTML5有哪些新特性
    
    1. new Api: Geolocation, drag, drop
    2. friendly Elements:  article footer header nav section
    3. new elements: canvas, video, audio
    4. localStorage, sessionStorage
    5. web worker..

3. cookies，sessionStorage 和 localStorage 的区别？
cookies 是为了标识用户身份而存储在用户本地终端上的数据，始终在同源http请求中携带，即cookies在浏览器和服务器间来回传递，而sessionstorage和localstorage 不会自动把数据发给服务器，仅在本地保存。
cookie过期时间之前一直有效，即使窗口关闭。sessionstorage 窗口关闭失效。localstorage 用作长久数据保存。


5. doctype tag
it is an instruction to the web browser about what version of the markup language the page is written in

6. Why is it generally a good idea to position CSS <link> between <head></head> and JS <script> just before </body>? 
You usually put the <link> tags in between the <head> to prevent __Flash of Unstyled Content__ which gives the user something to look at while the rest of the page is being parsed.

7. 事件机制
    1. document 往 target节点，捕获前进，遇到注册的捕获事件立即触发执行
    2. 到达target节点，触发事件（对于target节点上, 先注册先执行）
    3. target节点 往 document 方向，冒泡前进，遇到注册的冒泡事件立即触发

点击s2，click 事件从 document->html->body->s1->s2(捕获前进)
这里在s1上发现了捕获注册事件，则输出"s1 捕获事件"
到达s2，已经到达目的节点，
s2上注册了冒泡和捕获事件，先注册的冒泡后注册的捕获，则先执行冒泡，输出"s2 冒泡事件"
再在s2上执行后注册的事件，即捕获事件，输出"s2 捕获事件"
下面进入冒泡阶段，按照s2->s1->body->html->document(冒泡前进)
在s1上发现了冒泡事件，则输出"s1 冒泡事件"

8. GET/POST
The form-data can be sent as URL variables (with method="get") or as HTTP post transaction (with method="post").

Notes on GET:
* Appends form-data into the URL in name/value pairs
* The length of a URL is limited (about 3000 characters)
* Never use GET to send sensitive data! (will be visible in the URL)
* Useful for form submissions where a user want to bookmark the result
* GET is better for non-secure data, like query strings in Google
Notes on POST:
* Appends form-data inside the body of the HTTP request (data is not shown is in URL)
* Has no size limitations
* Form submissions with POST cannot be bookmarked


````html
    <div id="s1">s1
        <div id="s2">s2</div>
    </div>
    <script>
        s1.addEventListener("click",function(e){
                console.log("s1 冒泡事件");         
        },false);
        s2.addEventListener("click",function(e){
                console.log("s2 冒泡事件");
        },false);
                
        s1.addEventListener("click",function(e){
                console.log("s1 捕获事件");
        },true);
                
        s2.addEventListener("click",function(e){
                console.log("s2 捕获事件");
        },true);
    </script>

````


8. Button vs input 
the BUTTON element may have content, so it's easier to style
button type
submit ||  "submits the form when clicked (default)"
reset  ||  "resets the fields in the form when clicked"
button ||  "clickable, but without any event handler until one is assigned"
    

# CSS
1. CSS3有哪些新特性？
    1. CSS3实现圆角（border-radius），阴影（box-shadow），
    2. 对文字加特效（text-shadow），线性渐变（gradient），旋转（transform）
    3. transform translate// 旋转,缩放,定位,倾斜
    6. 媒体查询，多栏布局
    7. border-image

2. position
    * static: it is always positioned according to the normal flow of the page. 
    * fixed: it always stays in the same place even if the page is scrolled *NOT KEEP SPACE*
    * relative: it is positioned relative to its normal position. *KEEP SPACE*
    * absolute: is positioned relative to the nearest positioned ancestor *NOT KEEP SPACE* (instead of positioned relative to the viewport, like fixed).
    * sticky/: An element with position: sticky; is positioned based on the user's scroll position.


3. 行内元素和块元素, inline-block？
答：
常用行内元素（内联元素）：a,br,em,font,i,img,input,label,span,strong,textarea
常用块状元素：center,div,dl,form,h1~h6,hr,ol,p,pre,table,ul
区别：
1) 块级元素会独占一行，其宽度自动填满其父元素宽度; 行内元素不会独占一行，相邻的行内元素会排列在同一行里
2) 块级元素可以设置 width, height属性，行内元素设置width, height无效【注意：块级元素即使设置了宽度，仍然是独占一行的】
3) 块级元素可以设置margin 和 padding. 行内元素的水平方向的padding-left/right,margin-left/right 都产生边距效果，
    但是竖直方向的padding-top,padding-bottom,margin-top,margin-bottom都不会产生边距效果。（水平方向有效，竖直方向无效）
Inline-block: 不独占一行, 可以设置height;
 

 4. 居中方法
    https://juejin.im/post/5b9a4477f265da0ad82bf921?utm_source=gold_browser_extension

    ````css
    //1. absolute + transform
    .wp {
        position: relative;
    }
    .box {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    //2.inline-block
    .wp {
        line-height: 300px;
        text-align: center;
        font-size: 0px;
    }
    .box {
        font-size: 16px;
        display: inline-block;
        vertical-align: middle;
        line-height: initial;
        text-align: left; /* 修正文字 */
    }

    //3.flex
    .wp {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    //4. absolute + margin
    .box {
        position: absolute;;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        margin: auto;
    }
    ````
5. css display
常用: 
block | inline | inline-block;
flex; 
contents | none

6. px, em, rem 有什么区别
px是像素，是固定单位
em是相对于直接父元素单位的大小，em就是倍数，是相对单位
rem是相对于根元素的大小，rem也是倍数，是相对单位


# jQuery
1. $() 也就是 jQuery()


# SQL
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


# JS PROTOTYPE

### 闭包 Closure
一个是前面提到的可以读取函数内部的变量， private variable
另一个就是让这些变量的值始终保持在内存中


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