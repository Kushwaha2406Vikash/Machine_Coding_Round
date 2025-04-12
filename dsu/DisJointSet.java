package data_structure.dsu;

public class DisJointSet {


    int rank[];
    int parent[];
    int components;
    int size[];


    public  DisJointSet(int nodes){
        this.rank=new int[nodes];
        this.parent=new int[nodes];
        this.components=nodes;
        this.size=new int[nodes];

        for(int i=0;i<nodes;i++){
            this.rank[i]=0;
            this.parent[i]=i;
            this.size[i]=1;
        }

    }

    public int findByrootParent(int node){

        if(node == parent[node]){
            return node;

        }

        parent[node] = findByrootParent(parent[node]);
        return parent[node];
    }

    public void findByUnionRank(int node1,int node2){

        int rootparent1 = findByrootParent(node1);
        int rootparent2 = findByrootParent(node2);

        if(rootparent1==rootparent2){
            return;
        }
        components--;

        if(rank[rootparent1]<rank[rootparent2]){
            parent[rootparent1]=rootparent2;
        }else if(rank[rootparent2]<rank[rootparent1]){
            parent[rootparent2]=rootparent1;
        }else{
            parent[rootparent2]=rootparent1;
            rank[rootparent1]++;
        }
    }

    public void findByUnionSize(int node1,int node2){

        int rootparent1 = findByrootParent(node1);
        int rootparent2 = findByrootParent(node2);

        if(rootparent1==rootparent2){
            return;
        }
        components--;

        if(rank[rootparent1]<rank[rootparent2]){
            parent[rootparent1]=rootparent2;
            size[rootparent2]+=size[rootparent1];
        }else {
            parent[rootparent2]=rootparent1;
            size[rootparent1]+=size[rootparent2];
        }



    }



    public static void main(String[] args) {
        // union by rank
      /*  DisJointSet dsu1 = new DisJointSet(4);
        System.out.println("total components -> " + dsu1.components);
        System.out.println(dsu1.findByrootParent(0) == dsu1.findByrootParent(3));
        dsu1.findByUnionRank(0,3);
        System.out.println("total components -> " + dsu1.components);
        System.out.println(dsu1.findByrootParent(0) == dsu1.findByrootParent(3));
       */

        // Union By Size

        DisJointSet dsu = new DisJointSet(4);
        System.out.println("total components -> " + dsu.components);
        System.out.println(dsu.findByrootParent(0) == dsu.findByrootParent(3));
        dsu.findByUnionSize(0,3);
        System.out.println("total components -> " + dsu.components);
        System.out.println(dsu.findByrootParent(0) == dsu.findByrootParent(3));
        System.out.println(dsu.findByrootParent(0) == dsu.findByrootParent(2));
        dsu.findByUnionSize(0,2);
        System.out.println("total components -> " + dsu.components);
        System.out.println(dsu.findByrootParent(0) == dsu.findByrootParent(2));

    }
}
