function MyObject() {
    
    var self = this;
    this.doSomething = function () {
        console.log("doing something")
        console.log(this);
        console.log(self);
    }
    
    this.operateSelf = function () {
        self.doSomething();
    }
    this.operateThis = function () {
        this.doSomething();
    }
}

var obj = new MyObject();
obj.doSomething();
