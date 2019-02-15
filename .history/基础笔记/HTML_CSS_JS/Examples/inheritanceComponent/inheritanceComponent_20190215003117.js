class tabSwitcher {
    constructor(id) {
        
        let temp = document.getElementsByTagName("template")[0];
        let clon = temp.content.cloneNode(true);
        clon.id = id;
        document.body.appendChild(clon);

        return clon;
    }
}



function create() {
    
}



function showContent() {

}

// showContent();