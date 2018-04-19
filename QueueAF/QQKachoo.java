public class QQKachoo implements Deque{

    private DLLNode<String> _front, _back;
    private int _size;

    public QQKachoo(){
	_front = null;
	_back = null;
	_size = 0;
    }
    
    public void addFirst(String s){ //[O(1) runtime]
	//If list is empty, initialize the first node.
	//Both head and tail need to be set to this node
        if(_size == 0){
            DLLNode<String> tmp = new DLLNode<String>(s, null,  _front ); //makes tmp point forwards to _front
            _front = tmp; //makes tmp the new _front
            _back = _front; //makes _back also equal to the same node as _front
        }

        else{
            DLLNode<String> tmp = new DLLNode<String>(s, null,  _front ); //makes tmp point forwards to _front
            _front.setPrev(tmp); //makes _front point backwards to tmp
            _front = tmp; //makes tmp the new _front
	}

	_size++;
    }
    
    public void addLast(String s){ //[O(1) runtime]
        if(_size == 0){ //if size is 0, you need to make _front point to the same new node as _back
            DLLNode<String> tmp = new DLLNode<String>(s, _back, null); //makes tmp point backwards to _back
            _back = tmp; //makes tmp the new _back
            _front = _back; //makes _front also equal to _back
        }
        else{
            DLLNode<String> tmp = new DLLNode<String>(s, _back, null); //makes tmp point backwards to _back
            _back.setNext(tmp); //makes _back point forwards to tmp
            _back = tmp; //makes tmp the new _back
        }

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

	if ( isEmpty() ) { return false; } //An empty deque cannot contain the element "s"
	if ( size() == 1 ) { return _front.getCargo().equals(s); } //Return true id the cargo at front equals "s"
	else { //If there is more than one element in the deque
	    DLLNode temp = _front; //Set a temp DLLNode at the front
	    while ( !temp.equals(_back) ) { //And while temp isn't at the back yet
		if ( temp.getCargo().equals(s) ) { return true; } //If the cargo at temp equals s, return true
		else { temp = temp.getNext(); } //If the cargo at temp doesn't equal s, move temp up to the next DLLNode
	    } //If temp reaches the back but you have not found s in any DLLNode
	    return false; //Then s is not present in the deque!
	} //So exit your else case	
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
