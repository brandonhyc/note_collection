## What is AJAX = Asynchronous Javascript And XML
AJAX allows web pages to be updated asynchronously by exchanging data with a web server behind the scenes.

## What is promise
The promise is the object that represent the completion of an asynchronous operation and its resulting value. 
## Why using promise
Promise is a good practice when using AJAX to avoid callback hell. 

## What is callback
In asynchronous programming, the function does something asynchronously provides a callback argument which is a function entry will be called when the action is complete.

## What is promise chain
It is a way to chain asynchronous tasks one by one. After a promise resolved, we can use .then to write the next logic and pass a value.

## What is async/await
It is nicer syntax to use promise and .then. By creating async function, it will always return a promise. In the function, we use await (.then) to use asynchronous programming. 


### Fetch Post
```js
fetch(url, {
    method: 'post',
    headers: {
      "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
    },
    body: 'foo=bar&lorem=ipsum'
  })
  .then(json)
  .then(function (data) {
    console.log('Request succeeded with JSON response', data);
  })
  .catch(function (error) {
    console.log('Request failed', error);
  });
```