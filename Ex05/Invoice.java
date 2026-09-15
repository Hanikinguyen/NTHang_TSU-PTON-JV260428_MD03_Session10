package Ex05;

public class Invoice {

    private String invoiceCode;
    private double amount;

    public Invoice(String invoiceCode, double amount) {
        this.invoiceCode = invoiceCode;
        this.amount = amount;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public double getAmount() {
        return amount;
    }

    public void display() {
        System.out.println(
                "Mã hóa đơn: " + invoiceCode
                        + " | Số tiền: " + amount
        );
    }
}
