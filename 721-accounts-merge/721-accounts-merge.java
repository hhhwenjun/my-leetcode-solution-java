class Solution {
    // abstract: merge accounts, return emails in sorted order
    // 1. create a union-find class to group the emails
    // 2. sort the emails in a list
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accountNum = accounts.size();
        UnionFind uf = new UnionFind(accountNum);
        
        // map email to the account index
        Map<String, Integer> emails = new HashMap<>();
        
        for (int i = 0; i < accountNum; i++){
            int accountLength = accounts.get(i).size();
            
            for (int j = 1; j < accountLength; j++){
                // take the email from each account
                String email = accounts.get(i).get(j);
                String accountName = accounts.get(i).get(0);
                
                // assign the email to the account index
                if (!emails.containsKey(email)){
                    emails.put(email, i);
                }
                else {
                    // we have already seen this email before, duplicate email means merge person
                    uf.union(i, emails.get(email));
                }
            }
        }
        // store emails corresponding to persons' index
        Map<Integer, List<String>> indexEmails = new HashMap<Integer, List<String>>();
        for (String email : emails.keySet()){
            // the given host id of the email before merge
            int groupid = emails.get(email);
            // check the true group is who (some groups are already merged in uf class)
            int groupTrueid = uf.find(groupid);
            
            if (!indexEmails.containsKey(groupTrueid)){
                indexEmails.put(groupTrueid, new ArrayList<String>());
            }
            indexEmails.get(groupTrueid).add(email);
        }
        // sort the emails and add the account name
        List<List<String>> res = new ArrayList<>();
        for (int group : indexEmails.keySet()){
            List<String> indexEmail = indexEmails.get(group);
            Collections.sort(indexEmail);
            // put the name at the beginning of the list
            indexEmail.add(0, accounts.get(group).get(0));
            res.add(indexEmail);
        }
        return res;
    }
}

class UnionFind {
    int representative[];
    int size[];
    
    public UnionFind(int size){
        representative = new int[size];
        this.size = new int[size];
        
        for (int i = 0; i < size; i++){
            representative[i] = i;
            this.size[i] = 1;
        }
    }
    
    public int find(int x){
        if (x != representative[x]){
            representative[x] = find(representative[x]);
        }
        return representative[x];
    }
    
    public void union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);
        
        if (root1 == root2) return;
        if (size[root1] > size[root2]){
            size[root1] += size[root2];
            representative[root2] = representative[root1];
        }
        else {
            size[root2] += size[root1];
            representative[root1] = representative[root2];
        }
    }
}