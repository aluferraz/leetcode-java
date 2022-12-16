import leetcode.editor.en.Q1192.CriticalConnectionsInANetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        //[[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]

        //[[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]

//        connections.add(Arrays.asList(1, 0));
//        connections.add(Arrays.asList(2, 0));
//        connections.add(Arrays.asList(3, 2));
//        connections.add(Arrays.asList(4, 2));
//        connections.add(Arrays.asList(4, 3));
//        connections.add(Arrays.asList(3, 0));
//        connections.add(Arrays.asList(4, 0));



        System.out.println(new CriticalConnectionsInANetwork().criticalConnections(5, connections));
    }

}



