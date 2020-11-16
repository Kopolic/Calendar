package ru.sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main (String[] args) throws ParseException, IOException {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date dateToday = calendar.getTime();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите день экзамена");
        System.out.println("Пример введения даты экзамена: 10/10/1000");
        String eGe = bufferedReader.readLine();
        String dayQuantity;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateExam = dateFormat.parse(eGe);



        int quantityDay = quantity(dateExam,dateToday);
        dayQuantity = word(quantityDay);
        System.out.println(days(dateExam,dateToday,quantityDay, dayQuantity));
    }
    public static int quantity (Date dateEGE, Date dateToday){
        return (int)((dateEGE.getTime() - dateToday.getTime())/1000/24/60/60);
    }
    public static String days(Date dateExam, Date dateToday, int quantityDay,String day){
        quantityDay = Math.abs(quantityDay);
        return switch (dateExam.compareTo(dateToday)){
            case 0 -> "Экзамен сегодня";
            case 1 -> "Экзамен через " + quantityDay + day;
            case -1 -> "Экзамен был " + quantityDay + day + " назад";
            default -> "Не корректные данные";
        };
    }
    public static String word (int quantityDay){
        quantityDay = Math.abs(quantityDay);
        return switch (quantityDay%10){
            case 1 -> " День";
            case 2, 3, 4 -> " Дня";
            default -> " Дней";
        };
    }
}