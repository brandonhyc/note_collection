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
        
        let buttonsDiv = this.node.querySelector(".tab");
        buttonsDiv.addEventListener('click', this.switchTab);

        document.body.appendChild(this.node);
        return clon;
    }


    switchTab(event) {
        let index = event.target.value;
        let tabs = this.parent.querySelector(".container");
         
        // stop papergate

        // close previous tab
        for (let i = 0; i < tabs.length; i++) {
            tabs[i].style.display = "none";
        }
        // show the tab content
        tabs[index].style.display = "contents";
    }

}


(function main() {
    let tabCompObj = new tabSwitcher("first");
    let tabComp= tabCompObj.create;

    
})()