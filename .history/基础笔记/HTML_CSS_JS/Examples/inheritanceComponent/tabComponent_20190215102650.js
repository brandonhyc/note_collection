export class tabSwitcher {
    constructor(prop) {
        this.id = prop.id;
        this.node = this.create;
    }

    get create() {
        if (this.node != null) {
            return this.node;
        }
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
        debugger
        event.preventdefault();
        if (event.target.value == null) {
            return;
        }
        let index = event.target.value;
        let tabs = this.parentElement.querySelectorAll(".container div");

        // close previous tab
        for (let i = 0; i < tabs.length; i++) {
            tabs[i].style.display = "none";
        }
        // show the tab content
        tabs[index].style.display = "contents";
    }
}

