package logic;

import entity.Factory;
import entity.Worker;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FactoryLogic {
    private List<Factory> factories;
    private int totalFactory;
    private FactoryLogic factoryLogic;

    public FactoryLogic(List<Factory> factories) {
    }


    public List<Factory> getFactories() {
        return factories;
    }
    public void inputFactory() {
        int factoryNumber;

        System.out.print("Có bao nhiêu xưởng sản xuất muốn thêm mới: ");
        do {
            try{
                factoryNumber = new Scanner(System.in).nextInt();
                if (factoryNumber > 0) {
                    break;
                }
                System.out.println("Số lượng xưởng sản xuất phải là một số nguyên dương, vui lòng nhập lại: ");
            }catch(InputMismatchException e){
                System.out.println("Số lượng xưởng sản xuất phải là một số nguyên dương, vui lòng nhập lại: ");
            }
        } while(true);
        for (int i = 0; i < factoryNumber; i++) {
            System.out.println("Nhập thông tin cho xưởng thứ : " + (i + 1));
            Factory factory = new Factory();
            factory.inputInfo();
            saveFactory(factory);
        }
        totalFactory += factoryNumber;
    }

    private void saveFactory(Factory factory) {
        factories.add(factory);
    }
    public void showFactory(){
        System.out.println(factories);
    }
    public boolean isEmptyFactory(){
        return factories.isEmpty();
    }
    public Factory searchById(int factoryId) {
        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getId() == factoryId) {
                return factories.get(i);
            }
        }
        return null;
    }
}
