package codingPad;

public interface Heap<E> {
    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public E peek();

    public E poll();

    public void offer(E ele);

    public void update(int index, E elm);
}
