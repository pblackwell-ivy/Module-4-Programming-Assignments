package Exercise24_4;
import java.util.ArrayList;

public class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    // return number of elements in the stack
    public int getSize() {
        return list.size();
    }

    // look at the top element without removing it
    public E peek() {
        return list.get(getSize() - 1);
    }

    // push (add) an element onto the stack
    public void push(E o) {
        list.add(o);
    }

    // pop (remove) the top element and return it
    public E pop() {
        return list.remove(getSize() - 1);
    }

    // check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}
