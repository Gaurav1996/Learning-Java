import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
    private List<String> fromList;
    private List<String> toList;

    public ListUtils() {
        String toString = "C:\\Users\\gagrawal\\Desktop\\Gaurav_File_check\\junk_test_files\\test";
        this.fromList = Arrays.asList("http://textfiles.com/adventure/221baker.txt",
                "http://textfiles.com/adventure/221bakerst.txt",
                "http://textfiles.com/adventure/2400ad.txt",
                "http://textfiles.com/adventure/2400adfaq.txt",
                "http://textfiles.com/adventure/abyssal.txt",
                "http://textfiles.com/adventure/accoladecomics.txt",
                "http://textfiles.com/adventure/adventhint.txt",
                "http://textfiles.com/adventure/adventur.txt",
                "http://textfiles.com/adventure/adventure.txt",
                "http://textfiles.com/adventure/adventureland.txt",
                "http://textfiles.com/adventure/adventureland2.txt",
                "http://textfiles.com/adventure/advquest.txt",
                "http://textfiles.com/adventure/aencounter.txt",
                "http://textfiles.com/adventure/aland.txt",
                "http://textfiles.com/adventure/aland2.txt");
        this.toList = new ArrayList<>();
        for(int i=1;i<=fromList.size();i++) {
            this.toList.add(String.format("%s%s.txt",toString,i));//test1.txt,test2.txt...
        }
    }

    public List<String> getFromList() {
        return fromList;
    }

    public List<String> getToList() {
        return toList;
    }
}
