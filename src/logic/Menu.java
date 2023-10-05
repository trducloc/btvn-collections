package logic;

import entity.Factory;
import entity.TimekeepingManagement;
import entity.Worker;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private FactoryLogic factoryLogic;
    private WorkerLogic workerLogic;
    private TimekeepingManagementLogic timekeepingManagementLogic;

    public Menu() {
        List<Worker> workers = new ArrayList<>();
        workerLogic = new WorkerLogic(workers);
        List<Factory> factories = new ArrayList<>();
        factoryLogic = new FactoryLogic(factories);
        List<TimekeepingManagement> timekeepingManagements = new ArrayList<>();
        timekeepingManagementLogic = new TimekeepingManagementLogic(workerLogic,factoryLogic, timekeepingManagements);

    }

    public void show() {
        while (true) {

            showMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    workerLogic.inputWorker();
                    break;
                case 2:
                    workerLogic.showWorker();
                    break;
                case 3:
                    factoryLogic.inputFactory();
                    break;
                case 4:
                    factoryLogic.showFactory();
                    break;
                case 5:
                    timekeepingManagementLogic.showTable();
                    break;
                case 6:
                    menuSort();
                    break;
                case 7:
//                    billLogic.pay();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void menuSort() {
        System.out.println("_______________Các lựa chọn sắp xếp_______________");
        System.out.println("1. Theo Họ tên công nhân.");
        System.out.println("2. Theo xưởng");
        System.out.println("3. Trở lại menu chính.");
        int x = 0;
        System.out.print("Bạn chọn: ");
        do {
            try {
                x = new Scanner(System.in).nextInt();
                if (x == 1 || x == 2) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            }
        } while(true);
        switch (x) {
            case 1:
                timekeepingManagementLogic.sortByWorkerName();
                break;
            case 2:
                timekeepingManagementLogic.sortByFactory();
                break;
        }
    }

    private static int chooseFunction() {
        System.out.print("Xin mời nhập lựa chọn: ");
        int functionChoice = 0;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                if (functionChoice >= 1 && functionChoice <= 8) {
                    break;
                }
                System.out.print("Chức năng không hợp lệ, vui lòng lựa chọn (từ 1-8): ");
            } catch (InputMismatchException e) {
                System.out.print("Chức năng không hợp lệ, vui lòng lựa chọn (từ 1-8): ");
            }
        } while(true);
        return functionChoice;
    }
    public void showMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Nhập danh sách công nhân mới.");
        System.out.println("2. In ra danh sách công nhân.");
        System.out.println("3. Nhập danh sách xưởng sản xuất.");
        System.out.println("4. In ra danh sách xưởng.");
        System.out.println("5. In danh sách chấm công cho từng công nhân.");
        System.out.println("6. Sắp xếp danh sách Bảng danh sách phân công.");
        System.out.println("7. Lập bảng kê thu nhập cho mỗi công nhân trong tháng.");
        System.out.println("8. Thoát");
    }
}


