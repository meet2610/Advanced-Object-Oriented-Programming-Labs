package eecs2030.lab3;

import java.awt.Color;
import java.util.Objects;

/**
 * A class that supports turtle graphics. A turtle walks between two points in a
 * straight line drawing the line as it moves.
 * 
 * <p>
 * A turtle has-a {@code Point2} instance that represents the position of the
 * turtle, a {@code Direction2} instance that represents the direction that the
 * turtle is facing in, and a {@code Pen} instance that represents the pen that
 * the turtle draws with.
 * 
 * @author EECS2030 Winter 2017-18
 * 
 */
public class Turtle {

	/**
	 * The position of this turtle.
	 */
	private Point2 position;

	/**
	 * The direction this turtle is facing in.
	 */
	private Direction2 direction;

	/**
	 * The pen that the turtle draws with.
	 */
	private Pen pen;

	/**
	 * Create a turtle at location {@code (0.5, 0.5)} with an direction of
	 * {@code 0.0} degrees and a pen color of {@code Color.BLACK}.
	 */
	public Turtle() {
		this.position = new Point2(0.5, 0.5);
		this.direction = new Direction2(0.0);
		this.pen = new Pen(Color.BLACK);

	}

	/**
	 * Create a turtle with the given starting position, direction, and pen. The
	 * starting position must be inside the square with corners
	 * {@code (0.0, 0.0)} and {@code (1.0, 1.0)}, otherwise an
	 * {@code IllegalArgumentException} will be thrown.
	 * 
	 * @param x
	 *            the x coordinate of the starting position of the turtle
	 * @param y
	 *            the y coordinate of the starting position of the turtle
	 * @param angle
	 *            the angle in degrees from the x axis that the turtle is facing
	 *            in
	 * @param c
	 *            the color of the pen that the turtle should draw with
	 * @throws IllegalArgumentException
	 *             if the starting position is not in the square with corners
	 *             (0.0, 0.0) and (1.0, 1.0)
	 */
	public Turtle(double x, double y, double angle, Color c) {

		if ((x >= 0.0 && x <= 1.0) && (y >= 0.0 && y <= 1.0)) {
			this.position = new Point2(x, y);
			this.pen = new Pen(c);
			double deg = angle;
			if (deg >= 360.0) {
				deg = deg % 360.0;
			} else if (deg < 0) {
				deg = deg % -360.0;
				deg = deg + 360;
			}
			this.direction = new Direction2(deg);

		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Walks the turtle forward by a given distance in the direction the turtle
	 * is currently facing. A line is drawn as the turtle moves to the new
	 * position using the current pen color.
	 * 
	 * @param distance
	 *            the distance to move
	 * @throws IllegalArgumentException
	 *             if distance is less than zero
	 */
	public void walk(double distance) {
		if (distance < 0) {
			throw new IllegalArgumentException();
		} else {
			Direction2 t1 = this.direction;
			double ang = t1.getAngle();
			double xval = distance * (Math.cos(Math.toRadians(ang)));
			double yval = distance * (Math.sin(Math.toRadians(ang)));

			Point2 t2 = this.position;
			double xpos = t2.getX() + xval;
			double ypos = t2.getY() + yval;
			this.position = new Point2(xpos, ypos);

		}

	}

	/**
	 * Turns the turtle to the left (counter clockwise) by an amount delta
	 * degrees.
	 * 
	 * @param delta
	 *            the angle to turn counter clockwise by
	 * 
	 * 			@pre. {@code delta >= 0.0}
	 */
	public void turnLeft(double delta) {
		if (delta < 0) {
			throw new IllegalArgumentException();
		}
		Direction2 t1 = this.direction;
		double deg = t1.getAngle();
		deg = deg + delta;
		if (deg >= 360.0) {
			deg = deg % 360;
		}
		if (deg < 0) {
			deg = deg % -360;
			deg = deg + 360;
		}
		this.direction = new Direction2(deg);

	}

	/**
	 * Turns the turtle to the right (clockwise) by an amount delta degrees.
	 * 
	 * @param delta
	 *            the angle to turn clockwise by @pre. {@code delta >= 0.0}
	 */
	public void turnRight(double delta) {
		if (delta < 0) {
			throw new IllegalArgumentException();
		}
		Direction2 t1 = this.direction;
		double deg = t1.getAngle();
		deg = deg - delta;
		if (deg >= 360.0) {
			deg = deg % 360;
		}
		if (deg < 0) {
			deg = deg % -360;
			deg = deg + 360;
		}
		this.direction = new Direction2(deg);
	}

	/**
	 * Turns the turtle so that its direction is equal to the given angle in
	 * degrees. Any value of delta can be used, but the turtle normalize its
	 * direction angle so that {@code 0.0 <= this.getAngle() < 360.0}.
	 * 
	 * @param angle
	 *            the new direction angle of the turtle
	 */
	public void turnTo(double angle) {

		double deg = angle;
		if (deg >= 360.0) {
			deg = deg % 360;
		}
		if (deg < 0) {
			deg = deg % -360;
			deg = deg + 360;
		}
		this.direction = new Direction2(deg);

	}

	/**
	 * Gets the pen belonging to this turtle.
	 * 
	 * @return the pen belonging to this turtle
	 */
	public Pen getPen() {
		Pen p = this.pen;
		return p;
	}

	/**
	 * Gets the current position of the turtle.
	 * 
	 * @return the current position of the turtle
	 */
	public Point2 getPosition() {
		Point2 pos = this.position;
		return pos;

	}

	/**
	 * Gets the direction that the turtle is facing in.
	 * 
	 * @return the direction that the turtle is facing in
	 */
	public Direction2 getDirection() {
		Direction2 deg = this.direction;
		return deg;

	}

	/**
	 * Returns a string representation of this turtle. The string representation
	 * is:
	 * 
	 * <ol>
	 * <li>the position of the turtle (as given by {@code Point2.toString}),
	 * followed by
	 * <li>a comma and a space, followed by
	 * <li>the direction of this turtle (as given by
	 * {@code Direction2.toString}), followed by
	 * <li>a space and a comma, followed by
	 * <li>the pen (as given by {@code Pen.toString})
	 * </ol>
	 * 
	 * @return a string representation of this turtle
	 */
	@Override
	public String toString() {
		String s = String.format("%s, %s degrees, %s", this.getPosition(), this.getDirection(), this.getPen());
		return s;
	}

	/**
	 * Returns a hash code for this turtle.
	 * 
	 * @return a hash code for this turtle
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.position, this.direction, this.pen);
	}

	/**
	 * Compares this turtle to the specified object. The result is true if and
	 * only if the argument is not null and is a {@code Turtle} object having a
	 * position, direction, and pen equal to this turtle's position, direction,
	 * and pen.
	 * 
	 * @param obj
	 *            the object to compare this Turtle against
	 * @return true if the given object represents a Turtle equivalent to this
	 *         object and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Turtle other = (Turtle) obj;
		if (direction == null) {
			if (other.direction != null) {
				return false;
			}
		} else if (!direction.equals(other.direction)) {
			return false;
		}
		if (pen == null) {
			if (other.pen != null) {
				return false;
			}
		} else if (!pen.equals(other.pen)) {
			return false;
		}
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		return true;
	}

}
