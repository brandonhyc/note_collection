### Object Literal Pattern and Name space Design Pattern
```js
var o = {};

var com = com || {};
com.o2geek = com.o2geek || {};
com.o2geek.packt = com.o2geek.packt || {};
com.o2geek.packt.JSDP = com.o2geek.packt.JSDP || {};

com.o2geek.packt.JSDP.sudoChat = {
    //...
}
```

### Module Pattern
Good for private variable, but it's complex.
```js

var module = (function () {
    var firstName = "Blake",
        lastName = "He"
    
        function selfIntroduce (age) {
            return `I am ${firstName} ${lastName}. I am ${age}`;
        }

    return {
        beFriendWith: function (person) {
            console.log(selfIntroduce(13));
            console.log(`${firstName} is being friend with ${person}`);
        }
    }
})();

```

### Module Reveal Pattern

```js

var module = (function () {
    var _firstName = "Blake",
        _lastName = "He";
    
        function _selfIntroduce (age) {
            return `I am ${_firstName} ${_lastName}. I am ${age}`;
        }
        function beFriendWith (person) {
            console.log(_selfIntroduce(13));
            console.log(`${_firstName} is being friend with ${person}`);
        }

    return {
        beFriendWith: beFriendWith
    }
})();

```

### Singleton Pattern
```js
    var CircleGeneratorSingleton = (function () {
        var instance;

        function init() {
            var _privateVariable = "a";

            function _pos() {}
            function create() {}
            function add() {}
            return {
                create : create,
                add : add
            }
        }
    })

    var cg = CircleGeneratorSingleton();
    var circle = cg.create();

    cg.add(circle);
```