window.onload = function () {
    var myImage = (function () {
        var imgNode = document.createElement("img");
        document.body.appendChild(imgNode);
        return {
            setSrc: function (src) {
                imgNode.src = src;
            }
        }
    })();
    // 代理模式
    var ProxyLoader = (function () {
        var img = new Image();
        img.onload = function () {
            myImage.setSrc(this.src);
        };

        function load(url) {
            myImage.setSrc("http://img.lanrentuku.com/img/allimg/1212/5-121204193Q9-50.gif");
            img.src = url;
        }

        return {
            load: load
        }
    })();
    // 调用方式

    ProxyLoader.load("https://img.alicdn.com/tps/i4/TB1b_neLXXXXXcoXFXXc8PZ9XXX-130-200.png");

}