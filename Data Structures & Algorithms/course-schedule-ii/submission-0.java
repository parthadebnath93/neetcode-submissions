class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] isVisited=new boolean[numCourses];
        Set<Integer> path=new HashSet<>();
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!isVisited[i] && isCycle(prerequisites,i,isVisited,path)){
                return new int[0];
            }
        }
        isVisited=new boolean[numCourses];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!isVisited[i]){
                dfs(prerequisites,i,stack,isVisited);
            }
        }
        int k=0;
        while(!stack.isEmpty()){
            result[k++]=stack.pop();
        }
        return result;
    }
    private boolean isCycle(int[][] prerequisites, int node, boolean[] isVisited, Set<Integer> path){
        isVisited[node]=true;
        path.add(node);
        for(int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][0];
            int u=prerequisites[i][1];
            if(node == u){
                if(!isVisited[v]){
                    if(isCycle(prerequisites, v,isVisited, path)){
                        return true;
                    }
                }else if(path.contains(v)){
                    return true;
                }
            }
        }
        path.remove(node);
        return false;
    }
    private void dfs(int[][] prerequisites, int node, Stack<Integer> path, boolean[]isVisited){
        isVisited[node]=true;
        for(int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][0];
            int u=prerequisites[i][1];
            if(node==u){
                if(!isVisited[v]){
                    dfs(prerequisites,v,path,isVisited);
                }
            }
        }
        path.push(node);
    }
}
