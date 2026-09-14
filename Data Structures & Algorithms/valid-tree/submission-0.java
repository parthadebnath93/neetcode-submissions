class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        this.parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int []edge:edges){
            int parentA=find(edge[0]);
            int parentB=find(edge[1]);
            if(parentA==parentB){
                return false;
            }
            parent[parentA]=parentB;
            n--;
        }
        return n==1;
    }
    private int find(int x){
        if(parent[x] != x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
}
