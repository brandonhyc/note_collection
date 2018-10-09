

function display() {
    var stringA = document.querySelector("#stringA").value;
    var stringB = document.querySelector("#stringB").value;

    var arrayA = stringA.split("");
    var setB = new Set(stringB.split(""));

    for (let index in arrayA) {
        if (setB.has(arrayA[index])) {
            arrayA[index] = "_";
        }
    }

    document.querySelector("#display_p").innerHTML = `result: ${ arrayA.join('') }`;
}

