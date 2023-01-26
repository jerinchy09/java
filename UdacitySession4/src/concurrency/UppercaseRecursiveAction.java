package concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

public class UppercaseRecursiveAction extends RecursiveAction {
    private String workload = "";
    private static final int THRESHOLD = 4;

    private static Logger logger =
            Logger.getAnonymousLogger();

    public UppercaseRecursiveAction(String workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if (workload.length() > THRESHOLD) {
            List<UppercaseRecursiveAction> subTasks = createSubtasks();
            invokeAll(subTasks);
        } else {
            processing(workload);
        }
    }

    private List<UppercaseRecursiveAction> createSubtasks() {
        List<UppercaseRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        System.out.println("-------------Tasks to be added------------------");
        System.out.println("Part 1: " + partOne);
        System.out.println("Part 2: " + partTwo);

        subtasks.add(new UppercaseRecursiveAction(partOne));
        subtasks.add(new UppercaseRecursiveAction(partTwo));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return subtasks;
    }

    private void processing(String work) {
        String result = work.toUpperCase();
        logger.info("This result - (" + result + ") - was processed by "
                + Thread.currentThread().getName());
    }
}
