package Ex10;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Tạo Map lưu giá trị và ký hiệu La Mã
        Map<Integer, String> romanMap = new LinkedHashMap<>();

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        // Nhập số
        System.out.print("Nhập số nguyên dương N (1 - 3999): ");
        int n = Integer.parseInt(scanner.nextLine());

        // Kiểm tra dữ liệu
        if (n < 1 || n > 3999) {
            System.out.println("Số không hợp lệ!");
            return;
        }

        // StringBuilder dùng để tạo chuỗi La Mã
        StringBuilder result = new StringBuilder();

        // Duyệt Map từ lớn đến nhỏ
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {

            int value = entry.getKey();
            String symbol = entry.getValue();

            // Nếu N lớn hơn hoặc bằng giá trị hiện tại
            while (n >= value) {

                // Trừ giá trị
                n = n - value;

                // Thêm ký hiệu La Mã
                result.append(symbol);
            }
        }

        System.out.println("Số La Mã: " + result);
    }
}
