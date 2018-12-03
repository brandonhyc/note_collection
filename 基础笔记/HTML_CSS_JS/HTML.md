# HTML

### doctype tag
The Instruction for using HTML5

### 必考 HTML5有哪些新特性
    1. new Api: Geolocation, drag, drop
    2. friendly Elements:  article footer header nav section
    3. new elements: canvas, video, audio
    4. localStorage, sessionStorage
    5. simplified syntax

### HTML4 vs HTML5
remove: ``` font, basefont, big, strike, center, tt, frame, noframes, frameset ```<br>
new: ```nav, article, section, footer, header, audio, video, canvas, figure, datalist ```

### Uses of HTML
Publish online documents with headings, texts, tables, lists, photos, etc.
Retrieve online information via hypertext links.
Design forms for conducting transactions with remote services, for use in
searching for information, making reservations, ordering products, etc.

### uses of <meta>
meta tag is for setting up the metadata for html document. It can be used to set up the viewport which is user's visible area.


## <a> uses
### How to set an email link
href="mailto:xxxx@yahoo.com"
### <a> what is the use of target?
*target="_self"* by default, *target="_blank"* start a new page

## HTML Entities Symbols
Some reserved characters can be replaced by some with character entities in HTML

## Unordered List
### Unordered List example 
```
<ul>
    <li></li>
    <li></li>
</ul>
```
### How to set no disc style list
set list-style-type: none

## Ordered List 
### Ordered List example

### How to set numbered order
set type="A" / type="1"

### How to set length of <HR>
width=50%

### Difference between SUBMIT and BUTTON
SUBMIT button triggers sending the form. BUTTON can be used differently  


## 常见面试难点


3. cookies，sessionStorage 和 localStorage 的区别？
cookies 是为了标识用户身份而存储在用户本地终端上的数据，始终在同源http请求中携带，即cookies在浏览器和服务器间来回传递，而sessionstorage和localstorage 不会自动把数据发给服务器，仅在本地保存。
cookie过期时间之前一直有效，即使窗口关闭。sessionstorage 窗口关闭失效。localstorage 用作长久数据保存。



6. Why is it generally a good idea to position CSS < link> between < head>< /head> and JS < script> just before < /body>? 
You usually put the < link> tags in between the < head> to prevent __Flash of Unstyled Content__ which gives the user something to look at while the rest of the page is being parsed.

7. 事件机制 
    1. document 往 target节点，捕获前进，遇到注册的捕获事件立即触发执行
    2. 到达target节点，触发事件（对于target节点上, 先注册先执行）
    3. target节点 往 document 方向，冒泡前进，遇到注册的冒泡事件立即触发

点击s2，click 事件从 document->html->body->s1->s2(捕获前进)<br>
这里在s1上发现了捕获注册事件，则输出"s1 捕获事件"<br>
到达s2，已经到达目的节点，<br>
s2上注册了冒泡和捕获事件，先注册的冒泡后注册的捕获，则先执行冒泡，输出"s2 冒泡事件"<br>
再在s2上执行后注册的事件，即捕获事件，输出"s2 捕获事件"<br>
下面进入冒泡阶段，按照s2->s1->body->html->document(冒泡前进)<br>
在s1上发现了冒泡事件，则输出"s1 冒泡事件"

查看EXAMPLE: 
http://jsfiddle.net/brandonhyc/0b8eLmp1/





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
the BUTTON element may have content, so it's easier to style<br>
button type<br>
submit ||  "submits the form when clicked (default)"<br>
reset  ||  "resets the fields in the form when clicked"<br>
button ||  "clickable, but without any event handler until one is assigned"<br>
    