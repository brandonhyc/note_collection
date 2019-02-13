function removeVowel(str) {
     
    return [...str].filter((c) => {
        let vowels = 'aeiouAEIOU';
        return vowels.includes(c) !== true;
    }).join('');
}

let result = removeVowel("aeioooobbddrrr");
console.log(result);