import leetcode.editor.en.Q1192.CriticalConnectionsInANetwork;
import leetcode.editor.en.Q1319.NumberOfOperationsToMakeNetworkConnected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<>(Arrays.asList(1, 3)));

        System.out.println(new CriticalConnectionsInANetwork().criticalConnections(4, connections));
    }

}



