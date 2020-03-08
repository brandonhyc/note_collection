// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(dayOfWeek("Monday", 1));
        System.out.println(dayOfWeek("Monday", 7));
        System.out.println(dayOfWeek("Monday", 6));
        System.out.println(dayOfWeek("Sunday", 6));
    }
    
    static private String dayOfWeek(String today, int next) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int i = 0;
        for (; i < days.length && !days[i].equals(today); i++);
        return days[(next + i) % 7];
    }
    
}