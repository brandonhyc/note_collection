### Pros and Cons of JS
Pros: less server interaction, increase interactive; Cons: file support in client size. no mutithreading capability

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

# CSS

### what's the benefits using external stylesheet
1. everything is stored within a single file.
2. once changed/updated, the changes are reflected on all other referenced pages
3. pages load quicker once the main CSS file has been cached.

### form template
https://jsfiddle.net/brandonhyc/aq9Laaew/242039/

### how to use single border in table
set css border-collapse: collapse || separate

### default TABLE has no borders, Set border="1"

## Selectors
* Universal selector *
* Descendent selector _ | child selector >
* class/id selector . #
* attribute selector [] 
* pseudo selector :

### 必考 What is the difference between descendent selector and child selector
 _ selector selects all the decedent elements, it does not need to be the immediate child element. > Child selector only select the immediate child element

### pseudo selector
it is used for selecting a special state of a element. for example, there are :hover, :link/:visited

### order of <a> pseudo class
 a:link -> a:visited -> a:hover -> a:active

### CSS what is the default media type
Media query is for defining different style rules for different media types
all/print/screen/speech. The default type is "all"

### 可能考 How to set freezed image background
Background-attachment: fixed;

### What is the used of Overflow
Control the text in container. overflow: visible / hidden / scroll / auto 

### visibility: visible -> hidden vs display: none 
the first one will become blank, and the space will be taken. elment display: none will disappear.

### 必考 inline Element vs Block Element
Block element:- it breaks the default flow and it covers the whole width of the page and brings the next content into next line<br>
inline element :- default flow of placing content of the browser - left to right, it will cover the width as the width of the content<br>
Inline-block: 不独占一行, 可以设置height;<br>
display: inline/block/inline-block

### Box model 必考
/////margin////
/~~~~border~~~/
/~x padding x~/
/~x---------x~/
/~x|content|x~/
/~x---------x~/
/~xxxxxxxxxxx~/
/~~~~~~~~~~~~~/
///////////////

## CSS Box Sizing
box-sizing: content-box / border-box
### content-box (default)
Width and Height are applied to only the content area <br>
width = width of the content<br>
the space width = width + (padding + border + margin) * 2
### border-box
Width and Height are applied to content, padding and border, but not margin.<br>
width = border + padding + width of the content<br>
the space width = width + margin * 2<br>
.box {width: 350px; border: 10px solid black;} renders a box that is 370px wide.

## CSS - Inclusion
4 ways to associate styles with your HTML document
* Embedded CSS - In HTML header < style type="text/css" media="all"></ style>
* Inline CSS - The style Attribute< input style="color: blue;">
* External CSS - The < link/> Element < link type = "text/css" href = "a.css" />
* Imported CSS - @import Rule
```html
<head>
   <@import url("URL");
</head>
```
### Overriding Priority (high -> low)
1. inline < p style=""> 
2. embedded < style> 
3. external/import < link/> 

### Grid System
CSS Grid Layout is used for responsive web app. The web app display different layout in different screen size devices. The grid system divides a page into major regions or defining the relationship in terms of size




