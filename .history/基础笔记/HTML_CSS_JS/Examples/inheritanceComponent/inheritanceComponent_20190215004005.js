class tabSwitcher {
    constructor(id) {
        this.id = id;
        this.node = null;
    }

    get create() {
        let temp = document.getElementsByTagName("template")[0];
        let clon = temp.content.cloneNode(true);

        clon.id = this.id;
        this.node = clon;
        
        document.body.appendChild(clon);
        return clon;
    }

    switchTab(event) {
        let targetClassName = event.target.className;
        this.node.querySelector("." + targetClassName);
        
    }

}



function create() {
    
}



function showContent() {

}

// showContent();