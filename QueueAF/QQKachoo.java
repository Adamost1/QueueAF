public class QQKachoo implements Deque{

    private DLLNode<String> _front, _back;
    private int _size;

    public QQKachoo(){
	_front = null;
	_back = null;
	_size = 0;
    }
    
    public void addFirst(String s){
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
    
    public void addLast(String s){
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


    public String pollFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            String retVal = _front.getCargo();
            _front = _front.getNext();
            return retVal;
        }       
    }

    public String pollLast(){
        if(isEmpty()){
            return null;
        }
        else{
            String retVal = _back.getCargo();
            _back = _back.getPrev();
            return retVal;
        }
    }

    public String peekFirst(){
        return _front.getCargo();
    }
    public String peekLast(){
        return _back.getCargo();
    }
    public int size(){
        return _size;
    }

    public boolean isEmpty(){
        return _size == 0;
    }  


    public String toString()
    {
    String retStr = "Front|| ";
    DLLNode<String> tmp = _front; 
    while( tmp != _back.getNext() ) {
        retStr += tmp.getCargo() + " <-> ";
        tmp = tmp.getNext();
    }
    retStr = retStr.substring(0, retStr.length() - 4) + " ||Back";
    return retStr;
    }

    public static void main(String[] args){
        QQKachoo q = new QQKachoo();
        System.out.println("addingFirst and addingLast: ");
        q.addFirst("1");
        q.addLast("2");
        System.out.println(q);

        q.addFirst("100");
        q.addLast("200");
        System.out.println(q);
        System.out.println("Front value: " + q.peekFirst() + "\n" + "Back value: " + q.peekLast());

        System.out.println( "polling first: " + q.pollFirst()) ;
        System.out.println(q);

        System.out.println( "polling first: " + q.pollFirst()) ;
        System.out.println(q);

        System.out.println( "polling last: " + q.pollLast()) ;
        System.out.println(q);



    }
}
