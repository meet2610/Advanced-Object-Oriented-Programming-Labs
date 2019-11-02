package eecs2030.lab1;

/**
 * A utility class for computing hypotrochoid curves generated by a Spirograph.
 * 
 * <p>
 * This class assumes that the radius of the large Spirograph wheel is given by
 * <code>SpiroUtil.BIG_WHEEL_RADIUS</code>.
 * 
 * @author EECS2030 Fall 2016
 *
 */
public class SpiroUtil {
    
    private SpiroUtil() {
        // empty by design
    }

    /**
     * Radius of the big Spirograph wheel.
     */
    public static final double BIG_WHEEL_RADIUS = 1.0;

    /**
     * Checks the small wheel radius and pencil radius.
     * 
     * <p>
     * Throws an <code>IllegalArgumentException</code> if any of the following
     * are <code>true</code>:
     * 
     * <ul>
     * <li><code>wheelRadius &lt; 0.0</code>
     * <li><code>wheelRadius &gt; SpiroUtil.BIG_WHEEL_RADIUS</code>
     * <li><code>pencilRadius &lt; 0.0</code>
     * <li><code>pencilRadius &gt; wheelRadius</code>
     * 
     * 
     * @param wheelRadius
     *            the small wheel radius
     * @param pencilRadius
     *            the pencil radius
     * @throws IllegalArgumentException
     *             if any of the conditions listed above are <code>true</code>
     */
    private static void checkRadii(double wheelRadius, double pencilRadius) {
        if (wheelRadius < 0.0) {
            throw new IllegalArgumentException("wheel radius is negative");
        }
        if (wheelRadius > SpiroUtil.BIG_WHEEL_RADIUS) {
            throw new IllegalArgumentException("wheel radius is greater than SpiroUtil.BIG_WHEEL_RADIUS");
        }
        if (pencilRadius < 0.0) {
            throw new IllegalArgumentException("pencil radius is negative");
        }
        if (pencilRadius > wheelRadius) {
            throw new IllegalArgumentException("pencil radius is greater than wheel radius");
        }
    }

    /**
     * Returns the x-coordinate of the pencil location for a Spirograph.
     * 
     * <p>
     * Throws an <code>IllegalArgumentException</code> if any of the following
     * are <code>true</code>:
     * 
     * <ul>
     * <li><code>wheelRadius &lt; 0.0</code>
     * <li><code>wheelRadius &gt; SpiroUtil.BIG_WHEEL_RADIUS</code>
     * <li><code>pencilRadius &lt; 0.0</code>
     * <li><code>pencilRadius &gt; wheelRadius</code>
     * </ul>
     * 
     * @param wheelRadius
     *            radius of the small Spirograph wheel
     * @param pencilRadius
     *            radius of the pencil location on the small Spirograph wheel
     * @param degrees
     *            the angle in degrees between the x-axis and the pencil
     *            location
     * @return the x-coordinate of the pencil
     * @throws IllegalArgumentException
     *             if any of the conditions listed above are <code>true</code>
     */
    public static double hypoX(double wheelRadius, double pencilRadius, double degrees) {
        SpiroUtil.checkRadii(wheelRadius, pencilRadius);
        double t = Math.toRadians(degrees);
        double rL = SpiroUtil.BIG_WHEEL_RADIUS;
        double rS = wheelRadius;
        double h = pencilRadius;
        double x = (rL - rS) * Math.cos(t) + h * Math.cos((rL - rS) * t / rS);
        return x;
    }

    /**
     * Returns the y-coordinate of the pencil location for a Spirograph.
     * 
     * <p>
     * Throws an <code>IllegalArgumentException</code> if any of the following
     * are <code>true</code>:
     * 
     * <ul>
     * <li><code>wheelRadius &lt; 0.0</code>
     * <li><code>wheelRadius &gt; SpiroUtil.BIG_WHEEL_RADIUS</code>
     * <li><code>pencilRadius &lt; 0.0</code>
     * <li><code>pencilRadius &gt; wheelRadius</code>
     * </ul>
     * 
     * @param wheelRadius
     *            radius of the small Spirograph wheel
     * @param pencilRadius
     *            radius of the pencil location on the small Spirograph wheel
     * @param degrees
     *            the angle in degrees between the x-axis and the pencil
     *            location
     * @return the y-coordinate of the pencil
     * @throws IllegalArgumentException
     *             if any of the conditions listed above are <code>true</code>
     */
    public static double hypoY(double wheelRadius, double pencilRadius, double degrees) {
        SpiroUtil.checkRadii(wheelRadius, pencilRadius);
        double t = Math.toRadians(degrees);
        double rL = SpiroUtil.BIG_WHEEL_RADIUS;
        double rS = wheelRadius;
        double h = pencilRadius;
        double y = (rL - rS) * Math.sin(t) - h * Math.sin((rL - rS) * t / rS);
        return y;
    }

    /**
     * Returns the point representing the coordinates of the pencil location for
     * a Spirograph.
     * 
     * <p>
     * Throws an <code>IllegalArgumentException</code> if any of the following
     * are <code>true</code>:
     * 
     * <ul>
     * <li><code>wheelRadius &lt; 0.0</code>
     * <li><code>wheelRadius &gt; SpiroUtil.BIG_WHEEL_RADIUS</code>
     * <li><code>pencilRadius &lt; 0.0</code>
     * <li><code>pencilRadius &gt; wheelRadius</code>
     * </ul>
     * 
     * @param wheelRadius
     *            radius of the small Spirograph wheel
     * @param pencilRadius
     *            radius of the pencil location on the small Spirograph wheel
     * @param degrees
     *            the angle in degrees between the x-axis and the pencil
     *            location
     * @return the point representing the coordinates of the pencil
     * @throws IllegalArgumentException
     *             if any of the conditions listed above are <code>true</code>
     */
    public static Point2 hypo(double wheelRadius, double pencilRadius, double degrees) {
        double x = SpiroUtil.hypoX(wheelRadius, pencilRadius, degrees);
        double y = SpiroUtil.hypoY(wheelRadius, pencilRadius, degrees);
        return new Point2(x, y);
    }

}