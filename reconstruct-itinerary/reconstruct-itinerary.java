class Solution {
    // use hashmap to store the adjacency list and remove node if traversed (dfs)
    // sort the adjacency list based on the spell
    private List<String> res = new ArrayList<String>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // use hashmap to store the adjacency list
        Map<String, List<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets){
            String key = ticket.get(0);
            String dest = ticket.get(1);
            if (!flights.containsKey(key)){
                flights.put(key, new ArrayList<String>());
            }
            flights.get(key).add(dest);
        }
        
        // sort the adjacency list
        for (List<String> flight : flights.values()){
            Collections.sort(flight);
        }
        dfs(flights, "JFK");
        
        return res;
    }
    
    public void dfs(Map<String, List<String>> flights, String start){
        if (flights.containsKey(start)){
            // take the adjacency list
            List<String> adjList = flights.get(start);
            
            while (!adjList.isEmpty()){
                String dest = adjList.get(0);
                adjList.remove(0);
                dfs(flights, dest);
            }
        }
        res.add(0, start);
    }
}