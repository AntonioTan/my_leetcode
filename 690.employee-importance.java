/*
 * @lc app=leetcode id=690 lang=java
 *
 * [690] Employee Importance
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> employeeMap = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0; i<employees.size(); i++) {
            Employee employee = employees.get(i);
            employeeMap.put(employee.id, employee);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        seen.add(id);
        queue.add(id);
        int importance = 0;
        while(!queue.isEmpty()) {
            int next = queue.pollFirst();
            importance += employeeMap.get(next).importance;
            Employee employee = employeeMap.get(next);
            for(int subordinate: employee.subordinates) {
                if(seen.add(subordinate)) {
                    queue.add(subordinate);
                }
            } 
        }
        return importance;
    }
}
// @lc code=end

