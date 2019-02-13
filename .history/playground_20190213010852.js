function shuffle(arr){
    arr.forEach((el,i) => {
        let j = Math.floor(Math.random() * arr.length);
        
        let temp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = temp;
    });
}
var arr = [1, 2, 3, 4, 5];
shuffle(arr);

console.log(arr);