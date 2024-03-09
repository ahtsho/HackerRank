package date.time;

public class DayOfTheWeekFinder {
	
	   public static String findDay(int month, int day, int year) {
	        //January 1, 2001 = Monday 
	        int q = day;
	        int m = month;
	        int Y = (m < 3) ? year - 1 : year;
	        m = (m < 3) ? m + 12 : m;
	        int K = Y % 100;
	        int J = Y / 100;
	        // For the Gregorian calendar, Zeller's congruence 
	        int h = (q + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) - (2 * J)) % 7;
	        
	        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	        return daysOfWeek[(h + 7) % 7].toUpperCase();
	    }
	
	
	 /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
    /**
     * 
     */
   /* static int START_YEAR = 2001;
    static int START_MONTH = 1;
    static int START_DAY = 1;
    public static String findDay(int month, int day, int year) {
        //January 1, 2001 = Monday 
        int years = (year - START_YEAR);
        int leapYears = 1/4 * years;
        int normalYears = years - leapYears;
        int yearsInDays = leapYears * 366 + normalYears * 365;
        
        int months = (month - START_MONTH);
        int monthsInDays = 0;
        for(int i = 1; i <= months; i++){
            monthsInDays += getDaysOfMonth(i, year);
        }
        
        
        int days = (day - START_DAY);
        
        
        int daysSinceStart = yearsInDays + monthsInDays + days;
        //System.out.println(daysSinceStart);
        String dayOfTheWeek = "";
        switch(daysSinceStart % 7){
            case 0: 
                dayOfTheWeek = "MONDAY";
                break;
            case 1:
                dayOfTheWeek = "TUESDAY";
                break;
            case 2:
                dayOfTheWeek = "THURSDAY";
                break;
            case 3:
                dayOfTheWeek = "WEDNESDAY";
                break;
            case 4:
                dayOfTheWeek = "FRIDAY";
                break;
            case 5:
                dayOfTheWeek = "SATURDAY";
                break;
            case 6:
                dayOfTheWeek = "SUNDAY";
                break;
        }
        System.out.println(dayOfTheWeek);
        return dayOfTheWeek;
    }
    
    private static int getDaysOfMonth(int month, int year){
        int days = 0;
         switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30; 
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0){
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }
        return days;
    }*/
}
