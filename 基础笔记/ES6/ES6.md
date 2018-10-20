## 好文: 
https://www.jianshu.com/u/4d7dd4c7e51d, es6必学必会module


### Difference
* let/const
* String methods
* arrow function 
* destruction
* array apis
* CLASS
* The spread operator -... for 1. array/string (iterable) 2. rest parameters
* Function default value function (str = 'string'){};
* Abstract Data Class: Map
* module: import/export

### let /const and IIFEs

### const vs Object.freeze()

### String new Features
1. back taps `` and ${} 
2. str.startWith('c'), str.endWith('c'), str.includes('sc')
3. str.repeat(5);

### Destruction 
```js
const [name, age] = ['John', 26];
// name = 'John'; age = 26;

const [name, age] = (() => { return ['Y', 11]})();

const obj = { firstName: 'John', lastName: 'Smith'};
const {firstName, lastName} = obj;
// firstName = 'John', lastName = 'Smith';

const {firstName: a, lastName: b} = obj;
// a = 'John', b = 'Smith'
```

## Array 
1. new constructor: var arr = Array.from(nodeCollection);
2. new method find/findIndex: arr.findIndex(cur => cur > 0)

### [..."str"] parsing a string
```js
const number = [1,2,3];
const str = "string";

console.log([...number, 4, 5]);
console.log([...'ne', 'w' , ...str]);
```


### import and export