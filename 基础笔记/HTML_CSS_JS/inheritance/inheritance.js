var Person = function(name, age, job){
    this.name = name;
    this.age = age;
    this.job = job;
}

Person.prototype.sayAge = function () {
    console.log(`I am ${this.age}`);
}

var Athlete = function(name, age, job, medals) {
    Person.call(this, name, age, job);
    this.medals = medals;
}

Athlete.prototype = Object.create(Person.prototype);

var john = new Athlete('John', 1990, 'swimmer', 3);
console.log(john);

