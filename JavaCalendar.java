/*
 *Programmer: Arianna Biernacki
 *Student ID: xxxxxxxxx
 *Assignment: Assignment Three
 *Date: December 2, 2019
 *Description: This program creates a calendar
 */
package Assignment3;

import java.util.Scanner;

public class JavaCalendar {

    public static int getStartDate(int month, int year) {
        int startDay = 2;
        int totalNumberOfDays = getTotalNumberOfDays(month, year);
        return (totalNumberOfDays + startDay) % 7;
    }

    public static int getTotalNumberOfDays(int month, int year) {
        int totalDays = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays = totalDays + 366;
            } else {
                totalDays = totalDays + 365;
            }
        }
        for (int i = 1; i < month; i++) {
            totalDays = totalDays + getTotalDaysInMonth(i, year);
        }

        return totalDays;
    }

    public static int getTotalDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return (isLeapYear(year) ? 29 : 28);
        } else {
            return 0;
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0));
    }

    public static void printCalendarBody(int month, int year) {
        for (int i = 0; i < getStartDate(month, year); i++) {
            System.out.print("     ");
        }
        for (int i = 1; i <= getTotalDaysInMonth(month, year); i++) {
            System.out.printf("%-5d", i);
            if ((i + getStartDate(month, year)) % 7 == 0) {
                System.out.println("");
            }
        }
    }

    public void printCalendarMonth(int month, int year) {
        printCalendarHeader(month, year);
        printCalendarSubHeader();
        printCalendarBody(month, year);
    }

    public static void printCalendarSubHeader() {
        System.out.println("Mon  Tue  Wed  Thu  Fri  Sat  Sun");
    }

    public static void printCalendarHeader(int month, int year) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        System.out.println(monthName + " " + year);
    }

    public static int getMonth() {
        System.out.println("Enter a month: ");
        Scanner month = new Scanner(System.in);
        return month.nextInt();
    }

    public static int getYear() {
        System.out.println("Enter a year: ");
        Scanner year = new Scanner(System.in);
        return year.nextInt();
    }
}
