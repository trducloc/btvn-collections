package entity;

import java.util.List;

public class TimekeepingManagement {
    private Worker worker;
    private Factory factory;
    private List<TimekeepingManagementDetail> timekeepingManagementDetails;

    public TimekeepingManagement(Factory factory, int workingDaynumber) {
    }

    public Worker getWorker() {
        return worker;
    }
    public Factory getFactory() {
        return factory;
    }
    public TimekeepingManagement(Worker worker, List<TimekeepingManagementDetail> details) {
    }


}
