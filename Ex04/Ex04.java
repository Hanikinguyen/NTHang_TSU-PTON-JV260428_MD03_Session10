package Ex04;

import java.util.Scanner;

public class Ex04 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AttendanceManager manager = new AttendanceManager();

        while (true) {

            try {
                System.out.println("\n===== QUẢN LÝ ĐIỂM DANH =====");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Sửa sinh viên");
                System.out.println("3. Xóa sinh viên");
                System.out.println("4. Hiển thị danh sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Nhập tên sinh viên: ");
                        String name = scanner.nextLine();

                        Student student = new Student(name);

                        manager.add(student);

                        System.out.println(
                                "Thêm sinh viên thành công!"
                        );
                        break;

                    case 2:
                        manager.display();

                        System.out.print(
                                "Nhập vị trí sinh viên cần sửa: "
                        );

                        int updateIndex =
                                Integer.parseInt(scanner.nextLine());

                        updateIndex--;

                        if (updateIndex < 0 ||
                                updateIndex >= manager.size()) {

                            System.out.println(
                                    "Vị trí không hợp lệ!"
                            );
                            break;
                        }

                        System.out.print(
                                "Nhập tên mới: "
                        );

                        String newName = scanner.nextLine();

                        Student newStudent =
                                new Student(newName);

                        manager.update(
                                updateIndex,
                                newStudent
                        );

                        System.out.println(
                                "Sửa sinh viên thành công!"
                        );
                        break;

                    case 3:
                        manager.display();

                        System.out.print(
                                "Nhập vị trí sinh viên cần xóa: "
                        );

                        int deleteIndex =
                                Integer.parseInt(scanner.nextLine());

                        deleteIndex--;

                        if (deleteIndex < 0 ||
                                deleteIndex >= manager.size()) {

                            System.out.println(
                                    "Vị trí không hợp lệ!"
                            );
                            break;
                        }

                        manager.delete(deleteIndex);

                        System.out.println(
                                "Xóa sinh viên thành công!"
                        );
                        break;

                    case 4:
                        manager.display();
                        break;

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
                        "Lỗi: Vui lòng nhập số!"
                );
            }
        }
    }
}
