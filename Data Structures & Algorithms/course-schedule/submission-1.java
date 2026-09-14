class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] isVisited = new boolean[numCourses];
        Set<Integer> path = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i] && isCycle(prerequisites, i, path, isVisited, numCourses)) {
                return false;
            }
        }
        return true;
    }
    private boolean isCycle(int[][] prerequisites, int node, Set<Integer> path, boolean[] isVisited, int numCourses) {
        isVisited[node] = true;
        path.add(node);
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            if (u == node) {
                if (!isVisited[v]) {
                    if (isCycle(prerequisites, v, path, isVisited, numCourses)) {
                        return true;
                    }
                } else if (path.contains(v)) {
                    return true;
                }
            }
        }
        path.remove(node);
        return false;
    }
}
