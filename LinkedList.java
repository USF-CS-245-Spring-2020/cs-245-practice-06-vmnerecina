/* Victoria Nerecina
CS245 practice assignment 6


The functions defined in List must be implemented in these classes
specifically: add (two versions), get, remove, size


LinkedList.java
 */

import java.util.*;
//import java.lang.Exception;

//class Node<T> { //in class notes, code
//    public T data;
//    public Node next;
//
//    public Node(T data) {
//        this.data = data;
//        this.next = null;
//    }
//
//}

public class LinkedList<T> implements List<T>
{
    //linked list: a;ways use size and head
    Node head;
    int size;


    private class Node
    { //from in class notes and discussion
        T data;
        Node next;
        public Node(T item)
        {
            this.data = item;
            this.next = null;
        }
    }






    public LinkedList() //constructor
    { //linked list: always use head and size
        this.size = 0;
        this.head = new Node(null);
    }



    public void add(T item)
    {
        //a. current = Node(item) -- create Node, place item, call it current
        //b. prev.next = current
        //c. ++size
        if(head.data == null)
        {
            head = new Node(item); //head = current
            //head.data = current;
            ++size;
        }
        else
        {
            Node current = new Node(item);
            Node previous = head;
            for(int i = 0; i < size - 1; i++)
            {
                previous = previous.next;
            }
            //Node current = new Node(item);
            previous.next = current;
            ++size;
        }
    }




    public void add(int position, T item)
    {
        if(position == 0)
        {
            Node current = new Node(item);
            current.next = head;
            head = current;
            ++size;
        }
        else
        {
            Node previous = head;
            //for(int i = 0; i < position - 1; i++) //????
            for(int i = 0; i < position; i++) //??????
            {
                previous = previous.next;
            }
            Node current = new Node(item);
            current.next = previous.next;
            previous.next = current;
            ++size;
        }

    }



    public T get(int position)
    {
        if(position < 0 || position >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        Node node = head; //temp node = head
        for(int i = 0; i < position; i++)
        {
            node = node.next;
        }
        return node.data;

    }



    public T remove(int position)
    {
        //a. current = head
        //b. head = head.next
        //c. --size
        //d. return current.data
        if(position < 0 || position >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        if(position == 0)
        {
            Node current = head;
            head = head.next;
            --size;
            return current.data;
        }
        else
        {
            Node previous = head;
            for(int i = 0; i < position; i++)
            {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            --size;
            return current.data;
        }

    }



    public int size()
    {
        return size;
    }

}

