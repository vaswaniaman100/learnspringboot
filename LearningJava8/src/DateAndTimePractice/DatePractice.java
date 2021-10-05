package DateAndTimePractice;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePractice {
    public static void main(String[] args) throws ParseException {

        Date d = new Date();
        Date d1 = new Date();
        Date d2= new Date();
        System.out.println(d.getDate());
        System.out.println(d);
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        String s =  sd.format(d);
        System.out.println(s);
        d1 =new Date(2020-1900,12-1,27);
        System.out.println(sd.format(d));
        d2= new Date("12/31/2019");
        System.out.println(sd.format(d));
        long diffmillisec=  d1.getTime()-d2.getTime();
        System.out.println(diffmillisec);
        System.out.println(TimeUnit.MILLISECONDS.toDays(diffmillisec));

        Instant instantofd1 =d1.toInstant();
        Instant instantofd2 =d2.toInstant();
        Duration du = Duration.between(instantofd2, instantofd1);
        System.out.println(du.toHours());
        System.out.println(du.toDays());

        Date h = new SimpleDateFormat("dd/MM/yyyy").parse("12/2/2028");
        System.out.println(sd.format(h));

        Timestamp t = new Timestamp(d.getTime());
        System.out.println(t);

    }

}