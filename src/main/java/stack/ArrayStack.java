package stack;

import java.util.Stack;

/**
 * @Classname ArrayStack
 * @Description TODO
 * @Date 4/2/2020 9:23 AM
 * @Created by Administrator
 */
public class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void showStack() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        for (int i = top; i >=0; i--) {
            System.out.println(stack[i]);
        }
    }
}
