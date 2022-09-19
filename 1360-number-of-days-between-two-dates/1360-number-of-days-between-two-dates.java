class Solution {
    // count the day start from 1971, then substract the days
    private int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(countDays(date1) - countDays(date2));      
    }
    
    private int countDays(String date){
        String[] dateStr = date.split("-");
        int year = Integer.parseInt(dateStr[0]), month = Integer.parseInt(dateStr[1]);
        int day = Integer.parseInt(dateStr[2]);
        int count = day;
        for (int i = 1971; i < year; i++) count += (isLeapYear(i)) ? 366 : 365;
        for (int i = 0; i < month - 1; i++) count += months[i];
        if (month > 2 && isLeapYear(year)) count += 1;
        return count;
    }
    
    private boolean isLeapYear(Integer year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}