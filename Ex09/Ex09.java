package Ex09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex09 {

    // Set lưu danh sách liên lạc
    static Set<Contact> contacts = new HashSet<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== QUẢN LÝ DANH BẠ ĐIỆN THOẠI =====");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. Hiển thị tất cả liên lạc");
            System.out.println("5. Hiển thị danh bạ theo trang");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        addContact();
                        break;

                    case 2:
                        deleteContact();
                        break;

                    case 3:
                        searchContact();
                        break;

                    case 4:
                        displayContacts();
                        break;

                    case 5:
                        displayPagination();
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

    // =========================
    // 1. THÊM LIÊN LẠC
    // =========================
    static void addContact() {

        System.out.println("\n--- THÊM LIÊN LẠC ---");

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber);

        // add() trả về true nếu thêm thành công
        // false nếu phần tử đã tồn tại
        if (contacts.add(contact)) {

            System.out.println("Thêm liên lạc thành công!");
            System.out.println("ID của liên lạc: " + contact.getId());

        } else {

            System.out.println(
                    "Số điện thoại " + phoneNumber
                            + " đã tồn tại!"
            );
        }
    }

    // =========================
    // 2. XÓA LIÊN LẠC
    // =========================
    static void deleteContact() {

        System.out.println("\n--- XÓA LIÊN LẠC ---");

        System.out.print("Nhập số điện thoại cần xóa: ");
        String phoneNumber = scanner.nextLine();

        Contact contactToDelete = findContact(phoneNumber);

        if (contactToDelete != null) {

            contacts.remove(contactToDelete);

            System.out.println("Xóa liên lạc thành công!");

        } else {

            System.out.println("Không tìm thấy số điện thoại!");
        }
    }

    // =========================
    // 3. TÌM KIẾM LIÊN LẠC
    // =========================
    static void searchContact() {

        System.out.println("\n--- TÌM KIẾM LIÊN LẠC ---");

        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = findContact(phoneNumber);

        if (contact != null) {

            System.out.println("Tìm thấy liên lạc:");
            System.out.println(contact);

        } else {

            System.out.println("Không tìm thấy liên lạc!");
        }
    }

    // =========================
    // TÌM CONTACT THEO PHONE
    // =========================
    static Contact findContact(String phoneNumber) {

        for (Contact contact : contacts) {

            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }

        return null;
    }

    // =========================
    // 4. HIỂN THỊ TẤT CẢ
    // =========================
    static void displayContacts() {

        System.out.println("\n--- DANH SÁCH LIÊN LẠC ---");

        if (contacts.isEmpty()) {

            System.out.println("Danh bạ đang trống!");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        System.out.println("Tổng số liên lạc: " + contacts.size());
    }

    // =========================
    // 5. PHÂN TRANG
    // =========================
    static void displayPagination() {

        if (contacts.isEmpty()) {

            System.out.println("Danh bạ đang trống!");
            return;
        }

        // Chuyển Set sang List
        List<Contact> contactList = new ArrayList<>(contacts);

        System.out.print("Nhập số liên lạc mỗi trang: ");
        int pageSize = Integer.parseInt(scanner.nextLine());

        if (pageSize <= 0) {

            System.out.println("Số lượng liên lạc mỗi trang phải > 0!");
            return;
        }

        int totalContacts = contactList.size();

        // Tính tổng số trang
        int totalPages = (int) Math.ceil(
                (double) totalContacts / pageSize
        );

        System.out.println("Tổng số trang: " + totalPages);

        System.out.print("Nhập trang muốn xem: ");
        int page = Integer.parseInt(scanner.nextLine());

        if (page < 1 || page > totalPages) {

            System.out.println("Số trang không hợp lệ!");
            return;
        }

        // Tính vị trí bắt đầu
        int start = (page - 1) * pageSize;

        // Tính vị trí kết thúc
        int end = Math.min(
                start + pageSize,
                totalContacts
        );

        System.out.println(
                "\n--- TRANG "
                        + page
                        + "/"
                        + totalPages
                        + " ---"
        );

        for (int i = start; i < end; i++) {

            System.out.println(contactList.get(i));
        }
    }
}
