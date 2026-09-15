import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Tạo danh sách sinh viên
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Hiển thị danh sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 0) {
                    System.out.println("Chương trình kết thúc!");
                    break;
                }

                switch (choice) {

                    case 1:
                        System.out.print("Nhập tên sinh viên: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhập tuổi: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        System.out.print("Nhập điểm trung bình: ");
                        double averageScore =
                                Double.parseDouble(scanner.nextLine());

                        Student student =
                                new Student(name, age, averageScore);

                        students.add(student);

                        System.out.println("Thêm sinh viên thành công!");
                        break;

                    case 2:
                        if (students.isEmpty()) {
                            System.out.println("Danh sách sinh viên đang trống!");
                        } else {
                            System.out.println("\n===== DANH SÁCH SINH VIÊN =====");

                            for (Student s : students) {
                                s.display();
                            }
                        }
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Lỗi: Vui lòng nhập đúng kiểu dữ liệu!"
                );
            }
        }

        scanner.close();
    }
}