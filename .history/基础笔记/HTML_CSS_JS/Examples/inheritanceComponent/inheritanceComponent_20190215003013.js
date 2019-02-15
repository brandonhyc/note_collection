class Polygon {
    constructor(height, width) {
        this.area = height * width;
    }
}



function create() {
    
}



function showContent() {
    var temp = document.getElementsByTagName("template")[0];
    var clon = temp.content.cloneNode(true);
    document.body.appendChild(clon);
}

// showContent();