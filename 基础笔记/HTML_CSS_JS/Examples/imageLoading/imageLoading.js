window.onload = function () {

    var imageLoader = (function () {

        var _imgNode = document.createElement("img");
        document.body.appendChild(_imgNode);

        var _img = new Image();
        _img.onload = function () {
            _imgNode.src = this.src;
        };

        function load(url) {
            // loading symbol
            _imgNode.src = "http://img.lanrentuku.com/img/allimg/1212/5-121204193Q9-50.gif";
            _img.src = url;
        }

        return {
            load: load
        }

    })();

    imageLoader.load("https://images.unsplash.com/photo-1542173212-6fbb91e107f1?ixlib=rb-0.3.5&s=a1b73b86a49b1c1422dc1d682765887e&auto=format&fit=crop&w=1952&q=80")
}
