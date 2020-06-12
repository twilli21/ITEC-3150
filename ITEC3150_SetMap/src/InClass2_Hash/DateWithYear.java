package InClass2_Hash;

// Represents a calendar year/month/day date.
public class DateWithYear {
    private int year;
    private int month;   // fields
    private int day;

    // Constructs a new Date to represent the specified month/day.
    public DateWithYear(int year, int month, int day) {
        __checkState(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    // Returns true if o refers to a Date object representing the same calendar date
    // as this Date object.
    public boolean equals(Object o) {
        if (o instanceof DateWithYear) {
            DateWithYear other = (DateWithYear) o;
            return year == other.getYear() && month == other.getMonth() && day == other.getDay();
        } else {
            return false;
        }
    }
    
    // Returns this Date's day.
    public int getDay() {
        return day;
    }
    
    // Returns this Date's month.
    public int getMonth() {
        return month;
    }
    
    // Returns this Date's year.
    public int getYear() {
        return year;
    }
    
    // Returns a String representation of this Date, such as "2014/09/19".
    public String toString() {
        return String.format("%04d/%02d/%02d", year, month, day);
    }
    
    // checkState method throws an IllegalStateException if the Date has an invalid year, month, and/or day.
    public void __checkState() {
        __checkState(this.year, this.month, this.day);
    }
    
    public void __checkState(int year, int month, int day) {
        if (year < 0) {
            throw new IllegalStateException("Illegal year (cannot be negative): " + year);
        }
        if (month < 0 || month > 12) {
            throw new IllegalStateException("Illegal month (must be between 1-12): " + month);
        }
        int maxDay = (month == 9 || month == 4 || month == 6 || month == 11) ? 30 : (month == 2) ? ((year % 400 == 0 || year % 4 == 0 && year % 100 != 0) ? 29 : 28) : 31;
        if (day < 1 || day > maxDay) {
            throw new IllegalStateException("Illegal day (must be between 1-" + maxDay + "): " + day);
        }
    }

	//TODO: Define the hashCode method below
    public int hashCode() {
    	return year*31*31 + month*31 + day;
    }
}
