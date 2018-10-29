
function drag(event) {
    event.dataTransfer.setData("imgTranser", event.target.id);
    console.log('event.target.id: ', event.target.id);
    console.log('event.dataTransfer.getData("imgTranser"): ', event.dataTransfer.getData("imgTranser"));
}

function drop(event) {
    var t = event.dataTransfer.getData("save");
    
    console.log(t);
}

function dragover(event) {
    
    event.preventDefault();
}