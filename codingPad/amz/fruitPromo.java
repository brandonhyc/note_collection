package codingPad.amz;

class Solution {
    public int freshPromotion(String[][] codeList, String[] cart) {

        final String WILD_CARD = "anything";
        int codeIndex = 0, cartIndex = 0;

        // use multiple pointer as defined
        // a. codeIndex pointing to the current list processing
        // b. sIndex pointing to shoppingCart items being processing
        // c. a fast pointer pointing the each item in the list

        // iterate each item in shopping cart
        //  try to match all many items as possible in processing code
        //      set a fast pointer
        //      if can match, codeIndex++,
        //      if not match, do nothing
        //      move sIndex to fast pointer



        while (cartIndex < cart.length && codeIndex < codeList.length) {
            String[] code = codeList[codeIndex];

            if (code[0].equals(cart[cartIndex]) || code[0].equals(WILD_CARD)) { // potential match
                int k = 1; // the pointer to match the rest of code
                while (k < code.length && k + cartIndex < cart.length &&
                        (code[k].equals(cart[k + cartIndex]) || code[k].equals(WILD_CARD))) {
                    k++;
                }
                cartIndex = cartIndex + k;
                if (k == code.length) {
                    codeIndex++;
                }
            } else {
                cartIndex++;
            }

        }

        return codeIndex == codeList.length ? 1 : 0;
    }
}

