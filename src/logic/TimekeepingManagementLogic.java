package logic;

import entity.Factory;
import entity.TimekeepingManagement;
import entity.TimekeepingManagementDetail;
import entity.Worker;

import java.util.*;

public class TimekeepingManagementLogic {
    private final WorkerLogic workerLogic;
    private final FactoryLogic factoryLogic;
    private List<TimekeepingManagement> timekeepingManagements;
    private List<TimekeepingManagementDetail> timekeepingManagementDetails;

    public TimekeepingManagementLogic(WorkerLogic workerLogic, FactoryLogic factoryLogic, List<TimekeepingManagement> timekeepingManagements) {
        this.workerLogic = workerLogic;
        this.factoryLogic = factoryLogic;
        this.timekeepingManagements = timekeepingManagements;
        this.timekeepingManagementDetails = timekeepingManagementDetails;
    }

    public void table() {
        if (!workerLogic.isEmptyWorker()) {
            System.out.println("Chưa có thông tin công nhân, vui lòng nhập trước.");
            return;
        }
        System.out.println("Cần lập bảng chấm công cho bao nhiêu công nhân: ");
        int workerNumber;
        do {
            try {
                workerNumber = new Scanner(System.in).nextInt();
                if (workerNumber > 0 && workerNumber <= workerLogic.getTotalWorker()) {
                    break;
                }
                System.out.println("Số lượng công nhân cần chấm công phải là một số nguyên dương và nhỏ hơn tổng số lượng công nhân của xưởng.");
            }catch(InputMismatchException e){
                System.out.println("Số lượng công nhân cần chấm công phải là một số nguyên dương");
            }
        } while (true);
        for (int i = 0; i < workerNumber; i++) {
            System.out.println("Nhập thông tin cho công nhân thứ: " + (i + 1));
            Worker worker = inputWorkerForList();
            List<TimekeepingManagementDetail> details = inputTimekeepingManagementDetail();
            TimekeepingManagement timekeepingManagement = new TimekeepingManagement(worker, details);
            saveTable(timekeepingManagement);
        }
        showTimekeepingManagement();
    }

    private void showTimekeepingManagement() {
        System.out.println(timekeepingManagements);
    }
    private void saveTable(TimekeepingManagement timekeepingManagement) {
        for (int i = 0; i < timekeepingManagements.size(); i++) {
            if(timekeepingManagements.get(i) == null ){
                timekeepingManagements.set(i, timekeepingManagement);
                break;
            }
        }
    }

    private List<TimekeepingManagementDetail> inputTimekeepingManagementDetail() {
        if (!factoryLogic.isEmptyFactory()) {
            System.out.println("Chưa có thông tin xưởng, vui lòng nhập trước.");
        }
        int Idfactory;
        System.out.println("Công nhân này làm việc tại xưởng có mã bao nhiêu: ");
        do {
            try{
                Idfactory = new Scanner(System.in).nextInt();
                if (Idfactory > 0) {
                    break;
                }
                System.out.println("Mã xưởng là một số nguyên dương có 3 chữ số, vui lòng nhập lại: ");
            }catch(InputMismatchException e){
                System.out.println("Mã xưởng là một số nguyên dương có 3 chữ số, vui lòng nhập lại: ");
            }
        } while(true);

        int workingDaynumber;
        System.out.println("Công nhân này làm việc bao nhingàyêu : ");
        do {
            try{
                workingDaynumber = new Scanner(System.in).nextInt();
                if (workingDaynumber > 0 && workingDaynumber <= 30) {
                    break;
                }
                System.out.println("Số lượng ngày làm việc phải là một số nguyên dương và nhỏ hơn 30, vui lòng nhập lại: ");
            }catch(InputMismatchException e){
                System.out.println("Số lượng ngày làm việc phải là một số nguyên dương và nhỏ hơn 30, vui lòng nhập lại: ");
            }
        } while(true);

        List<TimekeepingManagementDetail> details = new ArrayList<>();
        for (int i = 0; i < Idfactory; i++) {
            System.out.println("Nhập thông tin cho xưởng thứ: " + (i + 1));
            System.out.println("Nhập mã xưởng sản xuất: ");
            int factoryId;
            Factory factory = null;
            do {
                try {
                    factoryId = new Scanner(System.in).nextInt();
                    for (int k = 0; k < factoryLogic.getFactories().size(); k++) {
                        if (factoryLogic.getFactories().get(k) != null && factoryLogic.getFactories().get(k).getId() == factoryId) {
                            factory = factoryLogic.getFactories().get(k);
                            break;
                        }
                    }
                    if (factory != null) {
                        break;
                    }
                    System.out.println("Không có xưởng sản xuất mang mã " + factoryId + ",vui lòng nhập lại: ");
                } catch (InputMismatchException e) {
                    System.out.println("Mã xưởng sản xuất phải là một nguyên có 3 chữ số, vui lòng nhập lại:");
                }
            } while (true);

            details.add(new TimekeepingManagementDetail(factory, workingDaynumber));
        }
        return details;
    }
    public void sortByWorkerName(){
        if(!isEmpty()){
            System.out.println("Chưa có thông tin công nhân, vui lòng nhập trước khi thực hiện.");
            return;
        }
        Collections.sort(timekeepingManagements, new Comparator<TimekeepingManagement>() {
            public int compare(TimekeepingManagement tm1, TimekeepingManagement tm2) {
                if (tm1 == null || tm2 == null) {
                    return 0;
                }
                String workerName1 = tm1.getWorker().getName().trim();
                String workerName2 = tm2.getWorker().getName().trim();
                return workerName1.compareToIgnoreCase(workerName2);
            }
        });
        showTimekeepingManagement();
    }
    public void sortByFactory(){
        if(!isEmpty()){
            System.out.println("Chưa có thông tin xuưởng, vui lòng nhập trước khi thực hiện.");
            return;
        }
        Collections.sort(timekeepingManagements, new Comparator<TimekeepingManagement>() {
            public int compare(TimekeepingManagement tm1, TimekeepingManagement tm2) {
                if (tm1 == null || tm2 == null) {
                    return 0;
                }
                String factoryName1 = tm1.getFactory().getName().trim();
                String factoryName2 = tm2.getFactory().getName().trim();
                return factoryName1.compareToIgnoreCase(factoryName2);
            }
        });
        showTimekeepingManagement();
    }

    private Worker inputWorkerForList() {
        System.out.println("Nhập mã công nhân: ");
        int workerId;
        Worker worker;
        do{
            workerId = new Scanner(System.in).nextInt();
            worker = workerLogic.searchById(workerId);
            if(worker != null){
                break;
            }
            System.out.print("Không tồn tại công nhân mang mã " + workerId + ", vui lòng nhập lại: ");
        }while (true);
        return worker;
    }
    public void showTable(){
        System.out.println(timekeepingManagements);
    }
    public boolean isEmpty(){
        return timekeepingManagements.isEmpty();
    }

}
