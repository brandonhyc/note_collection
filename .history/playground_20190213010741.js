function shuffle(arr){
    arr.forEach((el,i) => {
        let j = (Math.floor(Math.random() * arr.length()) + 0);
        
        let temp = arr[i]; 
        arr[i] = arr[j];
        arr[j] = temp;
    });
}

shuffle([1,2,3,4,5]);