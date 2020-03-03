// "static void main" must be defined in a public class.
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        System.out.println(minDiff("10:00 AM", "11:00 PM"));
    }
    
    static private int minDiff(String t1, String t2) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        Date startDate = null;
        Date endDate  = null;
        long diff = 0L;
        
        try {            
            startDate = format.parse(t1);
            endDate  = format.parse(t2);
            diff = endDate.getTime() - startDate.getTime();
            
        } catch (Exception e) {
            e.printStackTrace();
        }    
        return Math.abs((int)TimeUnit.MILLISECONDS.toMinutes(diff));
    }
}