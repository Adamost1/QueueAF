# Q(ueue)AF
### Ryan Kim, Joshua Weiner, Alvin Ye
## Summary of Development Plan
We decided to implement only the most important methods necessary for a deque, which was ```addFirst(T s)``` and ```addLast(T s)``` to enqueue elements, ```pollFirst()``` and ```pollLast()``` to dequeue elements, ```peekFirst()``` and ```peekLast()``` in order to return what elements are at each head. We also chose to implement ```size()```, ```contains(T s)```, ```isEmpty()``` for users to be able to <br>
At first, we implemented this all without generic typing in order to incrementally develop. Later on however, we generically typed ```Deque.java```.  

* For Deque, we implemented a DLList, because it is easier to visualize, especially using front and back pointers. When we draw diagrams it would be easier to follow than if we were to use ArrayList. Furthermore all of the methods used in this implementation ran in the same time for a LinkedList and ArrayList, so this was purely a practical and stylistic choice.
* We chose to not throw capacity exceptions (see: [IllegalStateException](https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalStateException.html)) because we configured our deque to not have said capacity limitations.
* We also chose not to implement methods that throw NoSuchElementExceptions because we then had to import the java utils in order to throw them, methods that returned null such as ```peekFirst()``` and ```peekLast()``` were much easier to implement and serviced effectively the same function.

## Methods implemented & tasks completed:
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

## Other things to do:
* add comments and descriptions of algorithms
* eliminate repetitions in code
