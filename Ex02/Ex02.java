import java.util.HashMap;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Book> books = new HashMap<>();

        while (true) {

            try {
                System.out.println("\n===== QUẢN LÝ SÁCH =====");
                System.out.println("1. Thêm sách");
                System.out.println("2. Tìm kiếm sách");
                System.out.println("3. Hiển thị danh sách sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Nhập tên sách: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhập tác giả: ");
                        String author = scanner.nextLine();

                        System.out.print("Nhập năm xuất bản: ");
                        int publishYear =
                                Integer.parseInt(scanner.nextLine());

                        Book book = new Book(
                                name,
                                author,
                                publishYear
                        );

                        books.put(name, book);

                        System.out.println("Thêm sách thành công!");
                        break;

                    case 2:
                        System.out.print("Nhập tên sách cần tìm: ");
                        String searchName = scanner.nextLine();

                        if (books.containsKey(searchName)) {

                            Book foundBook = books.get(searchName);

                            System.out.println("Tìm thấy sách:");
                            foundBook.display();

                        } else {
                            System.out.println("Không tìm thấy sách!");
                        }

                        break;

                    case 3:
                        if (books.isEmpty()) {

                            System.out.println(
                                    "Danh sách sách đang trống!"
                            );

                        } else {

                            System.out.println(
                                    "\n===== DANH SÁCH SÁCH ====="
                            );

                            for (Book b : books.values()) {
                                b.display();
                            }
                        }

                        break;

                    case 0:
                        System.out.println("Chương trình kết thúc!");
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
