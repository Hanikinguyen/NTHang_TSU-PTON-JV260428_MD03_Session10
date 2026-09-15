package Ex05;

import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InvoiceManager manager = new InvoiceManager();

        while (true) {

            try {
                System.out.println("\n===== QUẢN LÝ HÓA ĐƠN =====");
                System.out.println("1. Thêm hóa đơn");
                System.out.println("2. Sửa hóa đơn");
                System.out.println("3. Xóa hóa đơn");
                System.out.println("4. Hiển thị danh sách hóa đơn");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Nhập mã hóa đơn: ");
                        String invoiceCode = scanner.nextLine();

                        System.out.print("Nhập số tiền: ");
                        double amount =
                                Double.parseDouble(scanner.nextLine());

                        if (amount < 0) {
                            throw new IllegalArgumentException(
                                    "Số tiền không được âm!"
                            );
                        }

                        Invoice invoice =
                                new Invoice(invoiceCode, amount);

                        manager.add(invoice);

                        System.out.println(
                                "Thêm hóa đơn thành công!"
                        );
                        break;

                    case 2:
                        manager.display();

                        if (manager.size() == 0) {
                            break;
                        }

                        System.out.print(
                                "Nhập vị trí hóa đơn cần sửa: "
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

                        System.out.print("Nhập mã hóa đơn mới: ");
                        String newCode = scanner.nextLine();

                        System.out.print("Nhập số tiền mới: ");
                        double newAmount =
                                Double.parseDouble(scanner.nextLine());

                        if (newAmount < 0) {
                            throw new IllegalArgumentException(
                                    "Số tiền không được âm!"
                            );
                        }

                        Invoice newInvoice =
                                new Invoice(
                                        newCode,
                                        newAmount
                                );

                        manager.update(
                                updateIndex,
                                newInvoice
                        );

                        System.out.println(
                                "Sửa hóa đơn thành công!"
                        );
                        break;

                    case 3:
                        manager.display();

                        if (manager.size() == 0) {
                            break;
                        }

                        System.out.print(
                                "Nhập vị trí hóa đơn cần xóa: "
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
                                "Xóa hóa đơn thành công!"
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
