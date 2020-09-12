async function createString() {

    var p = new Promise((resolve, reject)=> {
        setTimeout(() => {
            resolve("success response");
        }, 3000);
    })
    return p;
}


async function get() {
    createString()
        .then((response) => {
            
                let promiseAll = Promise.all([
                    createString(),
                    createString()
                    
                ]);
                throw new Error("catch promise all");
                return promiseAll;

        }).then ((response) => {
            console.log(response);
        }).catch((e) => {
            console.log(e);

        })
}