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
        let index = event.target.value;
        let tabs = this.node.querySelector(".container div");
        
        // close previous tab
        for (let i = 0; i < tabs.length; i++) {
            tabs[i].style.display = "none";
        }
        // show the tab content
        tabs[index];
        
    }

}



function create() {
    
}



function showContent() {

}

// showContent();