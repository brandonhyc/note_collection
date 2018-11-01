var infiniteScrollGenerator = (function() {
    function init() {
        var instance;
        var _container; 

        function _onScroll() {
            var documentHeight = document.documentElement.scrollHeight;
            var scrollTop = document.documentElement.scrollTop;
            var windowHeight = window.innerHeight;
            var p = document.createElement("p");
    
            if (documentHeight - scrollTop > windowHeight) {
                return;
            }
            
            p.textContent = `Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente maxime beatae porro non vitae vel natus error odio ut inventore perspiciatis, ipsa hic quaerat dolorum dolor unde architecto exercitationem vero.`;
            _container.appendChild(p);
            return;
        }

        function create(selector) {
            _container = document.querySelector(selector);
        }
    
        // main
        window.onscroll = _onScroll;
    
        return {
            create: create,
        }
    }
    return { 
        getInstance: function() {
            if (typeof instance === "undefined") {
                instance = init();
            } 
            return instance;
        }
    }
})();

var scroller = infiniteScrollGenerator.getInstance();
scroller.create(".container");
