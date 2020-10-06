
/**
 * main entry: get two input
 */

(async function() {

    var str1 = await getInput("string 1");
    var str2 = await getInput("string 2");
    var result = await compute(str1, str2);

    document.querySelector("#display_p").innerHTML = `result: ${ result }`;
}) ()

async function compute(str1, str2) {
    var arrayA = str1.split("");
    for (let index in arrayA) {
        if (str2.indexOf(arrayA[index]) !== -1) {
            arrayA[index] = "_"
        }
    }
    var result = arrayA.join("");
    return result;
}

async function getInput(strName) {
    var str1 = await prompt(`enter ${strName}`);
    return str1;
}




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

