package data_structure.heap;

public class MaxHeap {

    int heap[];
    int size;
    int capacity;

        public MaxHeap(int arr[]){
           // this.capacity=capacity;
            this.size=arr.length;
            //heap=new int[capacity];

           this.heap=arr;
           buildMaxHeap();


        }

        public void increasecapacity(){
            capacity*=2;
            int newheap[]=new int[capacity];

            for(int i=0;i<size;i++){
                newheap[i]=heap[i];
            }
            heap=newheap;
        }


        private int Parent(int index){

            return (index-1)/2;
        }

        private int LeftChild(int index){

            return 2*index+1;
        }

        private int RightChild(int index){
            return 2*index+2;
        }

        private void Swap(int i, int j){

            int temp=heap[i];
            heap[i]=heap[j];
            heap[j]=temp;
        }

        public void insert(int value){

            if(size==capacity){
                throw new IllegalStateException("Heap is Full");
            }

            heap[size]=value;

            int current=size;
            size++;

            while (current>0 && heap[current]>heap[Parent(current)]){
                Swap(current,Parent(current));
                current=Parent(current);
            }

        }

    public void insertWithIncreaseCapacity(int value){

        if(size>=capacity){
            increasecapacity();
        }

        heap[size]=value;

        int current=size;
        size++;

        while (current>0 && heap[current]>heap[Parent(current)]){
            Swap(current,Parent(current));
            current=Parent(current);
        }

    }

    public void extractMaxStore(){

        if(size==0){
            throw new IllegalStateException("Heap is Empty");
        }

        int max = heap[0];
        heap[0]=heap[size-1];
        heap[size-1]=max;
        size--;
        heapfiy(0);
        return;
    }


        public int extractMax(){

            if(size==0){
                throw new IllegalStateException("Heap is Empty");
            }

            int max = heap[0];
            heap[0]=heap[size-1];
            size--;
            heapfiy(0);
            return max;
        }

        private void heapfiy(int index){

            int leftchild = LeftChild(index);
            int rightchild = RightChild(index);
            int largest = index;

            if(leftchild <size && heap[leftchild]>heap[largest]){
                largest=leftchild;
            }
            if(rightchild<size && heap[rightchild]>heap[largest]){
                largest=rightchild;
            }

            if (largest!=index){
                Swap(largest,index);
                heapfiy(largest);
            }
        }

        private void buildMaxHeap(){

            for(int i=(size/2)-1;i>=0;i--){
                heapfiy(i);
            }
        }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void IncreaseKey(int index, int newValue){

            if(index<0 || index>=size || heap[index]>=newValue){
                throw new IllegalStateException("Wrong Operation");
            }

            heap[index]=newValue;


            //(int)(Math.ceil(index/2.0)-1);

            while (index>0 && heap[index]>heap[Parent(index)]){
                Swap(index,Parent(index));
                index=Parent(index);
            }

    }
    public void DecreaseKey(int index, int newValue){

        if(index<0 || index>=size || heap[index]<newValue){
            throw new IllegalStateException("Wrong Operation");
        }

        heap[index]=newValue;

        heapfiy(index);

    }


    public int[] heapsort(){

            buildMaxHeap();
            int heapsize = size;

            for(int i=0;i<heapsize;i++){
                extractMaxStore();
            }

            return heap;
    }



    public static void main(String[] args) {
      //  MaxHeap maxHeap = new MaxHeap(10);
      /*  maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(50);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        System.out.println("Extracted Max: " + maxHeap.extractMax());
        System.out.println("Heap after extraction:");
        maxHeap.printHeap();*/

        int[] arr = {3, 9, 2, 1, 4, 5};

        //int[] arr = {10, 5, 20, 6, 11};
        MaxHeap maxHeap = new MaxHeap(arr);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

    }

}
