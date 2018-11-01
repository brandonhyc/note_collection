var box5 = {
    self: this,
    color: 'green',
    position: 1,
    clickMe: function() {
            var selfInsideClickMe = this;
            document.querySelector('.green').addEventListener('click', 
            function() { // ES5
                var selfInsideEventListener = this;
                var str = selfInsideClickMe.position;
                alert(str); // str undefined? why??
                console.log('self: ', self); //Window
                console.log('selfInsideClickMe: ', selfInsideClickMe); // Object
                console.log('selfInsideEventListener: ', selfInsideEventListener); //Div

                printElements(`'self: ', ${self.toString()}`);
                printElements(`'selfInsideClickMe: ', ${selfInsideClickMe.toString()}`);
                printElements(`'selfInsideEventListener: ', ${selfInsideEventListener.toString()}`);
        });
    }
}
var box6 = {
    self: this,
    color: 'red',
    position: 1,
    clickMe: function () {
        var selfInsideClickMe = this;

        document.querySelector('.red').addEventListener('click',
            () => { // ES6
                var selfInsideEventListener = this;
                var str = selfInsideClickMe.position;
                alert(str); // str undefined? why??
                console.log('self: ', self); //Window
                console.log('selfInsideClickMe: ', selfInsideClickMe); // Object
                console.log('selfInsideEventListener: ', selfInsideEventListener); //Object
                printElements(`'self: ', ${self.toString()}`);
                printElements(`'selfInsideClickMe: ', ${selfInsideClickMe.toString()}`);
                printElements(`'selfInsideEventListener: ', ${selfInsideEventListener.toString()}, === selfInsideClickMe ? ${selfInsideClickMe === selfInsideEventListener}`);
            }
        );
    }
}


box5.clickMe();
box6.clickMe();


function printElements(...elements) {
    var resultDiv;
    if (!document.querySelector("div#result")) {  
        resultDiv = document.createElement("div");
        resultDiv.id = "result";
        document.body.appendChild(resultDiv);
    }
    resultDiv = document.querySelector("div#result");
    
    console.log(resultDiv);

    elements.forEach((ele) => {
        var p = document.createElement("p");
        p.appendChild(document.createTextNode(ele));
        resultDiv.appendChild(p);
    })
}