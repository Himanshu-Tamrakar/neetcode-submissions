class DynamicArray {
    private int size;
    private int capacity;
    private int[] arr;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) resize();
        arr[size++] = n;
    }

    public int popback() {
        return arr[--size];
    }

    private void resize() {
        capacity = 2 * capacity;
        int[] temp = new int[capacity];
        for (int i = 0; i < size; i++)  {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
