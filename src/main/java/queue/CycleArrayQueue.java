package queue;

/**
 * @Classname CycleArrayQueue
 * @Description TODO
 * @Date 3/31/2020 4:42 PM
 * @Created by Administrator
 */
public class CycleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CycleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0; //隊列的head
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addItem(int item) {
        if (isFull()) {
            System.out.println("Queue is full. cannot add item");
            return;
        }
        arr[rear] = item;
        rear = (rear + 1) % maxSize;
    }

    public int getItem() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int head = arr[front];
        front = (front + 1) % maxSize;
        return head;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        for (int i = front; i < front + queueSize(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    public int queueSize() {
        return (rear + maxSize - front) % maxSize;
    }

    public int getHeadItem() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }
}
