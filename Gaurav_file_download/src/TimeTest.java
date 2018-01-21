import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime currentTime = LocalDateTime.now();
        String current = currentTime.format(formatter);
        LocalDateTime previousTime = currentTime.minusDays(30);
        String previous = previousTime.format(formatter);
        System.out.println("Current date is :"+current);
        System.out.println("Previous date is :"+previous);
    }
}
