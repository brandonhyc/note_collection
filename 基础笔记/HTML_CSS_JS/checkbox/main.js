var his = [];

function checkClicked(event) {
    var target = event.target;
        console.log(his);

    if (target.checked) { // after checked
            his.push(target);
        if (his.length == 3) {
            var last = his.shift();
            last.checked = false;
        }
    }
} 

function showHis() {
    console.log(his);
}