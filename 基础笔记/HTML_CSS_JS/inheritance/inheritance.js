function extend(childArray, parentArray) {
    for (var propName in source) {
        target[propName] = source[propName];
    }
    return target;
}

// ES5
function extend(target, source) {
    Object.getOwnPropertyNames(source)
        .forEach(function (propName) {
            Object.defineProperty(target, propName,
                Object.getOwnPropertyDescriptor(source, propName));
        });
    return target;
}

// deepCopy 
function deepCopy(parent, child) {
    var child = child || {};
    for (var i in parent) {
        if (typeof parent[i] === 'object') {
            child[i] = (parent[i].constructor === Array) ? [] : {};
            deepCopy(parent[i], child[i]);
        } else {
            child[i] = parent[i];
        }
    }
    return c;
}