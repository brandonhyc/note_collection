console.log(maxPath([1,2,3,4]));


function maxPath(arr) {
    arr.sort();
    swap(arr, 0, 1);
    swap(arr, 2, 3);
    swap(arr, 0, 3);
    return arr
}

function swap(arr, a, b) {
    let temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}