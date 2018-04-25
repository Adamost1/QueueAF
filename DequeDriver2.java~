//Team code_till_you_drop (Shruthi Venkata, Colin Hosking, Aaron Li)
//courtesy of Team StillCold (Fiona Cai, Kevin Feng, Alexia Leong)
//APCS2 pd8
//QQCachoo Driver
/*
__---~~~~--__                      __--~~~~---__
`\---~~~~~~~~\\                    //~~~~~~~~---/'
 \/~~~~~~~~~\||                  ||/~~~~~~~~~\/
             `\\                //'
               `\\            //'
                 ||          ||
       ______--~~~~~~~~~~~~~~~~~~--______
  ___ // _-~                        ~-_ \\ ___
 `\__)\/~                              ~\/(__/'
  _--`-___                            ___-'--_
/~     `\ ~~~~~~~~------------~~~~~~~~ /'     ~\
/|        `\         ________         /'        |\
| `\   ______`\_      \------/      _/'______   /' |
|   `\_~-_____\ ~-________________-~ /_____-~_/'   |
`.     ~-__________________________________-~     .'
`.      [_______/------|~~|------\_______]      .'
`\--___((____)(________\/________)(____))___--/'
 |>>>>>>||                            ||<<<<<<|
*/

public class DequeDriver{
  public static void main(String[] args) {
    QQCachoo<String> iscream = new QQCachoo<String>();

    System.out.println("-----Adding to front------");
    iscream.addFirst("Chocolate");
    System.out.println(iscream.peekFront()); //Chocolate
    iscream.addFirst("Vanilla");
    System.out.println(iscream.peekFront()); //Vanilla
    iscream.addFirst("Strawberry");
    System.out.println(iscream.peekFront()); //Strawberry
    iscream.addFirst("Mint");
    System.out.println(iscream.peekFront()); //Mint

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(iscream); //Mint Strawberry Vanilla Chocolate

    System.out.println("");

    System.out.println("-----Adding to end------");
    iscream.addLast("Pistachio");
    System.out.println(iscream.peekLast()); //Pistachio
    iscream.addLast("Coffee");
    System.out.println(iscream.peekLast()); //Coffee
    iscream.addLast("S'mores");
    System.out.println(iscream.peekLast()); //S'mores

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(iscream); //Mint Strawberry Vanilla Chocolate Pistachio Coffee S'mores

    System.out.println("");

    System.out.println("-----Removing from front-----");
    iscream.removeFirst(); //Mint  dies
    System.out.println(iscream.peekFront()); //Strawberry

    System.out.println("");

    System.out.println("-----Removing from end-----");
    iscream.removeLast(); //S'mores dies
    System.out.println(iscream.peekLast()); //Coffee

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(iscream); //Mint Strawberry Vanilla Chocolate Pistachio Coffee S'mores

    System.out.println("");

    System.out.println("------REMOVING EVERYTHING------");
    iscream.removeFirst();
    System.out.println(iscream);
    iscream.removeLast();
    System.out.println(iscream);
    iscream.removeFirst();
    System.out.println(iscream);
    iscream.removeLast();
    System.out.println(iscream);
    iscream.removeFirst();
    System.out.println(iscream);
    System.out.println("Empty now?: "+iscream.isEmpty()); //true
  }





}
