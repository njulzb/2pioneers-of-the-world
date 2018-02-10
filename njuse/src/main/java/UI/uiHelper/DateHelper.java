package UI.uiHelper;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class DateHelper {


    public static String formatDate(Date date){
        String out ="";
        out =out+date.getYear()+"年";
        out=out+date.getMonth()+"月";
        out =out+date.getDate()+"日";
        return out;
    }
    public static Date LocalDateToDate(LocalDate ld) {
        int year = ld.getYear();
        Month month = ld.getMonth();
        int day = ld.getDayOfMonth();
        System.out.println(day);
        Date c = new Date();
        c.setYear(year-1900);
        c.setMonth(month.getValue()-1);
        c.setDate(day);
        return c;

    }

}
