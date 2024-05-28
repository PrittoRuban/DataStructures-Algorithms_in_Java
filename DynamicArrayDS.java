public class DynamicArrayDS {
    int size;
    int capacity = 10;
    Object[] array;

    public DynamicArrayDS() {
        array = new Object[capacity];
    }

    public DynamicArrayDS(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object element) {
        if (size >= capacity) {
            grow();
        }
        array[size++] = element;
    }

    public void insert(int index, Object element) {
        if (size >= capacity) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void delete(Object element) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                for(int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                if(size <= (int) capacity / 3) {
                    shrink();
                }
                break;
            }
        } 
    }

    public int search(Object element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        int newCapacity = (int) capacity * 2;
        Object[] newArray = new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
    }

    private void shrink() {
        int newCapacity = (int) capacity / 2;
        Object[] newArray = new Object[newCapacity];

        System.arraycopy(array, 0, newArray, 0, size);
        capacity = newCapacity;
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < capacity; i++) {
            string += array[i] + ", ";
        }
        if (!"".equals(string)) {
            string = "[" + string.substring(0, string.length() - 2) + "]";
        }
        return string;
    }

    public static void main(String[] args) {
        DynamicArrayDS array = new DynamicArrayDS(5);

        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        array.add("E");
        array.add("F");
        array.add("E");
        array.insert(0, "X");
        array.delete("A");
        array.delete("B");
        array.delete("C");
        array.delete("D");


        System.out.println(array.search("C"));
        System.out.println(array);
        System.out.println("Size: " + array.size);
        System.out.println("Capacity: " + array.capacity);
        System.out.println("Empty: " + array.isEmpty());
    }
}
