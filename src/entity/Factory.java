package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Factory implements InputTable {
    private static int AUTO_ID = 100;
    private int id;
    private String name;
    private String describe;
    private float coefficient;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }

    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên xưởng: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Mô tả xưởng: ");
        this.setDescribe(new Scanner(System.in).nextLine());
        System.out.print("Nhập hệ số công việc: ");
        float coefficient = new Scanner(System.in).nextFloat();
        do{
            try {
                if (coefficient >= 1 && coefficient <= 20) {
                    break;
                }
                System.out.println("Hệ số công việc là một số thực từ trong khoảng từ 1 đến 20, chọn lại: ");
            }catch (InputMismatchException e){
                System.out.println("Hệ số công việc là một số thực từ trong khoảng từ 1 đến 20, chọn lại: ");
            }
        }while(true);
    }
}
