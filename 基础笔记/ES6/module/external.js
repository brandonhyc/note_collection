var strA = "stringA"
var strB = "stringB_default"

function print(strA, strB) {
    document.body.appendChild(
        document.createTextNode(`printing: ${strA}, also default ${strB}`));
    console.log(`printing: ${strA}, also default ${strB}`);
}

export { strA, print };
export { strB as default } ; // = export default strB