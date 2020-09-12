const BASE_URL = 'https://5f5cee5b5e3a4d0016249b70.mockapi.io/'

let button = document.querySelector('.search_btn');
let input = document.querySelector('.search_input');
let table = document.querySelector('.city_table');
let div = document.querySelector('.div');

button.addEventListener('click', (event) => {
    console.log('clicked')
    fetch(BASE_URL + 'users')
        .then((res) => res.json())
        .then((res) => {
            console.log(res);
            // div.textContent = JSON.stringify(res);

            populateData(table, res);
        })      
})

populateData = (tb, res) => {
    initTh(tb);
    res
        .map((data)=> {
            let row = createElement('tr', tb);
            createElement('td', row).textContent = data.id;
            createElement('td', row).textContent = data.createdAt;
            createElement('td', row).textContent = data.name;
            createElement('td', row).textContent = data.avatar;
          
            tb.appendChild(row);
            return row;
        })
}

initTh = (tb) => {
    let tr = createElement('tr', tb);
    createElement('th', tr).textContent = 'ID';
    createElement('th', tr).textContent = 'CREATED_AT';
    createElement('th', tr).textContent = 'NAME';
    createElement('th', tr).textContent = 'AVATAR';
}

createElement = (tag, parent) => {
    let child = document.createElement(tag);
    parent.appendChild(child);
    return child;
}