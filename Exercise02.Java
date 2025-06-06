package Lession02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullName = "";
        String email = "";
        String phone = "";
        String password = "";
        do {
            System.out.println("***QUẢN LÝ NGƯỜI DÙNG***");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập họ và tên: ");
                    fullName = scanner.nextLine();
                    System.out.println("Nhập vào email: ");
                    email = scanner.nextLine();
                    System.out.println("Nhập vào số điện thoại: ");
                    phone = scanner.nextLine();
                    System.out.println("Nhập vào mật khẩu: ");
                    password = scanner.nextLine();
                    break;
                case 2:
//                    Chuẩn hóa họ và tên
                    String fullNameShort = fullName.trim().replaceAll("\\s+", " ");
//                    Cắt chuỗi thành mảng gồm các phần tử thành các từ
                    String[] arrFullName = fullNameShort.split(" ");
//                    Chuan hóa từng từ
                    StringBuilder stringStandard = new StringBuilder("");
                    for (int i = 0; i < arrFullName.length; i++){
                        stringStandard.append(Character.toUpperCase(arrFullName[i].charAt(0)))
                                .append(arrFullName[i].substring(1).toLowerCase())
                                .append(" ");
                    }
//                    Cộng các phần tử thành chuỗi chuan hóa
                    System.out.println("Chuỗi sau khi chuẩn hóa: " + stringStandard.toString().trim());
                    break;
                case 3:
//                    dung12.a-b@gmail.com
                    String emailRegex = "^[a-zA-Z\\d.-]{3,}@[a-zA-Z\\d{5,}.[a-zA-Z]{2,3}";
                    if (Pattern.matches(emailRegex, email)){
                        System.out.println("Email hợp lệ");
                    }else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;
                case 4:
//                    Số điện thoại hợp lệ: 10 số, số có các đầu số +84, 09, 08, 03 (0|1|2|5|8), 7 số
                    String phoneRegex = "(\\+84|09|08|03)(0|1|2|5|8)\\d{7}";
                    if (Pattern.matches(phoneRegex,phone)){
                        System.out.println("Số điện thoại hợp lệ");
                    }else {
                        System.out.println("Số điện thoại không hợp lệ");
                    }
                    break;
                case 5:
//                    Mật khẩu mạnh: tối thiểu 8 ký tự phải có a-z, A-Z, 0-9, có ky tu đặc biệt
                    String passwordRegex = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!#@%$^&*]{8,}";
                    if (Pattern.matches(passwordRegex, password)){
                        System.out.println("Đây là mật khẩu mạnh, hợp lệ");
                    }else {
                        System.out.println("Đây là mật khẩu yếu, không hợp lệ");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while (true);
    }
}
