
# 面向对象

## 建造函数
````javascript
    /* 对象 基础建造4方式 */
    //1, 
    var animal = {name:'', gender: ''};
    animal.name = 'Brandon'; animal.gender = 'male';
    
    //2.
　　function newAnimal(name, color) {
    　　　　return { name:name, gender:color }
　　}
    var animal = newAnimal('Brandon', 'male');

    //3.
    function Animal(name, color) {
    　　　　this.name = name, this.gender = color;
　　}
    var animal = new Animal('Brandon', 'male');

    //4.
    function Animal(name, gender) {
    　　　 this.name = name; this.gender = gender;
　　}
    Animal.prototype.eat = function(something) {console.log(`${this}) ate ${something}`};
    var cat = new Animal('Brandon', 'male' );
    cat.eat('fish');

````

## 继承


### 利用构造函数继承 
````javascript
    /* 对象 继承4方式 */

　　function Animal(){
　　　　this.species = "动物";
　　}

    //1.
　　function Cat(species, name, color){
　　　　Animal.apply(this, species);
　　　　this.name = name;
　　　　this.color = color;
　　}

   //2.
    Cat.prototype = new Animal();
    Cat.prototype.constructor = Cat;
    var cat1 = new Cat("大毛", "黄色");

    //3.
　　function extend(Child, Parent) {
　　　　var F = function () { };
　　　　F.prototype = Parent.prototype;
　　　　Child.prototype = new F();
　　　　Child.prototype.constructor = Child;
　　　　Child.uber = Parent.prototype;
　　}

　　extend(Cat, Animal);
　　var cat1 = new Cat("大毛", "黄色");
　　alert(cat1.species); // 动物

    //4. 
　　function extend2(Child, Parent) {
　　　　var p = Parent.prototype;
　　　　var c = Child.prototype;
　　　　for (var i in p) {　c[i] = p[i]; }
　　　　c.uber = p;
　　}

````

### 非构造函数继承

参考: http://www.ruanyifeng.com/blog/2010/05/object-oriented_javascript_inheritance_continued.html

两个对象都是普通对象，不是构造函数，无法使用构造函数方法实现"继承"。则使用非构造函数继承.


````javascript

　　var Chinese = {
　　　　nation:'中国'
　　};
　　var Doctor ={
　　　　career:'医生'
　　};

    /* 浅拷贝 */
    // 浅拷贝会影响父类

　　function extendCopy(p) {
　　　　var c = {};
　　　　for (var i in p) { 
　　　　　　c[i] = p[i];
　　　　}
　　　　c.uber = p;
　　　　return c;
　　}

　　var Doctor = extendCopy(Chinese);
　　Doctor.career = '医生';
　　alert(Doctor.nation); // 中国

    /* 深拷贝 */
　　function deepCopy(p, c) {
　　　　var c = c || {};
　　　　for (var i in p) {
　　　　　　if (typeof p[i] === 'object') {
　　　　　　　　c[i] = (p[i].constructor === Array) ? [] : {};
　　　　　　　　deepCopy(p[i], c[i]);
　　　　　　} else {
　　　　　　　　　c[i] = p[i];
　　　　　　}
　　　　}
　　　　return c;
　　}

    var Doctor = deepCopy(Chinese); 

````

## 总结


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