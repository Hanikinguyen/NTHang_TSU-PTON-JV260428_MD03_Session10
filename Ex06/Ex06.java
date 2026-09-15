package Ex06;

import java.util.Scanner;

public class Ex06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        OrderManager manager = new OrderManager();

        while (true) {

            try {
                System.out.println("\n===== QUẢN LÝ ĐƠN HÀNG =====");
                System.out.println("1. Thêm đơn hàng");
                System.out.println("2. Sửa đơn hàng");
                System.out.println("3. Xóa đơn hàng");
                System.out.println("4. Hiển thị danh sách đơn hàng");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    // =========================
                    // THÊM
                    // =========================
                    case 1:
                        System.out.print("Nhập mã đơn hàng: ");
                        String orderCode = scanner.nextLine();

                        // Kiểm tra mã đã tồn tại chưa
                        if (manager.findByCode(orderCode) != -1) {
                            throw new IllegalArgumentException(
                                    "Mã đơn hàng đã tồn tại!"
                            );
                        }

                        System.out.print("Nhập tên khách hàng: ");
                        String customerName = scanner.nextLine();

                        Order order = new Order(
                                orderCode,
                                customerName
                        );

                        manager.add(order);

                        System.out.println(
                                "Thêm đơn hàng thành công!"
                        );
                        break;

                    // =========================
                    // SỬA
                    // =========================
                    case 2:
                        System.out.print(
                                "Nhập mã đơn hàng cần sửa: "
                        );

                        String updateCode = scanner.nextLine();

                        int updateIndex =
                                manager.findByCode(updateCode);

                        if (updateIndex == -1) {
                            throw new IllegalArgumentException(
                                    "Mã đơn hàng không tồn tại!"
                            );
                        }

                        System.out.print(
                                "Nhập mã đơn hàng mới: "
                        );

                        String newOrderCode =
                                scanner.nextLine();

                        System.out.print(
                                "Nhập tên khách hàng mới: "
                        );

                        String newCustomerName =
                                scanner.nextLine();

                        Order newOrder = new Order(
                                newOrderCode,
                                newCustomerName
                        );

                        manager.update(
                                updateIndex,
                                newOrder
                        );

                        System.out.println(
                                "Sửa đơn hàng thành công!"
                        );
                        break;

                    // =========================
                    // XÓA
                    // =========================
                    case 3:
                        System.out.print(
                                "Nhập mã đơn hàng cần xóa: "
                        );

                        String deleteCode =
                                scanner.nextLine();

                        int deleteIndex =
                                manager.findByCode(deleteCode);

                        if (deleteIndex == -1) {
                            throw new IllegalArgumentException(
                                    "Mã đơn hàng không tồn tại!"
                            );
                        }

                        manager.delete(deleteIndex);

                        System.out.println(
                                "Xóa đơn hàng thành công!"
                        );
                        break;

                    // =========================
                    // HIỂN THỊ
                    // =========================
                    case 4:
                        manager.display();
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
                        "Lỗi: Vui lòng nhập số hợp lệ!"
                );

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Lỗi: " + e.getMessage()
                );
            }
        }
    }
}
