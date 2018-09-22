function Animal(species) {
    this.species = species || "动物";
}

//1.
　　function Cat(name, color, species) {
　　　　Animal.apply(this, arguments);
　　　　this.name = name;
　　　　this.color = color;
　　}

　　var cat1 = new Cat("大毛", "黄色");

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