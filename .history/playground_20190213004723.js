function shuffle(arr){
    var newOne = arr.forEach((element,index, array) => {
        array[index] = 0;
    });

    console.log(newOne);
    console.log(arr);

}

shuffle([1,2,3,4,5]);