"use strict";
(function (window) {
    window.Overlay = Overlay;
}(window));


class Overlay {
    constructor(opts) {
        this.opts = this.extend(this.defaults, opts);
        this.init();
    }
    get defaults() {
        return {    
            target: null,
            width: 500,
            height: 300,
            title: '',
            content: ''}
    }

    extend (dest, src) {
        for (var prop in src) {
            if (src.hasOwnProperty(prop)) {
                dest[prop] = src[prop];
            }
        }

        return dest;
    }

    template() {
        var title = "<div class='overlay-header'>" + this.opts.title + "<div id='overlay-close'>&times;</div></div>";
        var content = "<div class='overlay-content'>" + this.opts.content + "</div>";
        var footer = "<div class='overlay-footer'><button id='overlay-ok'>确定</button><button id='overlay-cancel'>取消</button></div>";

        var _Overlay = document.createElement("div");
        _Overlay.setAttribute("id", "Overlay");
        _Overlay.innerHTML = "<div class='overlay-mask'></div><div class='overlay-inner'>" + title + content + footer + "</div>";

        return _Overlay;
    }

    bindEvents() {
        var _Overlay = document.getElementById("Overlay");

        document.getElementById("overlay-close").addEventListener("click", function (e) {
            e.preventDefault();
            _Overlay.style.display = "none";
        });
        document.getElementById("overlay-ok").addEventListener("click", function (e) {
            e.preventDefault();
            _Overlay.style.display = "none";
        });
        document.getElementById("overlay-cancel").addEventListener("click", function (e) {
            e.preventDefault();
            _Overlay.style.display = "none";
        });
    }

    init() {
        var layout = this.template();

        if (this.opts.target) {
            document.body.appendChild(layout);
            document.querySelector(this.opts.target).addEventListener("click", function () {
                document.getElementById("Overlay").style.display = "block";
            });
        } else {
            document.body.appendChild(layout);
            document.body.addEventListener("click", function (e) {
                document.getElementById("Overlay").style.display = "block";
            });
        }

        this.bindEvents();
    }
}

Overlay.prototype.;

Overlay.prototype.setHeight = function (val) {
    var height = document.getElementsByClassName("overlay-inner")[0];
    height.style.height = val + "px";
    height.style.marginTop = -val / 2 + "px";

    return this;
};


var overlay = new Overlay({
    target: '#runBtn',
    title: '自定义标题',
    content: '自定义内容...'
}).setWidth(460).setHeight(270);