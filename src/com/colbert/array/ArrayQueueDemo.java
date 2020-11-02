package com.colbert.array;


import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2020/10/31 13:59
 * @Author Colbert
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        Scanner scanner = null;
        char key;
        while (true) {
            System.out.println("a(addQueue)，添加一个数到队列");
            System.out.println("g(getQueue)，从队头取出一个数据");
            System.out.println("p(peekHead)，查看队头数据");
            System.out.println("s(showQueue)，打印队列中的元素");
            System.out.println("e(exit)，退出程序");
            scanner = new Scanner(System.in);
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入你要添加的数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int result = 0;
                    try {
                        result = queue.getQueue();
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
                    queue.showQueue();
                    break;
                case 'e':
                    return;
                default:

            }
        }

    }
}
class Queue {
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] num;

    /**
     *  初始化一个队列
     */

    public Queue(int maxSize){
        this.maxSize = maxSize;
        num = new int[maxSize];
        rear = -1;
        front = -1;
    }

    /**
     * 判断队列是否为空
     * @return turn or false
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断是否队列满
     * @return true or false
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int data) {
        if (isFull()) {
            System.out.println("队列满，无法添加");
            return;
        }
        rear++;
        num[rear] = data;
    }

    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法取出数据");
        }
        front++;
        return num[front];
    }

    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(num[i]);
        }
    }

    public int peekHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出数据");
        }
        return num[front+1];
    }
}
