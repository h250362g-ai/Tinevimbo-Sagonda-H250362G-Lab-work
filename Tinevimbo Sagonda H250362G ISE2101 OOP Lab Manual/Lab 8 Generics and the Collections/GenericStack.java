import java.util.ArrayList;
import java.util.EmptyStackException;

class Stack<T> {
    private ArrayList<T> elements = new ArrayList<>();

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

public class GenericStack {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();

        numbers.push(10);
        numbers.push(20);
        numbers.push(30);

        System.out.println("Top: " + numbers.peek());
        System.out.println("Removed: " + numbers.pop());
        System.out.println("Removed: " + numbers.pop());
        System.out.println("Empty: " + numbers.isEmpty());

        Stack<String> names = new Stack<>();
        names.push("Java");
        names.push("OOP");

        System.out.println("Top name: " + names.peek());
    }
}
