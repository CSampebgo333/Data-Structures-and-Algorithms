import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class BasicArrayList <T> {
    // Initialize the instances
    private int size = 0;
    private T[] baseArray;
    private T[] copyArray;

    // Build constructors
    public BasicArrayList(){
        this.baseArray = (T[]) new Object[size];
    }

    public BasicArrayList(Collection<T> collection){
        Iterator myIterator = collection.iterator();
        while (myIterator.hasNext()){
            add((T) myIterator.next());
        }
    }

    // Build methods
    public T get(int index){
        checkIndex(index);
        return baseArray[index];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void displayArray(){
        System.out.println(Arrays.toString(baseArray));
    }

    public void checkIndex(int index){
        if (index < 0 || index >= size){
            throw  new IndexOutOfBoundsException();
        }
    }

    public void add(T element){
        copyArray = (T[]) new Object[size + 1];

        for(int i = 0; i < size; i++){
            copyArray[i] = baseArray[i];
        }
        copyArray[size] = element;
        baseArray = copyArray;
        size ++;
    }

    public T remove(int index){
        checkIndex(index);
        copyArray = (T[]) new Object[size - 1];

        for (int i = 0; i < index; i ++){
            copyArray[i] = baseArray[i];
        }
        for(int i = index + 1; i < size; i ++){
            copyArray[i - 1] = baseArray[i];
        }
        T removedElement = baseArray[index];
        baseArray = copyArray;
        size --;
        return removedElement;

    }
}
