//3 parks and 4 streets
// park has tree, area, year

main();

function main() {


}


class park {
    constructor(name, year, trees, area) {
        this.year = year;
        this.name = name;
        this.trees = parseInt(trees);
        this.area = area;
    }
    reportTreeDensity() {
        console.log(this.trees / this.area);
    }
    static reportTreeAvgAge(...parks) {
        var sum = 0;
        parks.forEach((park) => {
            sum += park.trees;
        })
        console.log(sum / parks.length);
    }
    static reportGreatParks(...parks) {
        var greatParks = parks.find((park) => {
            return park.trees >= 1000; 
        })
        console.log(greatParks);
    }
} 

class street {
    constructor(name, year, length, size = 'normal') {
        this.year = year;
        this.name = name;
        this.length = length;
        this.size = size;
    }
    static reportStreets(...streets) {
        
    }
}