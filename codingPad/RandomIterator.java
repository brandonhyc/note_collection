package codingPad;

import java.util.Random;

class RandomIterator<T> {
    int k; // time intervals
    T[] elements;
    int lf, ll;  // [lf, ll] is playlist, (pf, pl) is pending list, enqueue by pl
    Random rm;

    RandomIterator(T[] elements, int k) {
        this.elements = elements;
        this.k = k;
        rm = new Random();

        lf = 0;
        ll = elements.length - 1;
    }

    public T next() {

        // removing element from ll
        ll = (ll + 1) % elements.length;
        int index;
        int select;
        if (lf < ll) {
            index = rm.nextInt(ll -  lf + 1); // if lf < ll
            select = lf + index;
        } else {
            index = rm.nextInt(elements.length - (lf - ll -  1)); // if ll < lf
            select = (lf + index) % elements.length;
        }

        swap(elements, lf, select);
        T playing = elements[lf];
        lf = (lf + 1) % elements.length;

        return playing;
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
