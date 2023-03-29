package com.company;

public class Main {

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println(q.front());
        System.out.println(q.rear());
        System.out.println(q.isEmpty());

        q.display();
    }
}
