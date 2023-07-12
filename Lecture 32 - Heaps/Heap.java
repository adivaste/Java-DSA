// package com.company;

public class Heap{

      // Heap is the array of elements
      private int[] heap = new int[100];
      private int size;

      // Constructor
      public Heap(){
            this.heap[0] = -1;
            this.size = 0;
      }

      // Insert function
      public void insert(int value){
            this.size += 1;
            int index = this.size;
            this.heap[index] = value;

            // Inserting at correct position
            while(index > 1){
                  int parent = index/2;
                  if (heap[parent] < heap[index]){
                        int temp = heap[parent];
                        heap[parent] = heap[index];
                        heap[index] = temp;

                        index = parent;
                  }
                  else return;
            }
      }

      public void print(){
            for(int i=1; i<this.size; i++){
                  System.out.println(this.heap[i]);
            }
      }

      public static void main(String[] args){
            Heap h = new Heap();
            h.insert(5);
            h.insert(45);
            h.insert(23);
            h.insert(78);
            h.insert(15);
            
            h.print();
      }

}