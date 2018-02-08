package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public static DateFormat format = new SimpleDateFormat("MM/dd/yy");


    public static Date getYesterday(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,-1);
        today = calendar.getTime();
        return today;
    }

    public static Date getTomorrow(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,1);
        today = calendar.getTime();
        return today;
    }

    public static Date getDaysBefore(Date today,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,days * -1);
        today = calendar.getTime();
        return today;

    }

    public static Date getDaysAfter(Date today,int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE,days);
        today = calendar.getTime();
        return today;

    }

    public static Date stringToDate(String dateStr) {
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("format wrong");
        }
        return date;
    }

    public static String dateToString(Date date){
        return format.format(date);
    }

}
