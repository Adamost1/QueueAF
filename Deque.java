public interface Deque<T>{

    public void addFirst(T s); //Inserts the specified element at the front of this deque
    public void addLast(T s); //Inserts the specified element at the end of this deque
    public T pollFirst(); //Retrieves and removes the first element of this deque, or returns null if this deque is empty
    public T pollLast(); //Retrieves and removes the last element of this deque, or returns null if this deque is empty
    public T peekFirst(); //Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty
    public T peekLast(); //Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty
    public int size(); //Returns the number of elements in this deque
    public boolean isEmpty(); //Returns true if this deque has no elements within it

    public boolean contains(T s); //Returns true if this deque contains the specified element

}
