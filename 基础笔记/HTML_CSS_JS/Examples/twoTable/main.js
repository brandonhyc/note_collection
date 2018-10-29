var tableA = document.querySelectorAll("#table-a .list-id");
var tableB = document.querySelectorAll("#table-b .list-id");

var setA = new Set();
var setB = new Set();

tableA.forEach((el) => initListA(el, setA, setB));
tableB.forEach((el) => initListB(el, setA, setB));


function swap(el, setA, setB) {
    debugger
    var text = el.querySelector("td").textContent;
    if (setA.has(text) && setB.has(text)) {
        return;
    }
    if (setA.has(text)) {
        setB.add(text);
        setA.delete(text);

        el.parentNode.removeChild(el);
        document.querySelector("#table-b").appendChild(el);
        return;

    } else if (setB.has(text)) {
        setA.add(text);
        setB.delete(text);

        el.parentNode.removeChild(el);
        document.querySelector("#table-a").appendChild(el);
        return;
    }
}

function initListA(el, setA, setB) {
    var text = el.querySelector("td").textContent;
    setA.add(text);
    el.addEventListener("dblclick", () => { swap(el, setA, setB) });
}

function initListB(el, setA, setB) {
    var text = el.querySelector("td").textContent;
    setB.add(text);
    el.addEventListener("dblclick", () => {
        swap(el, setA, setB)
    });
}