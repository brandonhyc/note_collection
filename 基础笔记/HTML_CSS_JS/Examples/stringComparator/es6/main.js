function clicked() {
    var input1 = prompt("string 1").split("");
    var input2 = prompt("string 2").split("");
    var result = twoStringCompare(input1, input2);

    document.querySelector(".result").textContent = result;
}

function twoStringCompare(a, b) {
    return a.filter((c) => !b.includes(c));
}