public class Person<T extends Number, U> { // T duoc su dung de giu cho khi ta tao mot doi tuong person, ta se truyen
                                           // kieu du lieu thuc te vao day
    // T chi duoc su dung kieu du lieu cua lop nay: Number
    // T dam bao kieu du lieu chi la so
    private T id;
    private U age;

    public Person(T id, U age) {
        this.id = id;
        this.age = age;
    }

    public T getId() {
        return id;
    }

    public U getAge() {
        return age;
    }

}
