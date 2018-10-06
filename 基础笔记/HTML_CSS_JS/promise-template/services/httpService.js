var serviceGet = function(url) {
    return fetch(url)
            .then((res) => {
                console.log('res: ', res);
                return res.json();
            }, (res) => {
                new Error(`bad request, result: ${res}`);
            });
}

var servicePost = function(url, formData) {
    return fetch(url, {
                method: 'POST',
                body: JSON.stringify(formData)
            })
            .then((res) => { 
                console.log('res: ', res); 
                return res.json();
            }, (res) => {new Error(`POST failed, ${res}`)});
}