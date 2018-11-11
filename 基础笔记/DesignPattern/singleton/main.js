var singletonGenerator = (function () {
    
    var _instance;
    var log;

    function _init() {
        _instance = fetch('https://jsonplaceholder.typicode.com/todos/1')
            .then((response) => response.json())
            .then(json => {
                return json;
            })
        return _instance;
    }

    function create() {
        if (_instance) {
            console.log("reading record");
            return _instance;
        }
        return _init();
    }
    return {
        create : create
    }

})();

var one = singletonGenerator.create();
    one.then((json) => console.log(json));  

var two = singletonGenerator.create();