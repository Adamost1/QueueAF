# Q(ueue)AF
### Ryan Kim, Joshua Weiner, Alvin Ye
## Summary of Development Plan
We decided to implement only the most important methods necessary for a deque, which was addFirst() and addLast() to enqueue elements, ```pollFirst()``` and ```pollLast()``` to dequeue elements, ```peekFirst()``` and ```peekLast()``` in order to return what elements are at each head. <br>
	Methods that seem to do the same thing, like ```getFirst()``` vs ```peekFirst()```, or ```removeFirst()``` vs ```pollFirst()```.
	At first, we implemented this all without generic typing in order to incrementally develop. Later on however, we generically typed ```Deque.java```.  
	
* Background of DEQue is a DLList, because it is easier to visualize, especially using front and back pointers. When we draw diagrams it would be easier to follow than if we were to use ArrayList
* We chose to not throw capacity exceptions (see: [IllegalStateException](https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalStateException.html)) because we configured our deque to not have said capacity limitations.

## Methods implemented:
* ```void addFirst(T s)```
* ```void addLast(T s)```
* ```String pollFirst()```
* ```String pollLast()```
* ```String peekFirst()```
* ```String peekLast()```
* ```int size()```
* ```boolean isEmpty()```
* ```boolean contains(T s)```

* Enabled generic typing for Deque

## Future Methods to implement:
* implement the use of Iterator

## Other things to do:
* add comments and descriptions of algorithms
* eliminate repetitions in code
