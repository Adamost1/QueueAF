/*
Q(ueue)AF - Ryan Kim, Joshua Weiner, Alvin Ye
APCS2 - pd08
L #02: All Hands on Deque! (Not Schenectady; rather, synecdoche.)
2018 - 04 - 18
*/
public class QQKachoo implements Deque{

    private DLLNode<String> _front, _back;
    private int _size;

    //Constructor, initialize variables
    public QQKachoo(){
	     _front = null;
	     _back = null;
	     _size = 0;
    }

    /*
    * Adds a new node containing the string argument as its cargo to the front of the deque.
    * If the list is empty, set the pointer variables (_front, _back) to the new node.
    * Otherwise, insert the node, having it point forwards to _front. Set _front to point backwards to the new _nextNode
    * Runtime: O(1)
    */
    public void addFirst(String s){
        //initialize a new node newNode, having it point forwards to _front
        DLLNode<String> tmp  = new DLLNode<String>(s, null, _front);

        //If list is empty, initialize the first node.
	      //Both head and tail need to be set to this node
        if(_size == 0){
            _back = tmp; //makes _back equal to the same node as _front
        }

        else {
            _front.setPrev(tmp); //makes _front point backwards to tmp
	      }

        _front = tmp; //makes tmp the new _front
        _size++; //increment _size by one
    }

    public void addLast(String s){ //[O(1) runtime]
        DLLNode<String> tmp = new DLLNode<String>(s, _back, null); //makes tmp point backwards to _back

        if(_size == 0){ //if size is 0, you need to make _front point to the same new node as _back
            _front = tmp; //makes _front also equal to _back
        }

        else {
            _back.setNext(tmp); //makes _back point forwards to tmp
        }

        _back = tmp; //makes tmp the new _back
        //Increment size by one
        _size++;
    }


    public String pollFirst(){ //[O(1) runtime]

        if(isEmpty()){
            return null;
        }
        
        else{
            String retVal = _front.getCargo();
            _front = _front.getNext();
            return retVal;
        }
    }

    public String pollLast(){ //[O(1) runtime]
        if(isEmpty()){
            return null;
        }
        else{
            String retVal = _back.getCargo();
            _back = _back.getPrev();
            return retVal;
        }
    }

    public String peekFirst(){ //[O(1) runtime]
        return _front.getCargo();
    }
    public String peekLast(){ //[O(1) runtime]
        return _back.getCargo();
    }
    public int size(){ //[O(1) runtime]
        return _size;
    }

    public boolean isEmpty(){ //[O(1) runtime]
        return _size == 0;
    }


    public String toString(){
	     String retStr = "Front|| ";
	     DLLNode<String> tmp = _front;
	      while( tmp != _back.getNext() ) {
	         retStr += tmp.getCargo() + " <-> ";
	         tmp = tmp.getNext();
	      }
	      retStr = retStr.substring(0, retStr.length() - 4) + " ||Back";
	      return retStr;
    }


    public boolean contains(String s){ //Starting the contains() method... [O(n) runtime]

      //An empty deque cannot contain the element "s"
	     if ( isEmpty() ) {
         return false;
       }
	     else { //If there is more than one element in the deque
	        DLLNode temp = _front; //Set a temp DLLNode at the front
	        while ( !temp.equals(null) ) { //And while temp isn't at the back yet
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
        QQKachoo q = new QQKachoo();
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
