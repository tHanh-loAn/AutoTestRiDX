package base;

import java.util.Date;

public class DateTimeArticle {


    public void covertDateToNumber() {
        // 05/01/2021 >> day = 05 + 30 * 01 + 365 * (2021 - 1990)

    }

    public boolean compareDate(String beforeDate, String currentDate) {
        int yearBef = Integer.parseInt(beforeDate.substring(6));
        int yearCurr = Integer.parseInt(currentDate.substring(6));
        if (yearBef < yearCurr) {
            return true;
        } else if (yearBef == yearCurr) {
            int monthBef = Integer.parseInt(beforeDate.substring(3, 5));
            int monthCurr = Integer.parseInt(currentDate.substring(3, 5));
            if (monthBef < monthCurr) {
                return true;
            } else if (monthBef == monthCurr) {
                int dayBef = Integer.parseInt(beforeDate.substring(0, 2));
                int dayCurr = Integer.parseInt(currentDate.substring(0, 2));
                if (dayBef <= dayCurr) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean equalsMonthAndYear(String date, String month, String year) {
        String yearDate = date.substring(6);
        String monthDate = date.substring(3, 5);
        if (yearDate.equals(year) && monthDate.equals(month)) {
            return true;
        } else {
            return false;
        }
    }
}
