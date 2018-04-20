# Q(ueue)AF
### Ryan Kim, Joshua Weiner, Alvin Ye
## Summary of Development Plan
We decided to implement only the most important methods necessary for a deque, which was ```addFirst(T s)``` and ```addLast(T s)``` to enqueue elements, ```pollFirst()``` and ```pollLast()``` to dequeue elements, ```peekFirst()``` and ```peekLast()``` in order to return what elements are at each head. We also chose to implement ```size()```, ```contains(T s)```, ```isEmpty()``` for users to be able to <br>
At first, we implemented this all without generic typing in order to incrementally develop. Later on however, we generically typed ```Deque.java```.  

* For Deque, we implemented a DLList, because it is easier to visualize, especially using front and back pointers. When we draw diagrams it would be easier to follow than if we were to use ArrayList. Furthermore all of the methods used in this implementation ran in the same time for a LinkedList and ArrayList, so this was purely a practical and stylistic choice.
* We chose to not throw capacity exceptions (see: [IllegalStateException](https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalStateException.html)) because we configured our deque to not have said capacity limitations.
* We also chose not to implement methods that throw NoSuchElementExceptions because we then had to import the java utils in order to throw them, methods that returned null such as ```peekFirst()``` and ```peekLast()``` were much easier to implement and serviced effectively the same function.

## Methods implemented & tasks completed:
* ```void addFirst(T s)``` <br>
Adds a new node containing the T argument as its cargo to the front of the deque.
If the list is empty, set the pointer variables (front & back) to the new node.
Otherwise, insert the node, having it point backwards to front. Set front to point to the new node, then assign variable front to this new node.
Throws a NullPointerException if asked to add a null element to the deque, in accordance with the API. <br>
Runtime: O(1)
* ```void addLast(T s)```<br>
Adds a new node containing the T argument as its cargo to the back of the deque.
If the list is empty, set the pointer variables (front & back) to the new node.
Otherwise, insert the node, having it point forwards to back. Set back to point to the new node, then assign variable back to this new node.
Throws a NullPointerException if asked to add a null element to the deque, in accordance with the API. <br>
Runtime: O(1)
* ```String pollFirst()``` <br>
Removes and returns the contents of the first node, front.
If the list is empty, return null.
Otherwise, remove the node, set front to point to the next node in the deque. <br>
Runtime: O(1)
* ```String pollLast()``` <br>
Removes and returns the contents of the last node, back.
If the list is empty, return null.
Otherwise, remove the node, set back to point to the previous node in the deque. <br>
Runtime: O(1)
* ```String peekFirst()``` <br>
Returns the cargo of the first (front) node of the deque.
Returns null if deque is Empty. <br>
Runtime: O(1)
* ```String peekLast()``` <br>
Returns the cargo of the first (back) node of the deque.
Returns null if deque is Empty. <br>
Runtime: O(1)
* ```boolean removeFirstOccurrence(T s)``` <br>
If given argument is null, throw a NullPointerException in accordance with the API.
If the deque is empty, return false.
Temporary node is set to front.
Otherwise, iterate forwards through the list, and if the cargo of the temporary node is equal to the given argument, remove that node and return false.
If the node to remove is front, only set the next node's forwards pointer to null. Set front to the next node.
If the node to remove is back, only set the previous node's backwards pointer to null. Set back to the next node.
If the list is fully iterated through, return false. <br>
Runtime: O(n)
* ```boolean removeLastOccurrence(T s)``` <br>
If given argument is null, throw a NullPointerException in accordance with the API.
If the deque is empty, return back.
Temporary node is set to front.
Otherwise, iterate backwards through the list, and if the cargo of the temporary node is equal to the given argument, remove that node and return false.
If the node to remove is front, only set the next node's forwards pointer to null. Set front to the next node.
If the node to remove is back, only set the previous node's backwards pointer to null. Set back to the next node.
If the list is fully iterated through, return false. <br>
Runtime: O(n)
* ```int size()``` <br>
Returns the size (as an integer) of the deque. <br>
Runtime: O(1)
* ```boolean isEmpty()``` <br>
Returns a boolean value of whether or not the the deque is empty. <br>
Runtime: O(1)
* ```boolean contains(T s)``` <br>
If deque is empty, return false. If given argument is a null element, throw a NullPointerException in accordance with the API. Otherwise, iterates through the list, and checks if the cargo of each element is equal to the argument. If the cargo of one element is equal, returns true. If the deque does not contain the element, returns false. <br>
Runtime: O(n)
* added comments and descriptions of algorithms
* eliminate repetitions in code
* Enabled generic typing for Deque
