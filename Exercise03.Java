package Lession03;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Khai báo danh sách biển số xe và biến currentIndex để quản lý số lượng đã nhập
        String[] numberBus = new String[100];
        int curentIndex = 0;

        do {
            System.out.println("*****QUẢN LÝ BIỂN SỐ XE*****");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Nhập số lượng biển số cần thêm: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < quantity; i++){
                        System.out.println("Nhap số biển thứ " + (i + 1) + ": ");
                        String isNumber = scanner.nextLine().trim();

                        if (isNumber.matches("\\d{2}[A-Z]-\\d{3}\\.\\d{2}")){
                            numberBus[curentIndex] = isNumber;
                            curentIndex++;
                        }else {
                            System.out.println("Biển số không hợp lệ");
                            i--; // Nhập lại
                        }
                    }
                    break;
                case 2:
                    if (curentIndex == 0){
                        System.out.println("Danh sách hiện tại đang trống");
                    }else {
                        System.out.println("Danh sách biển số xe: ");
                        for (int i = 0; i < curentIndex; i++){
                            System.out.println("- " + numberBus[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nhập biển số cần tìm: ");
                    String seaToFind = scanner.nextLine().trim();
                    boolean find = false;
                    for (int i = 0; i < curentIndex; i++){
                        if (numberBus[i].equals(seaToFind)){
                            System.out.println("Tìm thấy biển số xe");
                            find = true;
                            break;
                        }
                    }
                    if (!find){
                        System.out.println("Không tìm thấy biển số xe");
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã tỉnh cần tìm: ");
                    String provinceCode = scanner.nextLine().trim();
                    boolean isYesNumber = false;
                    for (int i = 0; i < curentIndex; i++){
                        if (numberBus[i].startsWith(provinceCode)){
                            System.out.println("- " + numberBus[i]);
                            isYesNumber = true;
                        }
                    }
                    if (!isYesNumber){
                        System.out.println("Không có biển so nào thuộc mã tỉnh bạn tìm " + provinceCode);
                    }
                    break;
                case 5:
//                    Sắp xếp mảng tăng dần
                    for (int i = 0; i < curentIndex -1; i++){
                        for (int j = i + 1; j < curentIndex; j++){
                            if (numberBus[i].compareTo(numberBus[j]) > 0){ // sắp xếp tăng dần các chuỗi
                                String temp = numberBus[i];
                                numberBus[i] = numberBus[j];
                                numberBus[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp biển số tăng dần");
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lua chọn không hợp lệ");
            }
        }while (true);
    }
}
