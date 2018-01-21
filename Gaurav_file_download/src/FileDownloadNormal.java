import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

public class FileDownloadNormal {
    public static void main(String[] args) {
        ListUtils listUtils = new ListUtils();
        List<String> fromList = listUtils.getFromList();
        List<String> toList = listUtils.getToList();
        long startTime = System.currentTimeMillis();
        for(int i=0;i< fromList.size();i++) {
            String fromFile = fromList.get(i);
            String toFile = toList.get(i);
            downloadFile(fromFile,toFile);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Time Taken to complete is %s milliseconds",endTime-startTime));
    }

    private static void downloadFile(String fromFile, String toFile) {
        try {
            System.out.println(String.format("Starting Download from Thread %s",Thread.currentThread().getName()));
            URL website = new URL(fromFile);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(toFile);
            fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
            fos.close();
            rbc.close();
            System.out.println(String.format("Finished Download from Thread %s",Thread.currentThread().getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
