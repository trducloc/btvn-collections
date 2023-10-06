package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker extends Person {
    private int workingDays;

    private int craftsman;

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "craftsman='" + craftsman + '\'' +
                '}';
    }
    public void inputInfo(){
        super.inputInfo();
        boolean validInput = false;
        do {
            try {
                System.out.print("Nhập bậc thợ (từ 1 đến 7): ");
                craftsman = new Scanner(System.in).nextInt();
                if (craftsman >= 1 && craftsman <= 7) {
                    validInput = true;
                } else {
                    System.out.println("Bậc thợ không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi khi nhập bậc thợ. Vui lòng nhập lại.");
                craftsman = new Scanner(System.in).nextInt();
            }
        } while (!validInput);

    }
}
