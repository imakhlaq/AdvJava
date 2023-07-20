package in.jdbc.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Locale;

public class Date {
    public static void main(String[] args) {

        String str = "16_08_2020";
        LocalDate d = LocalDate.parse(str, DateTimeFormatter.ofPattern("dd_MM_yyyy"));


        System.out.println(java.sql.Date.valueOf(d).getTime());

    }
}
