package BFS;

import java.util.*;

/**
 * 690. 员工的重要性
 * @Author Hao Chen
 * @Create 2022/8/18 19:28
 */
public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int res = 0;
        while(!queue.isEmpty()){
            int curId = queue.poll();
            Employee curEmp = map.get(curId);
            res += curEmp.importance;
            for(int subId : curEmp.subordinates){
                queue.offer(subId);
            }
        }
        return res;
    }
}
 class Employee {
     public int id;
     public int importance;
     public List<Integer> subordinates;
 }
