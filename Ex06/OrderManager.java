package Ex06;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {

    private ArrayList<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    @Override
    public void add(Order item) {
        orders.add(item);
    }

    @Override
    public void update(int index, Order item) {
        orders.set(index, item);
    }

    @Override
    public void delete(int index) {
        orders.remove(index);
    }

    @Override
    public void display() {

        if (orders.isEmpty()) {
            System.out.println("Danh sách đơn hàng đang trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH ĐƠN HÀNG =====");

        for (int i = 0; i < orders.size(); i++) {
            System.out.print((i + 1) + ". ");
            orders.get(i).display();
        }
    }

    public int size() {
        return orders.size();
    }

    // Tìm vị trí đơn hàng theo mã
    public int findByCode(String orderCode) {

        for (int i = 0; i < orders.size(); i++) {

            if (orders.get(i)
                    .getOrderCode()
                    .equals(orderCode)) {

                return i;
            }
        }

        return -1;
    }
}