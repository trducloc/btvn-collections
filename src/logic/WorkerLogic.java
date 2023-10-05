package logic;

import entity.Worker;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WorkerLogic<T extends Worker> {
    private List<T> workers;
    private int totalWorker;
    private WorkerLogic workerLogic;

    public WorkerLogic(List<T> workers) {
    }
    public WorkerLogic() {
        workers = new ArrayList<>();
    }

    public int getTotalWorker() {
        return totalWorker;
    }
    public void inputWorker(){
        System.out.print("Có bao nhiêu công nhân muốn thêm mới: ");
        int workerNumber;
        do {
            try {
                workerNumber = new Scanner(System.in).nextInt();
                if (workerNumber > 0) {
                    break;
                }
                System.out.print("Số lượng công nhân là một số nguyên dương, vui lòng nhập lại: ");
            } catch(InputMismatchException e){
                System.out.print("Số lượng công nhân phải là một số nguyên dương, vui lòng nhập lại:");
            }
        } while (true);
        for (int i = 0; i < workerNumber; i++) {
            System.out.println("Nhập thông tin cho công nhân thứ: " + (i+1));
            Worker worker = new Worker();
            worker.inputInfo();
            saveWorker((T) worker);
        }
    }

    private void saveWorker(T worker) {
        workers.add(worker);
    }
    public void showWorker(){
        System.out.println(workers);
    }
    public boolean isEmptyWorker(){
        return workers.isEmpty();
    }
    public Worker searchById(int workerId) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getId() == workerId) {
                return workers.get(i);
            }
        }
        return null;
    }

}
