### Observable vs Promise
* Promise handles a single event when an async operation completes or fails.
* Observable is like a Stream. It provides the features of Promise and more.

### What is Subject
An RxJS Subject is a special type of Observable. It allows values to be multicasted to many Observers. While plain Observables are unicast. Every Subject is an Observable and an Observer. You can subscribe to it, and it is an object with the methods next(v), error(e), and complete().