package com.company;
import java.util.ArrayList;

public class AdjacencyList{
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int vertices;

    public AdjacencyList(int noOfVertices){
        this.vertices = noOfVertices;
        this.adjacencyList = new ArrayList<>(this.vertices);

        for(int i=0; i<this.vertices; i++){
            this.adjacencyList.add(new ArrayList<Integer>());
        }
    }

    public void insertEdge(int i, int j, int weight){
        this.adjacencyList.get(i).add(j);
    }

    public void printGraph(){
        for(int i=0; i<this.vertices; i++){
            for(int j=0; j<this.adjacencyList.get(i).size(); j++){
                System.out.print(this.adjacencyList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        AdjacencyList a = new AdjacencyList(5);
        a.insertEdge(1,2,5);
        a.insertEdge(2,3,5);
        a.insertEdge(2,4,5);
        a.insertEdge(3,4,8);
        a.printGraph();

    }
}
