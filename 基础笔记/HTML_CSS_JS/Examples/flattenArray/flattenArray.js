function recursivelyFlattenArray(array) {
    return flatten(array);

    function flatten(array) {
        if (!Array.isArray(array)) {
            return [array];
        }
        let result = [];

        array.forEach(element => {
            result = result.concat(flatten(element));
        });
        return result;
    }
}

function iterativelyFlattenArray(array) {
    let result = [];
    while (array.length != 0) {
        let el = array.shift();
        if (Array.isArray(el)) {
            array = el.concat(array);
            continue;
        }
        result.push(el);
    }
    
    return result;
}



var arr = [1, [2, [3]], [4]];

console.log(iterativelyFlattenArray(arr));