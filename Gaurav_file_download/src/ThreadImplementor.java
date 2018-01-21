import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ThreadImplementor implements Runnable {
    String fromFile;
    String toFile;
    String threadName;

    public ThreadImplementor(String fromFile, String toFile, String threadName) {
        this.fromFile = fromFile;
        this.toFile = toFile;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.format("Starting Download from Thread %s",threadName));
            URL website = new URL(fromFile);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(toFile);
            fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
            fos.close();
            rbc.close();
            System.out.println(String.format("Finished Download from Thread %s",threadName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
