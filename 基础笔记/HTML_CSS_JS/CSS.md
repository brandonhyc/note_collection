# CSS


## CSS Box model
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

## CSS Common units

### Relative Units
1. %: responsive. body: 100% of viewport. it can be used to set the relative width of parent element
2. em:  `1em` = by default `16px` = `font-size` of the current element,<br> 
** inherited by elements from parents
```html
<div style="font-size: 2em">div outer 32px
  <div style="font-size: 2em">div mid 64px
    <div style="font-size: 2em">div inner 128px</div>       
  </div>
</div>
```
* <NEW FEATURE: NOT SUPPORTED IN OLD IE> *
3. rem: `1rem`= by default `16px` = `font-size` of root
** rems don't support old IE
** To adjusts 1rem equals 10px from default(16px) To set the font-size to the equivalent of 14px, set it to 1.4em.
```css
body { font-size:62.5%; }
h1 { font-size: 2.4em; } /* =24px */
```
4. vw, vh: Respectively these are 1/100th of the width/Height viewport.
### CSS unitless: times
```css
 p { 
  line-height: 1.5; // 1.5 time of font-size
}
```
### CSS function. e.g.: calc(90%-15px);

## CSS Pseudo-classes
To define a special state of an element.
```css
selector: pseudo-class {
    property: value;
}

:active, :hover, :checked, :focus, :empty 
:disabled, :enabled
:first-child, :nth-child(n), :last-child, :nth-last-child(n)
```

## CSS Pseudo-Elements
To style specified parts of an element.
```css
::after, ::before, ::first-letter, ::first-line, ::selection
```

## CSS @rules
* The @import: rule imports another style sheet into the current style sheet.
* The !important rule indicates that a user-defined rule should take precedence over the author's style sheets.
* The @charset rule indicates the character set the style sheet uses.
* The @font-face rule is used to exhaustively describe a font face for use in a document.

## CSS media type
To make it possible to define different style rules for different media types
all/print/screen/speech	
```css
/* When the width is between 600px and 900px OR above 1100px - change the appearance of <div> */
@media screen and (max-width: 900px) and (min-width: 600px), (min-width: 1100px) {
  div.example {
    font-size: 50px;
    padding: 50px;
    border: 8px solid black;
    background: yellow;
  }
}
```


# 常见CSS面试题目
1. link和@import有什么区别？
    1. link 除了加载 CSS外，还可以定义RSS等其他事务；@import属于CSS范畴，只能加载CSS
    2. link 引用 CSS时候，页面载入时同时加载；@import需要在页面完全加载以后加载，而且@import被引用的CSS会等到引用它的 CSS文件被加载完才加载

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

