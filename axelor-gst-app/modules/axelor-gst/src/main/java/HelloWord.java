

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HelloWord{

     public static void main(String []args){
        System.out.println("Hello World");
        
//        DateTimeFormatter fm =  DateTimeFormatter("yyyy-mm-dd");
        String dateString = "01/13/2012";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US); 
        LocalDate date = LocalDate.parse(dateString, dateFormat);
        LocalDate newDate = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        System.out.println(newDate.getDayOfMonth());
        
//        final String dateTime = "2012-02-22T02:06:58.147Z";
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
//        final ZonedDateTime parsed = ZonedDateTime.parse(dateTime, formatter.withZone(ZoneId.of("UTC")));
//        System.out.println(parsed.toLocalDateTime());
     }
}
