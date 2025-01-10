package org.boyerfamily.euler;

/**
 * Project Euler, problem 19.
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * Analysis: if days since 31 Dec 1899 is evenly divisible by 7, it's a sunday.  So, for each 1st of the month,
 * compute days since my epoch, and mod it by 7.  If it's zero, increment count. Note that 2000 is a leap year, so
 * we don't need to special case it.
 */
public class Problem19 {
    public static void main(String[] args) {
        int daysSince = 366; // 365 days in 1900, plus one day from monday back to sunday
        int count = 0;

        for (int year=1901; year <2001; year++) {
            for (int month=1; month <= 12; month++) {
                if (daysSince % 7 == 0) {
                    count++;
                    System.out.printf("Found a sunday on %d/1/%d.\n", month, year);
                }

                int days = getDaysOfMonth(year, month);
                daysSince += days;
//                System.out.printf("Adding %d days for %d/%d\n", days, month, year);
            }
        }

        System.out.printf("Found %d Sundays on the first of the month", count);
    }

    private static int getDaysOfMonth(int year, int month) {
        int[] month_count = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((month == 2) && isLeapYear(year)) {
            return 29;
        } else {
            return month_count[month];
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }
}
