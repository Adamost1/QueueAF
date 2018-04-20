/*
Q(ueue)AF - Ryan Kim, Joshua Weiner, Alvin Ye
APCS2 - pd08
L #02: All Hands on Deque! (Not Schenectady; rather, synecdoche.)
2018 - 04 - 18
*/
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

    /* Returns a string visual of the deque, with markers for _front and _back included, and linkages between nodes shown
    *
    * Runtime: O(n)
    */
    public String toString(){
	     String retStr = "Front|| ";
	     DLLNode<T> tmp = _front;
	      while( tmp != _back.getNext() ) {
	         retStr += tmp.getCargo() + " <-> ";
	         tmp = tmp.getNext();
	      }
	      retStr = retStr.substring(0, retStr.length() - 4) + " ||Back";
	      return retStr;
    }


    public boolean contains(T s){ //Starting the contains() method... [O(n) runtime]

      //An empty deque cannot contain the element "s"
	     if ( isEmpty() ) {
         return false;
       }
	     else { //If there is more than one element in the deque
	        DLLNode temp = _front; //Set a temp DLLNode at the front
	        while ( !temp.equals(_back) ) {
            //Debugging
            //System.out.println(temp + " : " + _front);

            //And while temp isn't at the back yet
		        if ( temp.getCargo().equals(s) ) {
              return true;
            } //If the cargo at temp equals s, return true
		        else {
              temp = temp.getNext();
            } //If the cargo at temp doesn't equal s, move temp up to the next DLLNode
	        } //If temp reaches the back but you have not found s in any DLLNode

          return false; //Then s is not present in the deque!
	       } // exit your else case
    } //And you're done with contains()!

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
        System.out.println(q);
        System.out.println("Front value: " + q.peekFirst() + "\n" + "Back value: " + q.peekLast());

      	System.out.println();

      	System.out.println(q);
      	System.out.print( "Contains 10? " ) ;
      	System.out.println( q.contains("10") ) ;
      	System.out.print( "Contains 100? " ) ;
      	System.out.println( q.contains("100") ) ;

      	System.out.println();

        System.out.println( "polling first: " + q.pollFirst()) ;
        System.out.println(q);

        System.out.println( "polling first: " + q.pollFirst()) ;
        System.out.println(q);

        System.out.println( "polling last: " + q.pollLast()) ;
        System.out.println(q);

	      System.out.println( "polling last: " + q.pollLast()) ;
        System.out.println(q);



    }
}
