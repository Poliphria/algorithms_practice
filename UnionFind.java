import java.util.Arrays;

class UnionFind { 
    private int[] id;

    public QuickFindUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public union(int a, int b) {
        int temp = 0;
        if(!connected(id[a], id[b])) {
            temp = id[a]; 
            id[a] = id[b];
            id[b] = temp;
        }
    }

    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }
}