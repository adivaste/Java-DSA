package com.company;

public class Graph{
    private int vertices;
    private int[][] matrix;

    public Graph(int numOfVertices){
        this.vertices = numOfVertices;
        this.matrix = new int[this.vertices][this.vertices];
    }

    public void addEdge(int i, int j, int weight){
        this.matrix[i][j] = weight;
    }

    public void removeEdge(int i, int j){
        this.matrix[i][j] = 0;
    }

    public boolean hasEdge(int i, int j){
        return this.matrix[i][j] == 1;
    }

    public void printGraph(){
        for(int i=0; i<this.vertices; i++){
            for(int j=0; j<this.vertices; j++){
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(5);
        g.addEdge(1,2,5);
        g.addEdge(2,3,6);
        g.addEdge(3,4,7);
        g.addEdge(0,1,7);
        g.printGraph();
    }

}
