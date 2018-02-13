package UI.uiHelper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class DateHelper {


    public static String formatDate(Date date) {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");

        String out = myFmt.format(date);
        return out;
    }

    public static Date LocalDateToDate(LocalDate ld) {
        int year = ld.getYear();
        Month month = ld.getMonth();
        int day = ld.getDayOfMonth();
        System.out.println(day);
        Date c = new Date();
        c.setYear(year - 1900);
        c.setMonth(month.getValue() - 1);
        c.setDate(day);
        return c;

    }

    public static LocalDate DateToLocalDate(Date ld) {
        SimpleDateFormat fmtYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat fmtMonth = new SimpleDateFormat("MM");
        SimpleDateFormat fmtDay = new SimpleDateFormat("dd");

        return LocalDate.of(Integer.valueOf(fmtYear.format(ld)), Integer.valueOf(fmtMonth.format(ld)), Integer.valueOf(fmtDay.format(ld)));

    }
}
