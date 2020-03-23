/* Victoria Nerecina
CS245 practice assignment 6

The functions defined in List must be implemented in these classes
specifically: add (two versions), get, remove, size

ArrayList.java
The constructor for ArrayList.java must create an array of size 10
    where the data (added through the add function) is stored
The array must be doubled from its original size if additional array positions are required
Additional functions may also be used
 */

//import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
//import java.lang.Exception;


public class ArrayList<T> implements List<T>
{
    T[] arr;
    int size;

//creat generic array in java
    //from edureka.co
//    public ArrayList(Class<T> classT, int sizeT)
//    {
//        typeT = classT;
//        size = sizeT;
//        arr = (T[])Array.newInstance(typeT, size);
//    }
//wokrs???

    public ArrayList()
    {
        //help from SLack
        arr = (T[]) new Object[10];
        size = 0;
    }



    public void doubleArray()
    { //for add
        T[] tempArr = (T[]) new Object[arr.length * 2];
        //size = size * 2;
        //tempArr = (T[])Array.newInstance(typeT, size);
        for(int i = 0; i < size; i++)
        {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }



    public void add(Object item)
    {
        if (arr.length == size)
        {
            int previousSize = size;
            doubleArray(); //double the size to make room to add
            for(int i = size - 1; i > previousSize; i--)
            {
                arr[i] = arr[i-1];
                //arr[previousSize + 1] = item;
            }
            arr[previousSize + 1] = (T) item;
        }
        else
        {
            arr[size++] = (T) item;
        }
    }


    public void add(int position, T item)
    {
        //check pos < 0
        if(arr.length == size)
        {
            doubleArray();
            for(int i = size - 1; i > position; i--)
            {
                arr[i] = arr[i-1];
            }
            arr[position] = item;
            ++size;
        }
        else
        {
            for(int i = size - 1; i > position; i--)
            {
                arr[i] = arr[i-1];
            }
            arr[position] = item;
            ++size;
        }
    }



    public T get(int position)
    {
        if (position < 0 || position >= size)
        {
           throw new IndexOutOfBoundsException();
        }
        else
            {
            return arr[position];
        }
    }



    public T remove(int position)
    {
        //check position < 0
        if(position < 0 || position >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        if(position == size - 1)
        {
            size--;
        }
        else
        {
            for(int i = position; i < size - 1; i++)
            {
                arr[i] = arr[i+1];
            }
            size--;
        }
        return arr[position];
    }




    public int size()
    {
        return size;
    }

}