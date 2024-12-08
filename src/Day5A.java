import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5A {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Initialize the scanner to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of edges:");
        int n = scanner.nextInt(); // Number of edges

        // Step 2: Build graph and in-degree map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        File file = new File("C:\\Users\\kanna\\Desktop\\GitHub\\advent-of-code-2024\\src\\input\\Day5");
        Scanner text = new Scanner(file);

        // Read the edges from user input
        System.out.println("Enter the edges (u v) where u -> v:");
        while(text.hasNextLine()) {
            String input = text.nextLine();
            String[] parts = input.split("\\|");
            System.out.println(Arrays.toString(parts));
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
            inDegree.putIfAbsent(u, 0);  // Ensure nodes with no incoming edges have in-degree 0
        }

        // Step 3: Perform Kahn's algorithm (BFS)
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topologicalOrder = new ArrayList<>();

        // Enqueue nodes with in-degree 0
        for (int node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        // Process the nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);

            // Decrease in-degree of neighbors and add them to queue if in-degree becomes 0
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Check if a cycle exists (if the order doesn't contain all nodes)
        if (topologicalOrder.size() == inDegree.size()) {
            System.out.println("Topological Sorting: " + topologicalOrder);
        } else {
            System.out.println("The graph has a cycle.");
        }

        // Close the scanner
        scanner.close();
    }
}
