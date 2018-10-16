### Difference
* let/const
* String methods
* arrow function 
* destruction
* array apis
* CLASS

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


### [..."str"] parsing a string


### import and export