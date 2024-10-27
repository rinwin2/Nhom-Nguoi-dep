package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class Utils {

    public static String getValue(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int getIntValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid integer.");
            }
        }
        return value;
    }

    public static double getDoubleValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        double value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                value = Double.parseDouble(sc.nextLine());
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid decimal number.");
            }
        }
        return value;
    }

    public static boolean getBooleanValue(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg + " (true/false)");
        boolean value = false;
        boolean valid = false;
        while (!valid) {
            try {
                value = Boolean.parseBoolean(sc.nextLine().toLowerCase());
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter true or false.");
            }
        }
        return value;
    }
    public static String getDateValue(String msg) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false); 
        String dateString = null;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(msg);
                dateString = sc.nextLine(); 
                formatter.parse(dateString); 
                valid = true; 
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter a valid date in the format dd/MM/yyyy.");
            }
        }
        return dateString; 
    }

      
   
}