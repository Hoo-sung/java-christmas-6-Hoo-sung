package christmas.domain;

public class Day {

    private final int day;

    public Day(int day) {
        this.day = day;
    }

    public static boolean checkWeekend(Day day){
        if(day.day % 7 ==1 || day.day % 7 == 2)
            return true;
        return false;
    }
    public static boolean checkWeekday(Day day){
        if(!checkWeekend(day))
            return true;
        return false;
    }
}
