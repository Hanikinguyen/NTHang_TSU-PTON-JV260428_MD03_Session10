package Ex07;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            try {
                System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
                System.out.println("1. Nhập danh sách sinh viên");
                System.out.println("2. In danh sách sinh viên");
                System.out.println("3. Tìm kiếm sinh viên theo tên");
                System.out.println("4. Phân loại sinh viên theo GPA");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    // =========================
                    // NHẬP DANH SÁCH
                    // =========================
                    case 1:

                        System.out.print(
                                "Nhập số lượng sinh viên: "
                        );

                        int n = Integer.parseInt(
                                scanner.nextLine()
                        );

                        if (n < 5) {
                            System.out.println(
                                    "Phải nhập ít nhất 5 sinh viên!"
                            );
                            break;
                        }

                        for (int i = 0; i < n; i++) {

                            System.out.println(
                                    "\n--- Sinh viên " + (i + 1) + " ---"
                            );

                            System.out.print("Nhập ID: ");
                            int id = Integer.parseInt(
                                    scanner.nextLine()
                            );

                            System.out.print("Nhập tên: ");
                            String name = scanner.nextLine();

                            System.out.print("Nhập GPA: ");
                            double gpa = Double.parseDouble(
                                    scanner.nextLine()
                            );

                            if (gpa < 0 || gpa > 10) {
                                throw new IllegalArgumentException(
                                        "GPA phải nằm trong khoảng 0 đến 10!"
                                );
                            }

                            Student student =
                                    new Student(id, name, gpa);

                            students.add(student);
                        }

                        System.out.println(
                                "\nNhập danh sách thành công!"
                        );

                        break;

                    // =========================
                    // HIỂN THỊ
                    // =========================
                    case 2:

                        if (students.isEmpty()) {
                            System.out.println(
                                    "Danh sách sinh viên đang trống!"
                            );
                            break;
                        }

                        System.out.println(
                                "\n===== DANH SÁCH SINH VIÊN ====="
                        );

                        for (Student student : students) {
                            System.out.println(student);
                        }

                        break;

                    // =========================
                    // TÌM KIẾM THEO TÊN
                    // =========================
                    case 3:

                        if (students.isEmpty()) {
                            System.out.println(
                                    "Danh sách sinh viên đang trống!"
                            );
                            break;
                        }

                        System.out.print(
                                "Nhập tên sinh viên cần tìm: "
                        );

                        String searchName =
                                scanner.nextLine();

                        boolean found = false;

                        for (Student student : students) {

                            if (student.getName()
                                    .equalsIgnoreCase(searchName)) {

                                System.out.println(
                                        "Tìm thấy sinh viên:"
                                );

                                System.out.println(student);

                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println(
                                    "Không tìm thấy sinh viên!"
                            );
                        }

                        break;

                    // =========================
                    // PHÂN LOẠI
                    // =========================
                    case 4:

                        if (students.isEmpty()) {
                            System.out.println(
                                    "Danh sách sinh viên đang trống!"
                            );
                            break;
                        }

                        System.out.println(
                                "\n===== PHÂN LOẠI SINH VIÊN ====="
                        );

                        for (Student student : students) {

                            double gpa = student.getGpa();

                            String rank;

                            if (gpa >= 8.5) {
                                rank = "Xuất sắc";

                            } else if (gpa >= 7.0) {
                                rank = "Giỏi";

                            } else if (gpa >= 5.5) {
                                rank = "Khá";

                            } else {
                                rank = "Trung bình/Yếu";
                            }

                            System.out.println(
                                    student
                                            + " | Xếp loại: "
                                            + rank
                            );
                        }

                        break;

                    // =========================
                    // THOÁT
                    // =========================
                    case 0:

                        System.out.println(
                                "Chương trình kết thúc!"
                        );

                        scanner.close();
                        return;

                    default:

                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Lỗi: Vui lòng nhập đúng định dạng số!"
                );

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Lỗi: " + e.getMessage()
                );
            }
        }
    }
}
