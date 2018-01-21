import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileDownloadUsingExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ListUtils listUtils = new ListUtils();
        List<String> fromList = listUtils.getFromList();
        List<String> toList = listUtils.getToList();

        List<Future> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < fromList.size(); i++) {
            String from = fromList.get(i);
            String to = toList.get(i);
            //Execute method returns void whereas submit returns a future.
            //in case of runnable if future.get is null, task is success, for callable it is the callable return string

            //executorService.execute(new ThreadImplementor(from, to,String.format("T - %s",i+1)));
             Future future = executorService.submit(new ThreadImplementor(from, to,String.format("T - %s",i+1)));
             futures.add(future);
        }
        //wait for all futures to complete??
        int count = 0;
        for(Future f : futures) {
            try {
                if(null == f.get()) {//Here f.get() should be null since i passed runnable to submit. Had i passed callable i would be expecting something from get()
                    count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();//Doesn't really close, instead stops from accepting new tasks.
        //This method does not wait for previously submitted tasks to complete execution. Use awaitTermination to do that.
        if(count == fromList.size()) {
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Time Taken to complete is %s milliseconds",endTime-startTime));
        }
        else {
            System.out.println("Some error occurred");
        }
    }
}
