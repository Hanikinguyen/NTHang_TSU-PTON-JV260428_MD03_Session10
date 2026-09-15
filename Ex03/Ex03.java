import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Tạo danh sách người dùng
        LinkedList<User> users = new LinkedList<>();

        while (true) {

            try {
                System.out.println("\n===== QUẢN LÝ NGƯỜI DÙNG =====");
                System.out.println("1. Thêm người dùng");
                System.out.println("2. Xóa người dùng theo email");
                System.out.println("3. Hiển thị danh sách người dùng");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhập email: ");
                        String email = scanner.nextLine();

                        System.out.print("Nhập số điện thoại: ");
                        String phone = scanner.nextLine();

                        User user = new User(
                                name,
                                email,
                                phone
                        );

                        users.add(user);

                        System.out.println(
                                "Thêm người dùng thành công!"
                        );
                        break;

                    case 2:
                        System.out.print(
                                "Nhập email người dùng cần xóa: "
                        );
                        String emailDelete = scanner.nextLine();

                        boolean found = false;

                        Iterator<User> iterator = users.iterator();

                        while (iterator.hasNext()) {

                            User u = iterator.next();

                            if (u.getEmail().equals(emailDelete)) {
                                iterator.remove();
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            System.out.println(
                                    "Xóa người dùng thành công!"
                            );
                        } else {
                            System.out.println(
                                    "Không tìm thấy người dùng!"
                            );
                        }

                        break;

                    case 3:
                        if (users.isEmpty()) {

                            System.out.println(
                                    "Danh sách người dùng đang trống!"
                            );

                        } else {

                            System.out.println(
                                    "\n===== DANH SÁCH NGƯỜI DÙNG ====="
                            );

                            for (User u : users) {
                                u.display();
                            }
                        }

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
                        "Lỗi: Vui lòng nhập số hợp lệ!"
                );
            }
        }
    }
}