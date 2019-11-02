package eecs2030.lab1;

import java.util.List;

/**
 * Short methods reviewing fundamental Java concepts covered in EECS1021,
 * EECS1022, and EECS1720
 * 
 * @author EECS2030 Winter 2017-18
 *
 */
public class Lab1 {

	/**
	 * The course name for EECS2030.
	 */
	public static final String COURSE_NAME = "Advanced Object Oriented Programming";

	/**
	 * The number of cents equal to a Canadian quarter coin.
	 */
	public static final int QUARTER_VALUE = 25;

	/**
	 * The number of degrees in a circle.
	 */
	public static final int DEGREES_IN_CIRCLE = 360;

	private Lab1() {
		// empty by design
	}

	/**
	 * Returns the maximum (most positive) value that an <code>int</code> can
	 * represent.
	 * 
	 * @return the maximum (most positive) value that an int can represent
	 */
	public static int maxInt() {
		return Integer.MAX_VALUE;
	}

	/**
	 * Returns the minimum positive value greater than zero that a
	 * <code>double</code> can represent.
	 * 
	 * @return the minimum positive value greater than zero that a double can
	 *         represent
	 */
	public static double minDouble() {
		
		return Double.MIN_VALUE;
	}

	/**
	 * Returns the largest number of Canadian quarters (each worth 25 cents) whose
	 * total value does not exceed the given number of cents.
	 * 
	 * @param cents
	 *            a positive number of cents
	 * @return the largest number of Canadian quarters (each worth 25 cents) whose
	 *         total value does not exceed the given number of cents
	 */
	public static int numQuarters(int cents) {
		
		return cents / QUARTER_VALUE;
	}

	/**
	 * Wraps an angle given in degrees so that it lies in the range of -359 degrees
	 * to 359 degrees. For example:
	 * 
	 * <pre>
	 * degrees      wrapAngle(degrees) returns
	 *  0            0
	 *  1            1
	 * -1           -1
	 *  359          359
	 * -359         -359
	 *  360          0    (wraps around to 0 degree)
	 * -360          0    (wraps around to 0 degree)
	 *  361          1    (wraps around to 1 degree)
	 * -361         -1    (wraps around to -1 degree)
	 *  725          5    (wraps around to 5 degrees)
	 * -730         -10   (wraps around to -10 degrees)
	 *  3652         52   (wraps around to 52 degrees)
	 * </pre>
	 * 
	 * @param degrees
	 *            an angle in degrees
	 * @return the angle wrapped to the interval -359 to 359 degrees
	 */
	public static int wrapAngle(int degrees) {
		return degrees % Lab1.DEGREES_IN_CIRCLE;
	}

	/**
	 * Compute the average of two values.
	 * 
	 * @param a
	 *            a value
	 * @param b
	 *            a second value
	 * @return the average of the two values
	 */
	public static double avg(int a, int b) {
		
		return (0.0 + a + b) / 2;
	}

	/**
	 * Computes the standard normal distribution probability density function (see
	 * the lab document for the actual formula).
	 * 
	 * @param x
	 *            a value
	 * @return the standard normal distribution probability density function
	 *         evaluated at x
	 */
	public static double normal(double x) {
		
		double y = 1.0 / Math.sqrt(2.0 * Math.PI) * Math.exp(-x * x / 2.0);
		return y;

	}

	/**
	 * Determine if an integer <code>x</code> is even.
	 * 
	 * @param x
	 *            a value
	 * @return true if x is even and false otherwise
	 */
	public static boolean isEven(int x) {
		int remainder = x % 2;
		boolean result = (remainder == 0);
		return result;
	}

	/**
	 * Determine if the point <code>(x, y)</code> is inside the perimeter of a
	 * circle with center <code>(0, 0)</code> and having radius equal to
	 * <code>1</code>.
	 * 
	 * @param x
	 *            the x-coordinate of the point
	 * @param y
	 *            the y-coordinate of the point
	 * @return true if (x, y) is inside the perimeter of the unit circle, and false
	 *         otherwise
	 */
	public static boolean isInsideUnitCircle(double x, double y) {
		double point = (x * x) + (y * y);
		boolean inCircle = (point < 1);
		return inCircle;
	}

	/**
	 * Returns true if the given grade in percent is equal to a letter grade of A,
	 * and false otherwise. The minimum percent grade for a letter grade of A is 80
	 * and the minimum percent grade for a letter grade of A+ is 90.
	 * 
	 * @param percent
	 *            a grade in percent
	 * @return true if the given grade in percent is equal to a letter grade of A,
	 *         and false otherwise
	 */
	public static boolean isGradeA(double percent) {
		int minA = 80;
		int minAPlus = 90;
		boolean gradeA = (minA <= percent) && (percent < minAPlus);
		
		// Your implementation should use minA and minAPlus instead of 80 and 90
		return gradeA;
	}

	/**
	 * Returns true if the given grade in percent is outside the range of normal
	 * grades (less than 0 or greater than 100), and false otherwise.
	 * 
	 * @param percent
	 *            a grade in percent
	 * @return true if the given grade in percent is outside the range of normal
	 *         grades, and false otherwise
	 */
	public static boolean isGradeOutOfRange(double percent) {
		double minGrade = 0.0;
		double maxGrade = 100.0;
		
		boolean outOfRange = (percent < minGrade) || (percent > maxGrade);
		// Your implementation should use minGrade and maxGrade instead of 0 and 100
		return outOfRange;
	}

	/**
	 * Returns true if year is a leap year and false otherwise.
	 * 
	 * <p>
	 * A year is always a leap year if it is evenly divisible by 400; for all other
	 * years, a year is a leap year if it is evenly divisible by 4 and not evenly
	 * divisible by 100. For example:
	 * 
	 * <pre>
	 * isLeapYear(2000)  returns  true   (2000 is divisible by 400)
	 * isLeapYear(1900)  returns  false  (1900 is divisible by 4 and 100)
	 * isLeapYear(2004)  returns  true   (2004 is divisible by 4 but not 100)
	 * isLeapYear(2005)  returns  false  (2005 is not divisible by 4)
	 * </pre>
	 * 
	 * @param year
	 *            a year
	 * @return true if year is a leap year and false otherwise
	 * @throws IllegalArgumentException
	 *             if year is less than 1582 (the year the Gregorian
	 *             calendar was adopted)
	 */
	public static boolean isLeapYear(int year) {
		int startYear = 1582;
		if (year < startYear) {
			throw new IllegalArgumentException();
		}
		boolean leap = false;
		if ((year % 4 == 0) && (year % 100 == 0))
		{
			leap = false;
		}
		else if ((year % 4 == 0) && (year % 100 != 0))
		{
			leap = true;
		}
		else 
		{
			leap = false;
		}
		if (year % 400 == 0)
		{
			leap = true;
		}
		// You may use the magic numbers 4, 100, and 400 in your implementation.
		return leap;
	}

	/**
	 * Determine if a value <code>x</code> is strictly inside the given
	 * <code>Range</code>. A value exactly at the minimum or maximum of the range is
	 * considered outside of the range.
	 * 
	 * @param x
	 *            a value
	 * @param range
	 *            a Range to check
	 * @return the value 1 if x is strictly inside the given Range, and 0 otherwise
	 */
	public static int contains(double x, Range range) {
		int check = 0;
		if (x < range.getMaximum() && x > range.getMinimum())
		{
			check = 1;
		}
		
		
		return check;
	}

	/**
	 * Compares two <code>Range</code> instances by their widths.
	 * 
	 * @param r1
	 *            a Range
	 * @param r2
	 *            a second Range
	 * @return the value 0 if both Range instances are equal; -1 if r1 is narrower
	 *         than r2; and 1 if r1 is wider than r2
	 */
	public static int compareTo(Range r1, Range r2) {
		double width1 = r1.getMaximum() - r1.getMinimum();
		double width2 = r2.getMaximum() - r2.getMinimum();
		int check = 0;
		if (width1 == width2)
		{
			check = 0;
		}
		else if (width1 < width2)
		{
			check = -1;
		}
		else if (width1 > width2)
		{
			check = 1;
		}
		return check;
	}

	/**
	 * Returns the course name as the string.
	 * 
	 * @return the string equal to Lab1.COURSE_NAME
	 */
	public static String getCourseName() {
		return Lab1.COURSE_NAME;
	}

	/**
	 * Returns a string representation of a <code>Range</code> that is different
	 * than the one returned by <code>Range.toString</code>.
	 * 
	 * <p>
	 * The returned string has the form <code>"minimum: x, maximum: y"</code> where
	 * x is the minimum value of the range and y is the maximum value of the range.
	 * 
	 * @param r
	 *            a Range instance
	 * @return a string representation of the range
	 */
	public static String toString(Range r) {
		
		return "minimum: " + r.getMinimum() + ", maximum: " + r.getMaximum();
	}

	/**
	 * Returns the character n positions from the end of the string s. For example,
	 * suppose <code>s</code> is the string <code>"abcd"</code>; then:
	 * 
	 * <pre>
	 * Lab1.charFromEnd(s, 0)  returns 'd'
	 * Lab1.charFromEnd(s, 1)  returns 'c'
	 * Lab1.charFromEnd(s, 2)  returns 'b'
	 * Lab1.charFromEnd(s, 3)  returns 'a'
	 * Lab1.charFromEnd(s, 4)  throws an IllegalArgumentException
	 * Lab1.charFromEnd(s, -1) throws an IllegalArgumentException
	 * </pre>
	 * 
	 * @param s
	 *            a string of length 1 or greater
	 * @param n
	 *            the desired location of the character counting from the end of the
	 *            string
	 * @return the character located n positions from the end of the string
	 * @throws IllegalArgumentException
	 *             if the character located n positions from the end of the string
	 *             does not exist
	 */
	public static char charFromEnd(String s, int n) {
		if (s.isEmpty()) 
		{
			throw new IllegalArgumentException("string has length 0");
		}
		if (s.length() < n)
		{
			throw new IllegalArgumentException("string has no character located n positions from the end of the string");
		}
		return s.charAt(s.length() - 1 - n);
	}

	/**
	 * Sorts a list of two integers so that the elements are in descending order
	 * (largest to smallest). The size of the list remains unchanged.
	 * 
	 * @param t
	 *            a list
	 * @throws IllegalArgumentException
	 *             if the size of list is not equal to 2
	 */
	public static void sort2(List<Integer> t) {
		if (t.size() != 2)
		{
			throw new IllegalArgumentException("list size != 2");
		}
		int elem1 = t.get(0);
		int elem2 = t.get(1);
		
		if (elem1 < elem2)
		{
		t.set(0, elem2);
		t.set(1, elem1);
	    }
	}

	/**
	 * Returns the number of strings in the list t that are equal to the target
	 * string.
	 * 
	 * @param t
	 *            the list to search
	 * @param target
	 *            the string to search for
	 * @return the number of strings in the list t that are equal to target
	 */
	public static int frequency(List<String> t, String target) {
		int counter = 0;
		for (int i = 0; i < t.size(); i++)
		{
			String elem = t.get(i);
			if (elem == target)
			{
				counter = counter + 1;
			}
		}
		return counter;
	}

	/**
	 * Sorts the elements of the list t so that the elements are in ascending order.
	 * A precondition of this method is that t must be already sorted in ascending
	 * order except that adjacent pairs of elements in t may be out of order.
	 * Consider the following almost sorted lists:
	 * 
	 * <pre>
	 * [1, 0]                1, 0 is out of order
	 * [0, 2, 1]             2, 1 is out of order
	 * [0, 2, 1, 3]          2, 1 is out of order
	 * [0, 2, 1, 4, 3]       2, 1 and 4, 3 are out of order
	 * [0, 1, 3, 2, 4]       3, 2 is out of order
	 * </pre>
	 * 
	 * <p>
	 * This method switches the positions of the out-of-order adjacent elements thus
	 * repairing the list so that it is in sorted order.
	 * 
	 * @param t
	 *            a list of almost sorted elements 
	 * 
	 * @pre. t is sorted in ascending order except that adjacent pairs of elements 
	 *       may be out of order
	 */
	public static void repair(List<Integer> t) {
		// if the list has less than 2 elements then is already sorted
		if (t.size() < 2) {
			return;
		}
		for (int i = 0; i < (t.size() - 1); i++)
		{
			int elem1 = t.get(i);
			int elem2 = t.get(i + 1);
			if (elem1 > elem2)
			{
				t.set(i, elem2);
				t.set(i + 1, elem1);
			}
		}
		
		
	}

}
