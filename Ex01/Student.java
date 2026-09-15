public class Student {
    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore) {
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public void display() {
        System.out.println(
                "Tên: " + name +
                        " | Tuổi: " + age +
                        " | Điểm TB: " + averageScore
        );
    }
}
