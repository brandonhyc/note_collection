function personalizeCoupons(coupons, preferredCategories) {
    let couponsArray = coupons.filter(coupon => preferredCategories.includes(coupon.category))
    couponsArray.sort((a, b) => 
        b.couponAmount / b.itemPrice - a.couponAmount / a.itemPrice)
    couponsArray = couponsArray.slice(0, 10);
    couponsArray = couponsArray.map(coupon => (
        {   upc: coupon.upc,
            category: coupon.category,
            itemPrice: coupon.itemPrice,
            couponAmount: coupon.couponAmount
        })
        );
    return couponsArray;
}
// {"couponAmount":5.02,"upc":"0677335752583272","code":"31463880544002973964","itemPrice":10.97,"category":"Sporting Goods"}, 
// {"couponAmount":4.91,"upc":"3663405873668696","code":"88620249668379048840","itemPrice":11.75,"category":"International"},
// {"couponAmount":7.24,"upc":"1276448878160824","code":"67590620582640523769","itemPrice":19.35,"category":"Baking Goods"},
// {"couponAmount":6.61,"upc":"4816683327672908","code":"39385271820845634478","itemPrice":17.72,"category":"Gift Cards"},
// {"couponAmount":4.27,"upc":"7906242730279690","code":"48996916239520647316","itemPrice":16.47,"category":"Deli"},
// {"couponAmount":4.21,"upc":"0638901151099874","code":"92685425904997978881","itemPrice":17.22,"category":"Photo Shop"},
// {"couponAmount":2.75,"upc":"0911255208698955","code":"25867248437110601432","itemPrice":12.83,"category":"Baby"},
// {"couponAmount":2.74,"upc":"9131891630585208","code":"30417547581177009338","itemPrice":19.82,"category":"Gift Cards"},