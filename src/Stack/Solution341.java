package Stack;

import java.util.*;

/**
 * 341. 扁平化嵌套列表迭代器
 * @Author Hao Chen
 * @Create 2022/7/18 18:53
 */
public class Solution341 {
}
class NestedIterator implements Iterator<Integer> {
    Deque<Iterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            Iterator<NestedInteger> it = stack.peek();
            if(!it.hasNext()){
                stack.pop();
                continue;
            }
            NestedInteger ni = it.next();
            if(ni.isInteger()){
                List<NestedInteger> list = new ArrayList<>();
                list.add(ni);
                stack.push(list.iterator());
                return true;
            }
            stack.push(ni.getList().iterator());
        }
        return false;
    }
}