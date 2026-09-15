package Ex08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex08 {

    // Set dùng để lưu sách
    static Set<Book> books = new HashSet<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== QUẢN LÝ BỘ SƯU TẬP SÁCH =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Lọc sách theo năm xuất bản");
            System.out.println("4. Lọc và sắp xếp sách theo tên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addBook();
                        break;

                    case 2:
                        displayBooks(books);
                        break;

                    case 3:
                        filterBooks();
                        break;

                    case 4:
                        filterAndSortBooks();
                        break;

                    case 0:
                        System.out.println("Đã thoát chương trình!");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }

    // Thêm sách
    static void addBook() {

        System.out.println("\n--- THÊM SÁCH ---");

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        System.out.print("Nhập tên sách: ");
        String title = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        String author = scanner.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int year = Integer.parseInt(scanner.nextLine());

        Book book = new Book(id, title, author, year);

        // Set sẽ kiểm tra trùng ID thông qua equals() và hashCode()
        if (books.add(book)) {
            System.out.println("Thêm sách thành công!");
        } else {
            System.out.println("ID sách đã tồn tại!");
        }
    }

    // Hiển thị sách
    static void displayBooks(Set<Book> books) {

        if (books.isEmpty()) {
            System.out.println("Chưa có sách nào!");
            return;
        }

        System.out.println("\n--- DANH SÁCH SÁCH ---");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Lọc sách theo năm
    static List<Book> filterBooks() {

        System.out.print("Nhập năm: ");
        int year = Integer.parseInt(scanner.nextLine());

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }

        System.out.println("\n--- SÁCH XUẤT BẢN SAU NĂM " + year + " ---");

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sách!");
        } else {
            for (Book book : result) {
                System.out.println(book);
            }
        }

        return result;
    }

    // Lọc và sắp xếp theo tên
    static void filterAndSortBooks() {

        System.out.print("Nhập năm: ");
        int year = Integer.parseInt(scanner.nextLine());

        // Bước 1: tạo List
        List<Book> result = new ArrayList<>();

        // Bước 2: lọc sách
        for (Book book : books) {
            if (book.getYear() > year) {
                result.add(book);
            }
        }

        // Bước 3: sắp xếp theo tên sách
        Collections.sort(result, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        // Bước 4: in kết quả
        System.out.println(
                "\n--- SÁCH XUẤT BẢN SAU NĂM "
                        + year
                        + " VÀ ĐƯỢC SẮP XẾP THEO TÊN ---"
        );

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy sách!");
        } else {
            for (Book book : result) {
                System.out.println(book);
            }
        }
    }
}
