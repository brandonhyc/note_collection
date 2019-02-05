# Infinite Scroll Implementation

In some popular websites like pinterest, weibo and twitter, we have some experiences on infinite scroll. This practice allows browser loading more content infinitely while not jump between pages. In this article, I am going to explain how to implement this by using pure js.
![alt text](pinterest.gif "pinterest")



## Document Height, Viewport Height, and ScrollTop 

Document Height means the total height of the HTML document. It can keep increasing when adding new content.
<br>
Viewport Height, also meaning window height, is height of user vision area. It can be different in browsers. 
<br>
ScrollTop is the y position of user viewport. 
<br>
It is really easy if we see the picture below. 

![alt text](google.gif "google")

## Explain
When the user scroll, it will trigger window.onscroll callback function. That callback function needs to check whether the rest content is enough (to fulfill the viewport). If not, then add more content. 

Let's put it in pseodu code:
```
every time user scroll:
    if documentHeight - scrollTop < windowHeight: 
        add content
    end if
    return
```

### Code Snippet
```js

window.onscroll = _onScroll;

function _onScroll() {
    var documentHeight = document.documentElement.scrollHeight;
    var scrollTop = document.documentElement.scrollTop;
    var windowHeight = window.innerHeight;
    var p = document.createElement("p");

    if (documentHeight - scrollTop > windowHeight) {
        return;
    }
    
    p.textContent = `Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente maxime beatae porro non vitae vel natus error odio ut inventore perspiciatis, ipsa hic quaerat dolorum dolor unde architecto exercitationem vero.`;
    _container.appendChild(p);
    return;
}

```

## More
I have tried to encapsulate it. It can be found in: https://github.com/brandonhyc/infinite-scroll-demo