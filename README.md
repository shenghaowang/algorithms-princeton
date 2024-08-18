# Assignments of the Coursera algorithms course offered by Princeton University
![Princeton logo](img/princeton.jpg)

## Course websites
* [Algorithms, Part I](https://www.coursera.org/learn/algorithms-part1/)

## Installation
* [Java environment for Mac OS](https://lift.cs.princeton.edu/java/mac/)

## Part I

### Module 1 Hello, World
* [Assignment instructions](https://coursera.cs.princeton.edu/algs4/assignments/hello/specification.php)
* [Solutions](src/part1/module1_course_intro)
* Commands for testing the program

```
cd src/part1/module1_course_intro
javac-algs4 RandomWord.java
java-algs4 RandomWord < animals8.txt
```

### Module 2 Percolation
* [Assignment instructions](https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php)
* [Solutions](src/part1/module2_union_find)
* Commands for testing the program

```
cd src/part1/module2_union_find
javac-algs4 Percolation.java
java-algs4 Percolation 10

javac-algs4 PercolationStats.java
java-algs4 PercolationStats 200 100
```

### Module 4 Stacks and Queues
* [Linked list implementation of stack](src/part1/module4_stacks_queues/LinkedStackOfStrings.java)
* [Array implementation of stack](src/part1/module4_stacks_queues/FixedCapacityStackOfStrings.java)
* [Resizing array implementation of stack](src/part1/module4_stacks_queues/ResizingArrayStackOfStrings.java)
* [Linked list implementation of queue](src/part1/module4_stacks_queues/LinkedQueueOfStrings.java)
* [Generics implementation of stack](src/part1/module4_stacks_queues/Stack.java)
* [Iterator implementation of bag](src/part1/module4_stacks_queues/Bag.java)
* [Iterator implementation of deque](src/part1/module4_stacks_queues/Deque.java)
* [Resizing array implementation of randomized queue](src/part1/module4_stacks_queues/RandomizedQueue.java)

* [Assignment instructions](https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php)
* Commands for testing [the client program](src/part1/module4_stacks_queues/Permutation.java)

```
javac-algs4 Permutation.java

java Permutation 3 < distinct.txt
java Permutation 8 < duplicates.txt
```