function formatPhoneNumber(str) {
    str = strip(str);

    let result = "";
    let start = 0;

    while (start < str.length) {
        if (start + 2 >= str.length) {
            result += str.slice(start, str.length);
            return result;
        }

        result += str.slice(start, start + 2);
        result += "-";

        start += 2;
    }

    function strip(str) {
        return str.replace(/[^\d]/g, '');
    }
}