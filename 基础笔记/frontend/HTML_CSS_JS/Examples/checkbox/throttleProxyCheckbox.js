var mainFunc = function(ids) {
    console.log(ids);
}

var throttleProxy = (function() {
    var cacheArray = [],
        timer = undefined;
    return function (checkboxes) {
        if (timer) {
            return;
        }
        timer = setTimeout(function(){
            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    cacheArray.push(checkbox.id);
                }
            });
            console.log("here");
            mainFunc(cacheArray);
            timer = undefined;
            cacheArray = [];
        }, 500);
    }
})();

var checkboxes = Array.from(document.querySelectorAll("input[type=checkbox]"));

function clickedFunction() {
    throttleProxy(checkboxes);
}
checkboxes.forEach(checkbox => checkbox.addEventListener('click', clickedFunction));