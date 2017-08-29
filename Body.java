/*  Name: Jiawen Zhu and Yunhee Hyun
 *  PennKey: jiawenz and yuhy
 *  Recitation: 215 and 213
 *
 *  Compilation:  java Body.java
 * 
 *  A Snake is composed of multiple Bodies. Each Body has an x and y, which are
 *  the coordinates for the center of the Body. All Bodies have the same radius, 
 *  0.03.
 *  
 *  A Body has getter functions for all of its three field variables. It also 
 *  has two set functions: one for the x coordinate and one for the y 
 *  coordinate. These two functions replace a Body's x and y with a given 
 *  new x and a give. new y. 
 */

public class Body {
    
    // fields
    private double x;
    private double y;
    private static final double radius = 0.03;
    
    /**
     * Input: an x and y coordinate
     * Output: a Body with the given x and y coordinates as its center
     * Description: a constructor that creates a Body
     */
    public Body(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Input: none
     * Output: the value of the Body's current x coordinate as a double
     * Description: a getter function for the Body's x
     */
    public double getX() {
        return x;
    }
    
    /**
     * Input: none
     * Output: the value of the Body's current y coordinate as a double
     * Description: a getter function for the Body's y
     */
    public double getY() {
        return y;
    }
    
    /**
     * Input: none
     * Output: the value of the Body's radius as a double
     * Description: a getter function for the Body's radius
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Input: a new x coordinate
     * Output: a void function that sets the Body's x to the given newX
     * Description: replaces the Body's x coordinate with newX
     */
    public void setX(double newX) {
        x = newX;
    }
    
    /**
     * Input: a new y coordinate
     * Output: a void function that sets the Body's y to the given newY
     * Description: replaces the Body's y coordinate with newY
     */
    public void setY(double newY) {
        y = newY;
    }
}