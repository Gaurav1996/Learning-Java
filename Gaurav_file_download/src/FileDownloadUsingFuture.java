import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FileDownloadUsingFuture {
    public static void main(String[] args) {
        ListUtils listUtils = new ListUtils();
        List<String> fromList = listUtils.getFromList();
        List<String> toList = listUtils.getToList();

        List<CompletableFuture> completableFutureList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<fromList.size();i++) {
            String from = fromList.get(i);
            String to = toList.get(i);
            CompletableFuture completableFuture = CompletableFuture.runAsync(new ThreadImplementor(from, to,String.format("T - %s",i+1)));
            completableFutureList.add(completableFuture);
        }
        //Waiting for all the futures to complete
        CompletableFuture allFutures = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()]));
        try {
            if(null == allFutures.get()) {
                long endTime = System.currentTimeMillis();
                System.out.println(String.format("Time Taken to complete is %s milliseconds",endTime-startTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
