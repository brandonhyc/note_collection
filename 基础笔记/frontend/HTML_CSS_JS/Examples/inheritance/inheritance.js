var Parent = function (name) {
    this.name = name;
};
Parent.prototype.sayHi = function () {
    console.log("Hi! I am " + this.name + ".")
}

var Child = function (name, age) {
    Parent.call(this, name);
    this.age = age;

    this.play = function () {
        console.log(this.name + " is playing");
    }
}
Child.prototype = new Parent();
Child.prototype.getAge = function () {
    console.log(this.age);
}

var Steve = new Parent("Steve");
var Stephen = new Child("Stephen", 6);
Steve.sayHi();
Stephen.sayHi();
Stephen.getAge();