class Box {
    int value;

    Box(int value) {
        this.value = value;
    }
}

public class CallByReference {
    public static void modifyObject(Box b) {
        b.value = 10; // Changes the object's internal state
    }

    public static void main(String[] args) {
        Box box = new Box(5);
        modifyObject(box);
        System.out.println("Original object's value: " + box.value); // Output: 10
    }
}
