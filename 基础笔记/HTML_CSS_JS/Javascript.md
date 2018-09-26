
# JavaScript Declarations, Initialization and Hoisting
1. Hoisting is JavaScript's default behavior of moving all declarations to the top of the current scope
2. JavaScript only hoists declarations, not initialization

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