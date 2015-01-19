

import java.io.*;
import java.util.*;
import java.text.*;

class WeightedGraph extends Graph
{
    protected double[][] weights;        //weight matrix
    protected double[] smallestWeight;   //smallest weight from
                                            //source to vertices

         //default constructor
    public WeightedGraph()
    {
        super();
        weights = new double[maxSize][maxSize];
        smallestWeight = new double[maxSize];
    }
    
       //constructor with a parameter
    public WeightedGraph(int size)
    {
        super(size);

        weights = new double[maxSize][maxSize];
        smallestWeight = new double[maxSize];
    } 
    
    public void createWeightedGraph() throws IOException, FileNotFoundException
    {
       BufferedReader keyboard = new
             BufferedReader(new InputStreamReader(System.in));
    
       String fileName;
       StringTokenizer tokenizer;
    
       int index;
       int vertex;
       int adjacentVertex;
    
       if(gSize != 0)   //if the graph is not empty, make it empty
          clearGraph();
     
       System.out.print("Enter input file name: ");
       fileName = keyboard.readLine();
       System.out.println();
       
       BufferedReader infile =
                  new BufferedReader(new FileReader(fileName));

    
       gSize = Integer.parseInt(infile.readLine()); //get the number 
                                                    //of vertice

       for(index = 0; index < gSize; index++)
       {
          tokenizer = new StringTokenizer(infile.readLine());
          vertex = Integer.parseInt(tokenizer.nextToken());
          adjacentVertex = Integer.parseInt(tokenizer.nextToken());
    
          while(adjacentVertex != -999)
          {
              graph[vertex].insertLast(new IntElement(adjacentVertex));
              adjacentVertex = Integer.parseInt(tokenizer.nextToken());
          } //end while
       } // end for

        for(int i = 0; i < gSize; i++)
            for(int j = 0; j < gSize; j++)
                weights[i][j] = infinity;

        double weight;
        
        String inputLine;

        inputLine = infile.readLine();
        
        while(inputLine != null)
        {
            tokenizer = new StringTokenizer(inputLine);
            vertex = Integer.parseInt(tokenizer.nextToken());
            adjacentVertex = Integer.parseInt(tokenizer.nextToken());

            while(adjacentVertex != -999)
            {
                weight = Integer.parseInt(tokenizer.nextToken());
                weights[vertex][adjacentVertex] = weight;
                adjacentVertex = Integer.parseInt(tokenizer.nextToken());
            }

            inputLine = infile.readLine();
        }
    } //createWeightedGraph


        //The function to determine the smallest weight from,
        //vertex, that is, the source to every other vertex
        //in the graph.
    public void shortestPath(int vertex)
    {
        int i,j;
        int v = 0;
        double minWeight;

        for(j = 0; j < gSize; j++)
            smallestWeight[j] = weights[vertex][j];

        boolean[] weightFound = new boolean[maxSize];

        for(j = 0; j < gSize; j++)
            weightFound[j] = false;

        weightFound[vertex] = true;
        smallestWeight[vertex] = 0;

        for(i = 0; i < gSize - 1; i++)
        {
            minWeight = infinity;

            for(j = 0; j < gSize; j++)
                if(!weightFound[j])
                    if(smallestWeight[j] < minWeight)
                    {
                        v = j;
                        minWeight = smallestWeight[v];
                    }

            weightFound[v] = true;

            for(j = 0; j < gSize; j++)
                if(!weightFound[j])
                   if(minWeight + weights[v][j] < smallestWeight[j])
                        smallestWeight[j] = minWeight + weights[v][j];
          } //end for
    } //end shortestPath


        //Method to print the shortest weight from the
        //source to the other vertices in the graph.
    public void printShortestDistance(int vertex)
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");

        System.out.println("Source Vertex: " + vertex);
        System.out.println("Shortest Distance from Source " 
                             + "to each Vertex");
        System.out.println("Vertex  Shortest_Distance");

        for(int j = 0; j < gSize; j++)
            System.out.println("   " + j + " \t\t" 
                          + twoDigits.format(smallestWeight[j]));
        System.out.println();
    }
}


