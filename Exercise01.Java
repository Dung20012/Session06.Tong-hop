package Lession01;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // C1: Khai báo mảng - Datatype[] arrayName = new Datatype[size]
        float[] scores = new float[100];
        // Khai báo currentIndex là chỉ số nhỏ nhất trong mảng index chưa lưu giá trị
        int currentIndex = 0;

        while (true) {
            System.out.println("***** QUẢN LÝ ĐIỂM SINH VIÊN *****");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số điểm sinh viên cần nhập: ");
                    int countScore = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < countScore; i++) {
                        System.out.println("Nhập điểm sinh viên:");
                        scores[currentIndex] = Float.parseFloat(scanner.nextLine());
                        currentIndex++;
                    }
                    break;
                case 2:
                    // In ra danh sách điểm
                    System.out.println("Giá trị các phần tử trong mảng là:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%.1f\t", scores[i]);
                    }
                    System.out.println();
                    break;
                case 3:
                    // Tính điểm TB sinh viên: sum / currentIndex
                    // sum = 0; duyệt các phần tử và cộng dồn giá trị các phần tử vào sum
                    float sum = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        sum += scores[i];
                    }
                    System.out.println("Điểm trung bình sinh viên: " + sum / currentIndex);
                    break;
                case 4:
                    // Tìm điểm cao nhất và thấp nhất
                    // B1: Coi phần tử đầu tiên là phần tử có giá trị nhỏ nhất min = scores[0]
                    // B2: Duyệt các phần tử từ chỉ số 1 đến cuối
                    // B3: So sánh giá trị min và max với từng phần tử
                    float min = scores[0];
                    float max = scores[0];
                    for (int i = 1; i < currentIndex; i++) {
                        if (min > scores[i]) {
                            min = scores[i];
                        }
                        if (max < scores[i]) {
                            max = scores[i];
                        }
                    }
                    System.out.printf("Giá trị nhỏ nhất: %.1f - Giá trị lớn nhất: %.1f\n", min, max);
                    break;
                case 5:
                    // Đếm số lượng sinh viên đạt (>=5), trượt (<5)
                    int cntStudentFail = 0;
                    int cntStudentPass = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (scores[i] >= 5) {
                            cntStudentPass++;
                        } else {
                            cntStudentFail++;
                        }
                    }
                    System.out.printf("Số lượng sinh viên đạt: %d - Số lượng sinh viên trượt: %d\n", cntStudentPass, cntStudentFail);
                    break;
                case 6:
                    // Sắp xếp tăng dần - Sắp xếp hoán đổi
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (scores[i] > scores[j]) {
                                // Đổi chỗ 2 phần tử i và j
                                float temp = scores[i];
                                scores[i] = scores[j];
                                scores[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong.");
                    break;
                case 7:
                    // Thống kê số lượng sinh viên giỏi và xuất sắc (>=8)
                    int cntGood = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (scores[i] >= 8) {
                            cntGood++;
                        }
                    }
                    System.out.println("Số lượng sinh viên giỏi và xuất sắc là: " + cntGood);
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
