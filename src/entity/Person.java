package entity;

import java.util.Scanner;

public class Person implements InputTable {
    private static int AUTO_ID = 1000;
    protected int id;
    protected String name;
    protected String address;
    protected String phone;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập họ tên: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập SDT: ");
        this.setPhone(new Scanner(System.in).nextLine());
        do {
            if (phone.matches("(\\+84|0)\\d{9,10}")) {
            } else {
                System.out.println("Số điện thoại không hợp lệ, vui lòng nhập lại");
            }
        } while(true);
    }

}
