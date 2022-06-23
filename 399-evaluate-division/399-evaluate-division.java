class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        // step1. build the graph from the equations
        for (int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];
            
            if (!graph.containsKey(dividend)){
                // key: dividend, map: divisor, and result in double
                graph.put(dividend, new HashMap<String, Double>());
            }
            if (!graph.containsKey(divisor)){
                graph.put(divisor, new HashMap<String, Double>());
            }
            // record all the edges in the graph, key is the nodes
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        
        // step2. evaludate each query via DFS + backtracking
        // by verifying if there exists a path from dividend to divisor
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                results[i] = -1.0;
            }
            else if (dividend == divisor){
                results[i] = 1.0;
            }
            else {
                // need to find a path to the target
                HashSet<String> visited = new HashSet<>();
                results[i] = backtrackEvaluate(graph, dividend, divisor, 1, visited);
            }
        }
        return results;
    }
    
    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode,
                                    String targetNode, double accProduct, Set<String> visited){
        // mark the visit
        visited.add(currNode);
        double ret = -1.0;
        
        Map<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode)){
            ret = accProduct * neighbors.get(targetNode);
        }
        else {
            // find the path
            for (Map.Entry<String, Double> pair : neighbors.entrySet()){
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)){
                    continue;
                }
                ret = backtrackEvaluate(graph, nextNode, targetNode, accProduct * pair.getValue(), visited);
                if (ret != -1.0) break;
            }
        }
        // backtracking
        visited.remove(currNode);
        return ret;
    }
}