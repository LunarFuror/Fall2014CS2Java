
import java.io.*;

public class Ch11_PrExercise3
{
    public static void main(String[] args) throws IOException,
                                             FileNotFoundException
    {
        WeightedGraph shortestPathGraph = new WeightedGraph(50);

        shortestPathGraph.createWeightedGraph();

        shortestPathGraph.shortestPath(0);

        shortestPathGraph.printShortestDistance(0);

        System.out.println();

    }
}

