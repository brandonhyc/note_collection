function shuffle(arr){
    arr.forEach((el,i) => {
        let j = (Math.floor(Math.random() * arr.length()) + 0);
    });
}

shuffle([1,2,3,4,5]);