import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyArrayList <T> {

    // Instances
    private int size = 0;
    private T[] baseArray;
    private T[] copyArray;

    // Constructors
    public MyArrayList(){
        this.baseArray = (T[]) new Object[size];
    }

    public MyArrayList(Collection<T> myCollection){
        Iterator<T> myIterator = myCollection.iterator();
        while (myIterator.hasNext()){
            add(myIterator.next());
        }
    }


    // Methods for Managing MyArrayList Dynamism
    public void checkIndex(int index){
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
    }

    public int size(){
        return this.size;
    }

    public T get(int index){
        checkIndex(index);
        return baseArray[index];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void displayArray(){
        System.out.println(Arrays.toString(baseArray));
    }

    public void add(T element){
        copyArray = (T[]) new Object[size + 1];

        for (int i = 0; i < size; i++){
            copyArray[i] = baseArray[i];
        }

        copyArray[size] = element;
        baseArray = copyArray;
        size ++;
    }

    public T remove(int index){
        checkIndex(index);
        copyArray = (T[]) new Object[size - 1];

        for (int i = 0; i < index; i++){
            copyArray[i] = baseArray[i];
        }
        for (int i = index + 1; i < size; i++){
            copyArray[i - 1] = baseArray[i];
        }

        T removedElement = baseArray[index];
        baseArray = copyArray;
        size --;
        return removedElement;
    }
}
