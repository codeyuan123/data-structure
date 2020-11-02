package com.colbert.array;

import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2020/11/2 15:43
 * @Author Colbert
 */
public class CircleQueueDemo {
    public static void main(String[] args) {

        CircleQueue queue = new CircleQueue(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("a(addQueue)，添加一个数到队列");
            System.out.println("g(getQueue)，从队头取出一个数据");
            System.out.println("p(peekHead)，查看队头数据");
            System.out.println("s(showQueue)，打印队列中的元素");
            System.out.println("e(exit)，退出程序");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入你要添加的数据");
                    int value = scanner.nextInt();
                    try {
                        queue.addElement(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    int result = 0;
                    try {
                        result = queue.getHead();
                        System.out.println("取出的数据为：" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'p':
                    int res = 0;
                    try {
                        res = queue.peekHead();
                        System.out.println("队头元素为:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 's':
                    try {
                        queue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    return;
                default:

            }
        }
    }

}
class CircleQueue{
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;

        // 将头和尾设为0，空出一个元素，为了方便区分头尾
        this.front = 0;
        this.rear = 0;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addElement(int n) {
        if (isFull()) {
            throw new RuntimeException("队列满，无法添加元素");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getHead(){
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法再取出数据");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public int peekHead(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法查看头元素");
        }
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
