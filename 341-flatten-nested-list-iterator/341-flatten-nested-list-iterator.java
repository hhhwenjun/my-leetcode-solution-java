/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    
    int curr;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        curr = 0;
        list = new ArrayList<>();
        flattenList(nestedList);
    }
    
    // recursively unpacks a nest list in dfs
    private void flattenList(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger : nestedList){
            if (nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            } else {
                flattenList(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */