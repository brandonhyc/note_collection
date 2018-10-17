var nodeCollection = document.querySelectorAll("p");
var nodeArray = Array.from(nodeCollection);

p.forEach(node => node.style.color = 'blue');

//es5
var ages = [1,2,3,4,5];
var full = ages.map((age) => age > 3);
age[full.indexOf(true)];

//ES6
var full = ages.findIndex((age) => age > 3);
var full = ages.find((age) => age > 3);

