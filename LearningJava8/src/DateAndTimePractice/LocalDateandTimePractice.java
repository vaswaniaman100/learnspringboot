package DateAndTimePractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateandTimePractice {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = LocalDate.of(2020,10,9);
        System.out.println(date1);



        System.out.println();
        System.out.println(date.plusDays(20));

        System.out.println();
        System.out.println(date.plusWeeks(20));

        System.out.println();
        System.out.println(date.plusMonths(20));

        System.out.println();
        System.out.println(date.plusYears(20));



        System.out.println();
        System.out.println(date.minusDays(20));

        System.out.println();
        System.out.println(date.minusMonths(20));

        System.out.println();
        System.out.println(date.minusWeeks(20));

        System.out.println();
        System.out.println(date.minusYears(20));

        System.out.println();
        LocalDateTime dateandtime = LocalDateTime.now();
        System.out.println(dateandtime);

        System.out.println();
        System.out.println(dateandtime.plusHours(25));

        System.out.println();
        System.out.println(dateandtime.plusMinutes(25));

        System.out.println();
        System.out.println(dateandtime.plusSeconds(25));

        System.out.println();
        System.out.println(dateandtime.minusHours(25));

        System.out.println();
        System.out.println(dateandtime.minusHours(25));
        System.out.println();
        System.out.println(dateandtime.minusHours(25));


        LocalDateTime dandt = LocalDateTime.of(2020,9,10,12,30,25);
        System.out.println(dandt);

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        System.out.println(dt.format(dandt));

        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        System.out.println(dt1.format(date));



    }
}
