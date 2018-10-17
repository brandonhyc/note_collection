import {add} from './external.js'
function add2(a, b) {
    return add(a, b);
}

add2(2, 3);
document.body.appendChild(
    document.createTextNode(
        add2(2,3)));