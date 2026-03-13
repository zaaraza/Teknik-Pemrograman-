public class GenericsType<T> {
    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        GenericsType<String> type = new GenericsType<>();
        type.set("Java"); // valid
        GenericsType type1 = new GenericsType(); // raw type (tanpa tipe spesifik)
        type1.set("Java"); // valid
        type1.set(10); // juga valid, autoboxing int → Integer

        // print untuk melihat hasilnya
        System.out.println("Nilai type1 setelah set Java: " + type1.get());
        System.out.println("Nilai type1 setelah set 10: " + type1.get());
        System.out.println("Nilai type (String generic): " + type.get());
    }
}