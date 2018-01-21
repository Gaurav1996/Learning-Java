import java.util.ArrayList;
import java.util.List;

public class FileDownloadUsingThreads {
    public static void main(String[] args) {

        ListUtils listUtils = new ListUtils();
        List<String> fromList = listUtils.getFromList();
        List<String> toList = listUtils.getToList();

        List<Thread> threadList = new ArrayList<>();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < fromList.size(); i++) {
            String from = fromList.get(i);
            String to = toList.get(i);
            Thread t = new Thread(new ThreadImplementor(from, to,String.format("T - %s",i+1)));
            threadList.add(t);
            t.start();
        }
        //waiting for all threads to complete, so a workaround. Ideal solution would be completion executor service,
        //but that is not the goal of this program
        for(Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Time Taken to complete is %s milliseconds",endTime-startTime));
    }
}
