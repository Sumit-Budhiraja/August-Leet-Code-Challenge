class MyHashSet {
    int num[];
    public MyHashSet() {
        num = new int[31251];
    }
    public void add(int key) {
        int idx = key/32;
        int bit = key%32;
        int mask = (1<<bit);
        num[idx]|=mask;
    }
    public void remove(int key) {
        int idx = key/32;
        int bit = key%32;
        int mask = (1<<bit);
        num[idx] = (num[idx]&(~mask));
    }
    public boolean contains(int key) {
        int idx = key/32;
        int bit = key%32;
        int mask = (1<<bit);
        return (num[idx]&mask)!=0;
    }
}