public class QueueDriver {

    public static void main (String [] args) {
	//deque does not have all QQKachoo methods
	QQKachoo<String> test1 = new QQKachoo<String>();

	test1.addLast("b");
	test1.addLast("o");
	test1.addLast("b");
	test1.addFirst(" ");
	test1.addFirst("o");
	test1.addFirst("l");
	test1.addFirst("l");
	test1.addFirst("e");
	test1.addFirst("H");
	System.out.println(test1);

	test1.removeFirstOccurrence("b");
	test1.removeLastOccurrence("l");
	System.out.println(test1);

	System.out.println("test1 contains o: " + test1.contains("o"));
	System.out.println("test1 contains y: " + test1.contains("y"));
    }
}
