import { tabSwitcher } from "tabComponent";

(function main() {
    // get all tabComponents

    document.querySelectorAll("tabSwitcher").forEach((node, index) => {
        new tabSwitcher({ id: "tab" + index });
    });

})()