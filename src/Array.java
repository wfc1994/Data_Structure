public class Array {
    private int[] arr;
    private  int size;

    public Array(){
        this(10);
    }

    public Array(int capacity){
        arr = new int[capacity];
        size = 0;
    }

    //获得数组中的元素个数
    public int getSize(){
        return size;
    }
    //获取数组容量
    public int getCapacity(){
        return arr.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在第index个位置上插入一个新元素e
    public void add(int index,int e){
        if(size == arr.length)
            throw new IllegalArgumentException("数组已满，无法插入");

        if(index < 0 || index > size)
            throw new IllegalArgumentException("插入位置有误");

        for(int i=size-1;i>=index;i--){
            arr[i+1] = arr[i];
        }
        arr[index] = e;
        size++;
    }

    public void addFirst(int e){
        this.add(0,e);
    }

    public void addLast(int e){
        this.add(size,e);
    }

    int get(int index){
        if(index<0 ||index>=size){
            throw new IllegalArgumentException("无法取得数据");
        }
        return arr[index];
    }

    void set(int index,int e){
        if(index<0 ||index>=size){
            throw new IllegalArgumentException("无法设置数据");
        }
        arr[index] = e;
    }

    public boolean contains(int e){
        for(int i=0;i<size;i++){
            if(arr[i]==e){
                return true;
            }
        }
        return false;
    }

    public int find(int e){
        for(int i=0;i<size;i++){
            if(arr[i]==e){
                return i;
            }
        }
        return -1;
    }

    public int remove(int index){
        if(index<0 ||index>=size){
            throw new IllegalArgumentException("无法删除数据");
        }
        int ret = arr[index];
        for(int i=index+1;i<size;i++){
            arr[i-1] = arr[i];
        }
        size--;
        return ret;
    }

    public int removeFirst(){
        return remove(0);
    }
    public int removeLast(){
        return remove(size-1);
    }
    public void removeElement(int e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("数组的大小是：%d，容量是：%d\n",size,arr.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(arr[i]);
            if(i != size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Array array = new Array(20);
        array.add(0,2);
        array.add(1,5);
        System.out.println(array.toString());
        array.addFirst(-1);
        System.out.println(array);
        array.addLast(-2);
        System.out.println(array);
        array.removeElement(2);
        System.out.println(array);

    }

}
