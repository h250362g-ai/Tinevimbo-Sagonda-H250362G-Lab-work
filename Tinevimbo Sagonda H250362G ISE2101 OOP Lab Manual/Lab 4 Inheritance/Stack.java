//Incorrect design: inheritance
import java.util.ArrayList;

public class Stack extends ArrayList<Integer> {
    public void push(int value) {
        add(value);
    }

    public int pop() {
        return remove(size() - 1);
    }
}


//This design is wrong because Stack extends ArrayList, 
// it exposes all the public methods of ArrayList, 
// including add(index, value), remove(index), and clear(). 
// A user can insert or remove elements from arbitrary positions, 
// bypassing the normal last-in-first-out (LIFO) stack behavior.


//Correct design: composition

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {
    private ArrayList<Integer> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(int value) {
        elements.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.remove(elements.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
    }
}