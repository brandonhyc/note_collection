class tabSwitcher {
    constructor(id) {
        this.id = id;
    }

    get create() {
        let temp = document.getElementsByTagName("template")[0];
        let clon = temp.content.cloneNode(true);
        clon.id = this.id;
        document.body.appendChild(clon);
        return clon;
    }
}



function create() {
    
}



function showContent() {

}

// showContent();