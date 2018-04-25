/*
Q(ueue)AF - Ryan Kim, Joshua Weiner, Alvin Ye
APCS2 - pd08
L #02: All Hands on Deque! (Not Schenectady; rather, synecdoche.)
2018 - 04 - 18
*/

import java.util.NoSuchElementException;

public class QQKachoo<T> implements Deque<T>{

    private DLLNode<T> _front, _back;
    private int _size;

    //Constructor, initialize variables
    public QQKachoo(){
	     _front = null;
	     _back = null;
	     _size = 0;
    }

    /*
    * Adds a new node containing the T argument as its cargo to the front of the deque.
    * If the list is empty, set the pointer variables (_front, _back) to the new node.
    * Otherwise, insert the node, having it point backwards to _front. Set _front to point forwards to the new node
    * Then assign variable _front to this new node.
    *
    * Throws a NullPointerException if asked to add a null element to the deque, in accordance with the api.
    * Runtime: O(1)
    */
    public void addFirst(T s){
        //initialize a new node newNode, having it point backwards to _front
        DLLNode<T> tmp  = new DLLNode<T>(s, null, _front);

        //No null elements shall be added to our deque, throws error
        if (s.equals(null)) {
          throw new NullPointerException();
        }

        //If list is empty, initialize the first node.
	      //Both head and tail need to be set to this node
        else if(isEmpty()){
            _back = tmp; //makes _back equal to the same node as _front
        }

        else {
            _front.setPrev(tmp); //makes _front point backwards to tmp
	      }

        _front = tmp; //makes tmp the new _front
        _size++; //increment _size by one
    }

    /*
    * Adds a new node containing the T argument as its cargo to the back of the deque.
    * If the list is empty, set the pointer variables (_front, _back) to the new node.
    * Otherwise, insert the node, having it point forwards to _back. Set _back to point backwards to this new node
    * Then assign variable _back to this new node.
    *
    * Throws a NullPointerException if asked to add a null element to the deque, in accordance with the api.
    * Runtime: O(1)
    */
    public void addLast(T s){
        //initialize a new node newNode, having it point forwards to _back
        DLLNode<T> tmp = new DLLNode<T>(s, _back, null);

        //No null elements shall be added to our deque, throws error
        if (s.equals(null)) {
          throw new NullPointerException();
        }

        //If list is empty, initialize the first node.
	      //Both head and tail need to be set to this node
        else if(isEmpty()){
            _front = tmp; //makes _front also equal to _back
        }

        else {
            _back.setNext(tmp); //makes _back point forwards to tmp
        }

        _back = tmp; //makes _back equal to the same node as _front
        //Increment size by one
        _size++;
    }

    /*
    * Removes and returns the contents of the first node, _front.
    * If the list is empty, return null.
    * Otherwise, remove the node, set _front to point to the next node in the deque.
    *
    * Runtime: O(1)
    */
    public T pollFirst(){ //[O(1) runtime]


        if(isEmpty()){
            return null;
        }

        else{
            T retVal = _front.getCargo();
            _front = _front.getNext();
            _size --;
            return retVal;
        }
    }

    /*
    * Removes and returns the contents of the last node, _back.
    * If the list is empty, return null.
    * Otherwise, remove the node, set _back to point to the previous node in the deque.
    *
    * Runtime: O(1)
    */
    public T pollLast(){
        if(isEmpty()){
            return null;
        }
        else{
            T retVal = _back.getCargo();
            _back = _back.getPrev();
            _size --;
            return retVal;
        }
    }

/*
    * Removes and returns the contents of the first node, _front.
    * If the list is empty, throw an exception
    * Otherwise, remove the node, set _front to point to the next node in the deque.
    *
    * Runtime: O(1)
    */
    public T removeFirst(){ //[O(1) runtime]
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        else{
            T retVal = _front.getCargo();
            _front = _front.getNext();
            _size --;
            return retVal;
        }
    }

    /*
    * Removes and returns the contents of the last node, _back.
    * If the list is empty, throw an exception
    * Otherwise, remove the node, set _back to point to the previous node in the deque.
    *
    * Runtime: O(1)
    */
    public T removeLast(){

        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            T retVal = _back.getCargo();
            _back = _back.getPrev();
            _size --;
            return retVal;
        }
    }

    /*
    * Returns the cargo of the first (_front) node of the deque
    * Returns null if deque is Empty
    *
    * Runtime: O(1)
    */
    public T peekFirst(){
        if (isEmpty())
          return null;
        return _front.getCargo();
    }

    /*
    * Returns the cargo of the last node (_back) of the deque
    * Returns null if deque is Empty
    *
    * Runtime: O(1)
    */
    public T peekLast(){
      if (isEmpty())
        return null;
      return _back.getCargo();
    }

    /*
    * Returns the size (as an integer) of the deque
    *
    * Runtime: O(1)
    */
    public int size(){
        return _size;
    }

    /*
    * Returns a boolean value of whether or not the the deque is empty
    *
    * Runtime: O(1)
    */
    public boolean isEmpty(){
        return _size == 0;
    }

    /*
    * If deque is empty, return false.
    * If given argument is a null element, throw a NullPointerException in accordance with the API.
    * Otherwise, iterates through the list, and checks if the cargo of each element is equal to the argument. If the cargo of one element is equal, returns true.
    * If the deque does not contain the element, returns false.
    *
    * Runtime: O(n)
    */
    public boolean contains(T s){
      if (s.equals(null))
        throw new NullPointerException();

	     else if ( isEmpty() ) {
         return false;
       }
	     else {
	        DLLNode<T> temp = _front;
	        while ( !temp.equals(_back) ) {
            //Debugging
            //System.out.println(temp + " : " + _front);
		        if ( temp.getCargo().equals(s) ) {
              return true;
            }
		        else {
              temp = temp.getNext();
            }
	        }

          return false;
	       }
    }

    /*
    * If given argument is null, throw a NullPointerException in accordance with the API.
    * If the deque is empty, return false.
    * Temporary node is set to _front.
    * Otherwise, iterate forwards through the list, and if the cargo of the temporary node is equal to the given argument, remove that node and return false.
    * If the node to remove is _front, only set the next node's forwards pointer to null. Set _front to the next node.
    * If the node to remove is _back, only set the previous node's backwards pointer to null. Set _back to the next node.
    * If the list is fully iterated through, return false.
    *
    * Runtime: O(n)
    */
    public boolean removeFirstOccurrence(T o) {
      DLLNode<T> temp = _front;
      if (o.equals(null))
        throw new NullPointerException();
      while (!temp.equals(null)) {

        if (temp.getCargo().equals(o)) {

          if (temp.equals(_front)) {
            _front = temp.getNext();
            temp.getNext().setPrev(null);
            _size --;
          }

          else if (temp.equals(_back)) {
            _back = temp.getPrev();
            temp.getPrev().setNext(null);
            _size --;
          }

          else {
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
            _size --;
          }

          return true;

        }

        else {
          temp = temp.getNext();
        }
    }

    return false;
    }

    /*
    * If given argument is null, throw a NullPointerException in accordance with the API.
    * If the deque is empty, return false.
    * Temporary node is set to _back.
    * Otherwise, iterate backwards through the list, and if the cargo of the temporary node is equal to the given argument, remove and that node and return false.
    * If the node to remove is _front, only set the next node's forwards pointer to null. Set _front to the next node.
    * If the node to remove is _back, only set the previous node's backwards pointer to null. Set _back to the next node.
    * If the list is fully iterated through, return false.
    *
    * Runtime: O(n)
    */
    public boolean removeLastOccurrence(T o) {
      boolean retVal = false;
      DLLNode<T> temp = _back;
      if (o.equals(null))
        throw new NullPointerException();
      while (!temp.equals(null)) {

        if (temp.getCargo().equals(o)) {
          retVal = true;

          if (temp.equals(_front)) {
            _front = temp.getNext();
            temp.getNext().setPrev(null);
            _size --;
          }

          else if (temp.equals(_back)) {
            _back = temp.getPrev();
            temp.getPrev().setNext(null);
            _size --;
          }

          else {
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
            _size --;
          }
          break;
        }

        else {
          temp = temp.getPrev();
        }
    }
    return retVal;
    }

    /* Returns a string visual of the deque, with markers for _front and _back included, and linkages between nodes shown
    *
    * Runtime: O(n)
    */
    public String toString(){
	    String retStr = "Front|| ";
	    DLLNode<T> tmp = _front;
      int count = 0;
      while( tmp != _back.getNext() ) {
        retStr += tmp.getCargo() + " <-> ";
        tmp = tmp.getNext();
      }

      return retStr + "|| Back";

    }

    public static void main(String[] args){
        QQKachoo<String> q = new QQKachoo<String>();

        System.out.println("adding 1 to front: ");
        q.addFirst("1");
        System.out.println(q);
       	System.out.println("adding 2 to back: ");
        q.addLast("2");
        System.out.println(q);

	       System.out.println();

	      System.out.println("adding 100 to front: ");
        q.addFirst("100");
        System.out.println(q);
       	System.out.println("adding 200 to back: ");
        q.addLast("200");
        System.out.println("adding 2 to back: ");
        q.addLast("2");
        System.out.println(q);
        System.out.println("Front value: " + q.peekFirst() + "\n" + "Back value: " + q.peekLast());
        System.out.println("size: " + q.size());
      	System.out.println();

      	System.out.println(q);
      	System.out.print( "Contains 10? " ) ;
      	System.out.println( q.contains("10") ) ;
      	System.out.print( "Contains 100? " ) ;
      	System.out.println( q.contains("100") ) ;

      	System.out.println();

        System.out.println(q);

        System.out.println("removing First occurance: " + q.removeFirstOccurrence("2"));
        System.out.println(q);
        System.out.println("size: " + q.size());

        System.out.println("removing Last occurance: " + q.removeLastOccurrence("100"));
        System.out.println(q);
        System.out.println("size: " + q.size());

        System.out.println( "polling first: " + q.removeFirst()) ;
        System.out.println(q);
        System.out.println("size: " + q.size());

        System.out.println( "polling first: " + q.removeFirst()) ;
        System.out.println(q);
        System.out.println("size: " + q.size());

        System.out.println( "polling last: " + q.removeLast()) ;
        System.out.println(q);
        System.out.println("size: " + q.size());
	   System.out.println( "polling last: " + q.removeLast()) ;
        System.out.println(q);


      }
}
