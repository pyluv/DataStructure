package queue;

/**
 * @Classname ArrayQueue
 * @Description TODO
 * @Date 3/31/2020 2:03 PM
 * @Created by Administrator
 */
public class ArrayQueue {

    private int[] arr;
    private int front;
    private int rear;
    private int maxSize = 0;

    public ArrayQueue(int maxSize) {
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
        this.maxSize = maxSize;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addItem(int item) {
        if (isFull()) {
            System.out.println("Queue is full. cannot add item");
            return;
        }
        arr[++rear] = item;
    }

    public int getItem() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[++front];
    }

    public void showQueue() {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public int getHeadItem() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front + 1];
    }
}
