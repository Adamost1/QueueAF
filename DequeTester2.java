public class DequeTester2{

    public static void main (String [] args){
	Deque<String> Test = new QQKachoo<String>();
	for(int x = 0; x < 3; x++){
	    Test.addFirst(""+x);
	    Test.addLast("-"+x);
	    
	}//fills deque with 3, 2, 1, -1, -2, -3
	System.out.println(Test);
	System.out.println("PeekingFirst:" + Test.peekFirst());
	System.out.println("PeekingLast:" + Test.peekLast());
	//Test.removeFirstOccurrence("-0");// cannot use because its not in the interface
	System.out.println("Printing test:\n" + Test);
	System.out.println("Does it contain -0?\n" + Test.contains("-0"));
	for (int x = 0; x < 3;x++){
	    System.out.println("Polling Last: " + Test.pollLast());
	    System.out.println("Polling First: " + Test.pollFirst());

	}
	System.out.println("Should be empty:"+ Test);//It should be empty by now but theres something still in it? Theres also a pollfirst that should have returned 0 but only returned null?
	System.out.println(Test.pollFirst());



    }

}
