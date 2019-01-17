export class Helper {
    flattenPromise(array: any[]): Promise<any> {
        return new Promise((resolve, reject) => {
            resolve(flatten(array));

            function flatten(array: any[]): any[] {
                if (!Array.isArray(array)) {
                    return [array];
                }
                let result = [];

                array.forEach(element => {
                    result = result.concat(flatten(element));
                });
                return result;
            }
        });
    }
}