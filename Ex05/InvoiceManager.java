package Ex05;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice> {

    private ArrayList<Invoice> invoices;

    public InvoiceManager() {
        invoices = new ArrayList<>();
    }

    @Override
    public void add(Invoice item) {
        invoices.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
        invoices.set(index, item);
    }

    @Override
    public void delete(int index) {
        invoices.remove(index);
    }

    @Override
    public void display() {

        if (invoices.isEmpty()) {
            System.out.println("Danh sách hóa đơn đang trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH HÓA ĐƠN =====");

        for (int i = 0; i < invoices.size(); i++) {
            System.out.print((i + 1) + ". ");
            invoices.get(i).display();
        }
    }

    public int size() {
        return invoices.size();
    }
}
