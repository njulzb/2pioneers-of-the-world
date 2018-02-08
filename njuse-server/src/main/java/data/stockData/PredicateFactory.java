package data.stockData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

/**
 * 可以用于复杂条件的搜索扩展
 */
public class PredicateFactory {
    public PredicateFactory() {
    }

    public Predicate byCode(String code){
       Predicate<String> predicate = x->{
           String[] array = x.split("\t");
           String codeStr = array[8];
           return code.equals(codeStr);
       };
       return predicate;
    }

    public Predicate byName(String name){
        Predicate<String> predicate = x->{
            String[] array = x.split("\t");
            String nameStr = array[9];
            return name.equals(nameStr);

        };
        return predicate;
    }

    public Predicate byCodeAndName(String code , String name){
        PredicateFactory factory = new PredicateFactory();
        return factory.byCode(code).and(factory.byName(name));
    }


    public Predicate byDate(Date begin,Date end){
        Predicate<String> predicate = x->{
            String[] array = x.split("\t");
            String dateStr = array[1];
            DateFormat format = new SimpleDateFormat("MM/dd/yy");
            Date date = null;
            try {
                date = format.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("date format wrong");
            }
            if (date == null) {
                return false;
            }
            boolean betweenFlag = date.after(begin) && date.before(end);
            boolean pointFlag = date.equals(begin) || date.equals(end);
            return betweenFlag || pointFlag;
        };
        return predicate;
    }

    public Predicate byNameAndDate(String name,Date begin ,Date end){
        PredicateFactory factory = new PredicateFactory();
        return factory.byName(name).and(factory.byDate(begin,end));
    }

}
