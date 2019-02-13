function shuffle(arr){
    arr.forEach((el,index) => {
        (Math.floor(Math.random() * 10) + 1)
    });
}

shuffle([1,2,3,4,5]);