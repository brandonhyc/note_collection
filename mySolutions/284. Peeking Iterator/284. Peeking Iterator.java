// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> _iterator = null;
    Integer peekValue = null;
    boolean end = false;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    _iterator = iterator;
        
        if (_iterator.hasNext()) {
            end = false;
            peekValue = _iterator.next();
        }
        
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (end) {
            return null;
        }
        
        return peekValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int last = peekValue;
        
        if (_iterator.hasNext()) {
            peekValue = _iterator.next();    
        } else {
            end = true;
        }
        
        return last;
	}

	@Override
	public boolean hasNext() {
	    if (end) {
            return false;
        }
        return true;
	}
}