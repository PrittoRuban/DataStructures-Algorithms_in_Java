# Learn Data Structures and Algorithms using Java

<div align="left"> 

## What will you learn?
- Basic Data Structures
   - Arrays
   - Linked List
   - Stack
   - Queue
   - Hash Table
- Searching algorithms
   - Linear Search
   - Binary Search
- Sorting algorithms
   - Bubble Sort 
   - Selection Sort
   - Insertion Sort
- Graphs 
   - Adjacency Matrix
   - Adjacency List
   - Depth First Search
   - Breadth Fisrt Search
- Trees
   - Binary Search Tree
   - Tree Traversal
  
</div>


### What is data Structure?
 - Simply, A named location that can be used to store and organize data.
 - Example; 
    - Consider a list of fruits
    - The list fruits is used to store and organize data

### What is Algorithms? 

- An algorithm is a set of step-by-step instructions designed to perform a specific task or solve a particular problem.
- Example;
  - A navigation system, such as Google Maps, uses algorithms to find the shortest or fastest route from one location to another.


### Dynamic Programming and related problems: 

Dynamic Programming (DP) is a powerful algorithmic paradigm used to solve problems by breaking them into smaller, simpler subproblems and solving each subproblem only once, storing its result for future reference. It is particularly useful for optimization problems where we need to find the best or most efficient solution.

The basic idea of dynamic programming is to:
1. **Define the problem in terms of subproblems.**
2. **Recursively solve the subproblems.**
3. **Store the results of subproblems to avoid solving them multiple times.**
4. **Build the solution from previously solved subproblems.**

### Key Concepts of Dynamic Programming:

1. **Optimal Substructure**: The optimal solution of the given problem can be obtained by combining the optimal solutions of its subproblems.
   
2. **Overlapping Subproblems**: The problem can be broken down into subproblems that are reused multiple times.

---

## **1. Dynamic Programming - The Principle of Optimality**

### Problem
The principle of optimality states that an optimal solution to a problem can be constructed by using the optimal solutions to its subproblems. This means that in dynamic programming, we can decompose a problem into smaller subproblems, solve each subproblem optimally, and then combine the solutions to get the optimal solution for the original problem.

**Example**:  
Consider the **Shortest Path Problem** from one point to another on a graph. The shortest path from point A to point B consists of the shortest path from A to some intermediate point C and the shortest path from C to B. This principle allows us to compute the shortest path efficiently.

### Approach
Dynamic programming uses the principle of optimality by recursively solving the problem for all subproblems and then combining their solutions to find the optimal solution.

### Algorithm (General Framework)
1. Define the subproblems clearly, often by formulating a recurrence relation.
2. Solve the subproblems and store their results to avoid recalculating them.
3. Use the stored results to construct the final solution.

#### Example: Fibonacci Numbers
One of the simplest examples to understand dynamic programming is the Fibonacci sequence. The nth Fibonacci number can be defined as:
\[ F(n) = F(n-1) + F(n-2) \]
With base cases:
\[ F(0) = 0, F(1) = 1 \]

The naive recursive solution leads to exponential time complexity due to redundant calculations. Dynamic programming solves this efficiently by storing the results of subproblems.

### Dynamic Programming Approach

1. **Define subproblems**:  
   \( F(n) \) is the nth Fibonacci number, where \( F(n) = F(n-1) + F(n-2) \) and base cases are \( F(0) = 0, F(1) = 1 \).
   
2. **Recurrence relation**:  
   The recursive formula defines how to combine the solutions of subproblems.
   
3. **Store results**:  
   Use an array or table to store previously computed Fibonacci numbers.

4. **Construct final solution**:  
   Use the stored results to compute higher Fibonacci numbers.

### Dry Run
Let’s compute \( F(5) \):

\[
F(5) = F(4) + F(3)
\]
\[
F(4) = F(3) + F(2)
\]
\[
F(3) = F(2) + F(1)
\]
\[
F(2) = F(1) + F(0)
\]

The subproblems are solved in sequence and stored, which allows us to compute \( F(5) \) efficiently.

**Memoization Table (Array)**:

```
F[0] = 0
F[1] = 1
F[2] = F[1] + F[0] = 1
F[3] = F[2] + F[1] = 2
F[4] = F[3] + F[2] = 3
F[5] = F[4] + F[3] = 5
```

The final result for \( F(5) = 5 \).

### Java Code for Fibonacci Using Dynamic Programming
```java
public class FibonacciDP {

    // Dynamic programming to calculate Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Create an array to store results of subproblems
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        // Build the Fibonacci sequence up to F(n)
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // Return the nth Fibonacci number
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Fibonacci number F(" + n + ") = " + fibonacci(n));
    }
}
```

### Time Complexity
- **Time Complexity**: \( O(n) \).  
  Each subproblem (Fibonacci number) is computed exactly once, and the total number of subproblems is \( n \).
  
- **Space Complexity**: \( O(n) \).  
  This is due to the storage required for the memoization table (array of size \( n \)).

---

### Advantages of Dynamic Programming
1. **Efficiency**: Avoids redundant computations by solving each subproblem only once.
2. **Clarity**: Provides a systematic way to solve complex problems.
3. **Reusability**: By storing solutions to subproblems, we can solve larger problems efficiently.

### Disadvantages of Dynamic Programming
1. **Memory Usage**: Dynamic programming often requires extra memory to store intermediate results (e.g., tables or arrays).
2. **Problem Structure**: Not all problems exhibit optimal substructure and overlapping subproblems, making dynamic programming unsuitable for such problems.

---

### Conclusion:
Dynamic programming is a robust technique for solving problems that can be broken down into overlapping subproblems with an optimal substructure. By storing the results of solved subproblems, we can avoid recomputation and solve complex problems efficiently.


### 2. Floyd's Algorithm

Floyd’s Algorithm, also known as the **Floyd-Warshall Algorithm**, is a **dynamic programming** technique used to find the shortest paths between all pairs of vertices in a weighted graph. It is particularly efficient for dense graphs and is capable of detecting negative-weight cycles.

### Problem Statement

Given a directed graph with `n` vertices (or nodes) where each edge has a weight, the task is to find the shortest path between every pair of vertices. The graph can contain negative weights, but it must not contain negative-weight cycles, as these would lead to undefined shortest paths.

### Approach

Floyd's algorithm uses the principle of **dynamic programming** by gradually improving the solution for all pairs of vertices based on whether an intermediate vertex is added to the path or not.

**Key Idea:**
If there is a path from vertex `i` to vertex `j`, and vertex `k` is an intermediate vertex along this path, then the shortest path from `i` to `j` through `k` can be represented as:

The formula is:

dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

Where:
- dist[i][j] is the current distance from vertex `i` to vertex `j`.
- dist[i][k] is the distance from vertex `i` to vertex `k`.
- dist[k][j] is the distance from vertex `k` to vertex `j`.



This formula checks if the shortest path from `i` to `j` is shorter by going through `k` than directly from `i` to `j`.

### Steps of the Algorithm

1. **Initialize the Distance Matrix**:  
   Create a matrix `dist[][]` where each element `dist[i][j]` represents the weight of the direct edge between vertices `i` and `j`. If there is no direct edge between `i` and `j`, set `dist[i][j]` to infinity (`∞`). The diagonal elements (i.e., `dist[i][i]`) are set to 0.

2. **Iterate Over All Vertices**:  
   For each vertex `k` (considering it as an intermediate vertex), update the distance matrix `dist[][]`. For each pair of vertices `(i, j)`, check if the path from `i` to `j` through `k` is shorter than the current path from `i` to `j`.

3. **Update the Distance Matrix**:  
   Use the formula:
   \[
   \text{dist}[i][j] = \min(\text{dist}[i][j], \text{dist}[i][k] + \text{dist}[k][j])
   \]
   Update the distance matrix for all pairs of vertices `i` and `j`.

4. **Handle Negative Cycles**:  
   After running the algorithm, if any diagonal element `dist[i][i]` is negative, it means there is a negative-weight cycle in the graph, as the distance from a vertex to itself should never be negative.

### Floyd-Warshall Algorithm Pseudocode

```text
Input: Graph with vertices V and edge weights W
Output: Matrix dist[][] where dist[i][j] represents the shortest path from vertex i to vertex j

1. Initialize the distance matrix dist[][]
   for i = 0 to V-1:
       for j = 0 to V-1:
           if i == j:
               dist[i][j] = 0   // Distance to itself is 0
           else if edge(i, j) exists:
               dist[i][j] = weight of edge(i, j)
           else:
               dist[i][j] = ∞   // No edge between i and j

2. Use dynamic programming to update the distance matrix
   for k = 0 to V-1:
       for i = 0 to V-1:
           for j = 0 to V-1:
               dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

3. Check for negative-weight cycles
   for i = 0 to V-1:
       if dist[i][i] < 0:
           report "Negative weight cycle detected"
```

---

### Dry Run

Let’s take an example graph with 4 vertices and the following edge weights:

|   | 0  | 1  | 2  | 3  |
|---|----|----|----|----|
| 0 | 0  | 3  | ∞  | 7  |
| 1 | 8  | 0  | 2  | ∞  |
| 2 | 5  | ∞  | 0  | 1  |
| 3 | 2  | ∞  | ∞  | 0  |

1. **Initial Matrix**:

   ```
   dist[0][0] = 0,  dist[0][1] = 3,  dist[0][2] = ∞, dist[0][3] = 7
   dist[1][0] = 8,  dist[1][1] = 0,  dist[1][2] = 2, dist[1][3] = ∞
   dist[2][0] = 5,  dist[2][1] = ∞,  dist[2][2] = 0, dist[2][3] = 1
   dist[3][0] = 2,  dist[3][1] = ∞,  dist[3][2] = ∞, dist[3][3] = 0
   ```

2. **First Iteration** (`k = 0`): Consider paths through vertex 0:

   ```
   dist[0][0] = 0,  dist[0][1] = 3,  dist[0][2] = ∞, dist[0][3] = 7
   dist[1][0] = 8,  dist[1][1] = 0,  dist[1][2] = 2, dist[1][3] = ∞
   dist[2][0] = 5,  dist[2][1] = ∞,  dist[2][2] = 0, dist[2][3] = 1
   dist[3][0] = 2,  dist[3][1] = ∞,  dist[3][2] = ∞, dist[3][3] = 0
   ```

   No changes, as no shorter paths exist through vertex 0.

3. **Second Iteration** (`k = 1`): Consider paths through vertex 1:

   ```
   dist[0][0] = 0,  dist[0][1] = 3,  dist[0][2] = 5, dist[0][3] = 7
   dist[1][0] = 8,  dist[1][1] = 0,  dist[1][2] = 2, dist[1][3] = ∞
   dist[2][0] = 5,  dist[2][1] = ∞,  dist[2][2] = 0, dist[2][3] = 1
   dist[3][0] = 2,  dist[3][1] = ∞,  dist[3][2] = ∞, dist[3][3] = 0
   ```

   We updated `dist[0][2]` to 5 through vertex 1.

4. **Third Iteration** (`k = 2`): Consider paths through vertex 2:

   ```
   dist[0][0] = 0,  dist[0][1] = 3,  dist[0][2] = 5, dist[0][3] = 6
   dist[1][0] = 8,  dist[1][1] = 0,  dist[1][2] = 2, dist[1][3] = 3
   dist[2][0] = 5,  dist[2][1] = ∞,  dist[2][2] = 0, dist[2][3] = 1
   dist[3][0] = 2,  dist[3][1] = ∞,  dist[3][2] = ∞, dist[3][3] = 0
   ```

   We updated `dist[0][3]` to 6 and `dist[1][3]` to 3 through vertex 2.

5. **Fourth Iteration** (`k = 3`): Consider paths through vertex 3:

   ```
   dist[0][0] = 0,  dist[0][1] = 3,  dist[0][2] = 5, dist[0][3] = 6
   dist[1][0] = 5,  dist[1][1] = 0,  dist[1][2] = 2, dist[1][3] = 3
   dist[2][0] = 5,  dist[2][1] = ∞,  dist[2][2] = 0, dist[2][3] = 1
   dist[3][0] = 2,  dist[3][1] = ∞,  dist[3][2] = ∞, dist[3][3] = 0
   ```


### Java Code

```java
import java.util.Arrays;

public class FloydWarshall {
    
    final static int INF = 99999; // A large value to represent infinity (no path)

    // Method to implement Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from i to j, then update dist[i][j]
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Detect negative-weight cycles by checking diagonal elements
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Negative-weight cycle detected!");
                return;
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    // Method to print the shortest distance matrix
    public static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Define a graph represented as an adjacency matrix
        int[][] graph = {
            {0, 3, INF, 7},
            {8, 0, 2, INF},
            {5, INF, 0, 1},
            {2, INF, INF, 0}
        };

        // Execute Floyd-Warshall algorithm
        floydWarshall(graph);
    }
}
```

### Explanation

1. **INF (Infinity)**: A large value `INF` is used to represent the absence of a path between two vertices. In this example, `99999` is used for this purpose.
  
2. **`floydWarshall` method**: The function accepts a graph represented by a 2D array (adjacency matrix). It iterates over all pairs of vertices using three nested loops and checks if including an intermediate vertex results in a shorter path.

3. **Dynamic Programming Update**: The main logic inside the loop updates the distance between vertices `i` and `j` if the path through the intermediate vertex `k` is shorter.

4. **Negative-weight Cycle Detection**: After running the algorithm, the code checks if any diagonal element `dist[i][i]` is negative, which would indicate a negative-weight cycle.

5. **`printSolution` method**: This method prints the shortest path between each pair of vertices. If there's no path between two vertices, it prints "INF".

### Output of the Code

For the given graph:

```
    0  3  INF  7
    8  0  2  INF
    5  INF  0  1
    2  INF  INF  0
```

The output will be:

```
Shortest distances between every pair of vertices:
0   3   5   6   
5   0   2   3   
3   6   0   1   
2   5   7   0   
```

### Time Complexity

The time complexity of the Floyd-Warshall algorithm is **O(V³)**, where `V` is the number of vertices. This is because we have three nested loops each iterating over the vertices.

### Space Complexity

The space complexity is **O(V²)** because we are using a 2D matrix `dist[][]` to store the shortest path between all pairs of vertices.

### Use Cases

- **Network Routing**: Finding the shortest path between all routers in a network.
- **Graph Analysis**: Analyzing and solving shortest path problems in dense graphs.
- **Negative Cycle Detection**: Identifying negative-weight cycles in financial systems or other graphs where such cycles could indicate problematic behavior.


---

# Multi-Stage Graph Problem using Dynamic Programming

A **multi-stage graph** is a directed graph where we need to find the shortest (or longest) path from a starting node (source) to an ending node (sink) that passes through multiple intermediate stages. Each stage contains one or more nodes, and the goal is to optimize the total cost (shortest or longest path).

### Problem Statement

Given a multi-stage graph, find the shortest path from a source node (start) to a sink node (end) while passing through intermediate stages. Each edge has a cost associated with it.

### Graph Representation

A multi-stage graph can be represented as a directed acyclic graph (DAG). Each stage has one or more vertices, and edges represent valid paths between nodes of consecutive stages.

For example:

```
Stage 1    Stage 2    Stage 3    Stage 4
   0  --->   1  --->   4  --->    6
       |         |         |
       V         V         V
       2  --->   3  --->   5
```

### Approach

The key idea is to use **Dynamic Programming**. We start from the sink node and move backward toward the source node, calculating the minimum cost for each node. At each node, we consider all the edges leading to it from the previous stage and find the minimum cost for reaching that node.

### Steps in the Algorithm

1. **Define the graph**: Use an adjacency matrix to store the cost of traveling between nodes.
2. **Create a cost array**: Initialize an array `cost[]` where `cost[i]` holds the minimum cost to reach the sink node from node `i`.
3. **Work backwards**: Starting from the sink, update the cost for each node based on the edges leading to it.
4. **Final cost**: The minimum cost to travel from the source to the sink will be stored in `cost[source]`.

### Algorithm

1. Initialize `cost[sink] = 0` since the cost to reach the sink from the sink itself is 0.
2. For every node in the graph, compute the cost to reach the sink by taking the minimum of `cost[node] = min(cost[node], cost[adjacent_node] + weight_of_edge)`.
3. Start from the sink and work backwards, updating the cost array.

### Dry Run Example

Consider the graph below with costs between nodes:

```
Graph:
    Stage 1    Stage 2    Stage 3    Stage 4
      0  --->   1  --->   4  --->    6
          |         |         |
          V         V         V
          2  --->   3  --->   5

Adjacency Matrix (Costs):
  0 -> 1 : 2,  0 -> 2 : 3
  1 -> 4 : 6,  1 -> 3 : 5
  2 -> 4 : 4,  2 -> 3 : 7
  3 -> 5 : 4
  4 -> 6 : 1,  5 -> 6 : 3
```

- Initial `cost[]` (sink is node 6, so `cost[6] = 0`):

  ```
  cost[] = [∞, ∞, ∞, ∞, ∞, ∞, 0]
  ```

- Start updating costs from stage 3 to stage 1:

  - For node 4: `cost[4] = min(cost[4], cost[6] + 1) = min(∞, 0 + 1) = 1`
  - For node 5: `cost[5] = min(cost[5], cost[6] + 3) = min(∞, 0 + 3) = 3`
  - For node 1: `cost[1] = min(cost[1], cost[4] + 6) = min(∞, 1 + 6) = 7`
  - For node 3: `cost[3] = min(cost[3], cost[5] + 4) = min(∞, 3 + 4) = 7`
  - For node 2: `cost[2] = min(cost[2], cost[4] + 4) = min(∞, 1 + 4) = 5`
  - For node 0: `cost[0] = min(cost[0], cost[1] + 2, cost[2] + 3) = min(∞, 7 + 2, 5 + 3) = 8`

Final `cost[]`:

```
cost[] = [8, 7, 5, 7, 1, 3, 0]
```

Thus, the shortest path from node `0` to node `6` has a total cost of `8`.

### Time Complexity

- **Time Complexity**: The time complexity is **O(V²)**, where `V` is the number of vertices.
- **Space Complexity**: The space complexity is **O(V)** for the `cost[]` array.

### Java Code

```java
import java.util.Arrays;

public class MultiStageGraph {
    final static int INF = 99999; // A large value representing infinity
    
    // Function to find the minimum cost path from source to sink
    public static int findMinCost(int[][] graph, int stages) {
        int V = graph.length;
        int[] cost = new int[V]; // Cost array to store minimum cost to reach the sink
        Arrays.fill(cost, INF);  // Initialize with infinity
        cost[V - 1] = 0;         // The cost to reach the sink from the sink is 0
        
        // Iterate backwards from the second-to-last vertex to the source
        for (int i = V - 2; i >= 0; i--) {
            // Find the minimum cost for reaching the sink from node i
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != INF) {
                    cost[i] = Math.min(cost[i], graph[i][j] + cost[j]);
                }
            }
        }
        
        // The minimum cost to reach the sink from the source
        return cost[0];
    }

    public static void main(String[] args) {
        // Define the graph (Adjacency matrix representation)
        int[][] graph = {
            {INF, 2, 3, INF, INF, INF, INF}, // Stage 1
            {INF, INF, INF, INF, 6, 5, INF}, // Stage 2
            {INF, INF, INF, INF, 4, 7, INF}, // Stage 2
            {INF, INF, INF, INF, INF, INF, 4}, // Stage 3
            {INF, INF, INF, INF, INF, INF, 1}, // Stage 3
            {INF, INF, INF, INF, INF, INF, 3}, // Stage 3
            {INF, INF, INF, INF, INF, INF, INF}  // Sink
        };

        int stages = 4;  // Number of stages in the graph
        int minCost = findMinCost(graph, stages);
        System.out.println("The minimum cost from source to sink is: " + minCost);
    }
}
```

### Output

```
The minimum cost from source to sink is: 8
```

### Summary

- **Multi-Stage Graph**: A graph where nodes are grouped into stages, and the goal is to find the shortest path from source to sink.
- **Approach**: Use dynamic programming to calculate the minimum cost for each node, starting from the sink and working backward to the source.
- **Time Complexity**: **O(V²)** due to iterating over all pairs of vertices.
- **Space Complexity**: **O(V)** for storing the cost array.

---

# Optimal Binary Search Trees (OBST) using Dynamic Programming

In computer science, an **Optimal Binary Search Tree (OBST)** is a binary search tree that minimizes the total cost of searching for a set of keys with given probabilities. The goal is to build a binary search tree where frequently accessed elements are closer to the root, resulting in minimized search costs.

## Problem Statement

Given:
- A set of `n` keys, `K = {k1, k2, ..., kn}`, in sorted order.
- The search probabilities `P = {p1, p2, ..., pn}`, where `pi` is the probability of searching for key `ki`.
- Optional: the probabilities `Q = {q0, q1, ..., qn}` of searching for a value that does not exist in the tree but falls between two keys.

We need to construct a binary search tree such that the expected search cost is minimized.

### Definitions

- **Expected cost**: The weighted sum of the search path lengths.
  - The path length of a key is the depth at which it appears in the tree.
  - The expected search cost is the sum of the products of the probabilities and their respective path lengths.

### Example

Consider a set of 3 keys:
- Keys: `K = {10, 20, 30}`
- Probabilities: `P = {0.3, 0.2, 0.5}`
- Dummy probabilities (for non-existent keys): `Q = {0.2, 0.1, 0.2, 0.3}`

The goal is to construct a binary search tree that minimizes the expected search cost, using the given probabilities.

## Approach

### Dynamic Programming Approach

The dynamic programming approach solves the problem by breaking it down into subproblems, solving each subproblem once, and combining the results to find the optimal solution. 

1. **Cost matrix (`cost[i][j]`)**:
   - `cost[i][j]` stores the minimum cost of the binary search tree built from keys `ki` to `kj`.
2. **Root matrix (`root[i][j]`)**:
   - `root[i][j]` stores the root of the subtree for keys `ki` to `kj` that yields the minimum cost.
3. **Frequency array (`sumP[i][j]`)**:
   - `sumP[i][j]` stores the sum of the search probabilities from `ki` to `kj` plus the probabilities for the gaps (dummy keys).

### Algorithm Steps

1. **Base Case**:
   - For a single key `ki`, the cost of the tree is simply its probability `pi`, as it will be the root.
   - For the dummy keys, the cost is `qi`, since there's no key associated.

2. **Recursive Case**:
   - For every subproblem (i.e., keys `ki` to `kj`), try every key `kr` as the root.
   - The cost of choosing `kr` as the root is:
     - The cost of the left subtree (`cost[i][r-1]`).
     - The cost of the right subtree (`cost[r+1][j]`).
     - The sum of probabilities from `ki` to `kj` (`sumP[i][j]`).

3. **Transition**:
   - Compute the cost for each subproblem by choosing different roots, and store the minimum in `cost[i][j]`.

### Recurrence Formula

- **Cost for the range of keys from `i` to `j`**:
  ```
  cost[i][j] = min(
                cost[i][r-1] + cost[r+1][j] + sumP[i][j]
              )
  where i ≤ r ≤ j
  ```
  The term `sumP[i][j]` is the sum of the probabilities for the range `ki` to `kj`, and `r` is the root for the current subtree.

### Time Complexity

- The time complexity is **O(n³)** since we calculate the cost for each pair of keys and evaluate all possible roots.
- The space complexity is **O(n²)** for storing the cost and root matrices.

## Dry Run Example

Let's work with an example of three keys.

- Keys: `K = {10, 20, 30}`
- Probabilities: `P = {0.3, 0.2, 0.5}`
- Dummy probabilities: `Q = {0.2, 0.1, 0.2, 0.3}`

### Step-by-Step Calculation

1. **Base Case**: 
   - For single keys, the cost is simply their probability:
     ```
     cost[1][1] = p1 = 0.3
     cost[2][2] = p2 = 0.2
     cost[3][3] = p3 = 0.5
     ```

2. **Recursive Case** (Consider trees of 2 keys):
   - For keys `K1` and `K2`:
     - Root is `K1`: 
       ```
       cost[1][2] = cost[1][1] + cost[2][2] + sumP[1][2]
                  = 0.3 + 0.2 + (p1 + p2 + q1 + q2) 
                  = 0.3 + 0.2 + (0.3 + 0.2 + 0.2 + 0.1) 
                  = 1.1
       ```
     - Root is `K2`: 
       ```
       cost[1][2] = cost[1][1] + cost[2][2] + sumP[1][2]
                  = 0.3 + 0.2 + (p1 + p2 + q1 + q2) 
                  = 0.3 + 0.2 + (0.3 + 0.2 + 0.2 + 0.1) 
                  = 1.3
       ```

### Final Result

After calculating the cost for all combinations of keys and choosing the minimum cost roots, we get the optimal binary search tree with the minimal expected search cost.

## Java Code for Optimal Binary Search Tree

```java
public class OptimalBST {
    // Function to calculate the cost of the optimal binary search tree
    public static double optimalBST(double[] p, double[] q, int n) {
        double[][] cost = new double[n + 1][n + 1]; // Cost matrix
        double[][] sumP = new double[n + 1][n + 1]; // Probability sum matrix
        int[][] root = new int[n + 1][n + 1];       // Root matrix
        
        // Initialize cost and sumP for the base case (single keys)
        for (int i = 1; i <= n; i++) {
            cost[i][i] = p[i];
            sumP[i][i] = p[i] + q[i - 1] + q[i];
        }
        
        // Build cost and root tables for subproblems of size 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                cost[i][j] = Double.MAX_VALUE; // Initialize the cost for current subproblem
                sumP[i][j] = sumP[i][j - 1] + p[j] + q[j];
                
                // Try every key in range [i..j] as the root
                for (int r = i; r <= j; r++) {
                    double tempCost = ((r > i) ? cost[i][r - 1] : 0) + 
                                      ((r < j) ? cost[r + 1][j] : 0) + 
                                      sumP[i][j];
                    if (tempCost < cost[i][j]) {
                        cost[i][j] = tempCost;
                        root[i][j] = r;
                    }
                }
            }
        }
        
        // Return the minimum cost of the optimal BST
        return cost[1][n];
    }

    public static void main(String[] args) {
        double[] p = {0, 0.3, 0.2, 0.5}; // Search probabilities for keys
        double[] q = {0.2, 0.1, 0.2, 0.3}; // Dummy probabilities
        int n = 3; // Number of keys
        
        double cost = optimalBST(p, q, n);
        System.out.println("Cost of the Optimal Binary Search Tree: " + cost);
    }
}
```

### Explanation of the Code

1. **Cost Matrix**: `cost[i][j]` holds the minimum cost of searching between keys `i` and `j`.
2. **Root Matrix**: `root[i][j]` stores the root for the subtree that minimizes the cost.
3. **SumP Matrix**: `sumP[i][j]` is the sum of probabilities from `ki` to `kj`.

### Time Complexity

- The time complexity of this solution is **O(n³)** since we have three nested loops to calculate the minimum cost.
- The space complexity is **O(n²)** for storing the cost and root matrices.

---

