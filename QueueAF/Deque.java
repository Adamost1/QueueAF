public interface Deque{

    public void addFirst(String s);
    public void addLast(String s);
    public String pollFirst(); 
    public String pollLast();
    public String peekFirst();
    public String peekLast();
    public int size();
    public boolean isEmpty();

}
