import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ban bao nhieu tuoi?");

        try {
            int age = scanner.nextInt();
            System.out.println("Tuoi cua ban la: " + age); // thuong thi exception se xay ra o doan nay

            int error = age / 0;

        } catch (InputMismatchException imt) {
            // TODO: handle exception
            System.out.println("Da co loi! Ban hay nhap so"); // catch khi ma kieu du lieu nhap vao la string
        } catch (ArithmeticException ae) {
            System.out.println("Da co loi! So khong the chia cho 0"); // catch khi so chia cho 0
        } catch (Exception e) {
            System.out.println("Chup tat ca cac Exceptions"); // tat ca cac exception co the xay ra
        } finally {
            System.out.println("Code nay luon luon duoc chay"); // luon luon dc chay
        }
        System.out.println("Ket thuc chuong trinh!");
    }
}