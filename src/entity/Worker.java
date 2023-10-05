package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker extends Person {

    private int craftsman;

    @Override
    public String toString() {
        return "Worker{" +
                "craftsman='" + craftsman + '\'' +
                '}';
    }
    public void inputInfo(){
        System.out.print("Nhập bậc thợ: ");
        int craftsman = new Scanner(System.in).nextInt();
        do{
            try {
                if (craftsman >= 1 && craftsman <= 7) {
                    break;
                }
                System.out.println("Bậc thợ là một số nguyên từ 1 đến 7 , chọn lại: ");
            }catch (InputMismatchException e){
                System.out.println("Bậc thợ là một số nguyên từ 1 đến 7, chọn lại: ");
            }
        }while(true);
    }
}
