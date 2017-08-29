/*  Name: Jiawen Zhu and Yunhee Hyun
 *  PennKey: jiawenz and yuhy
 *  Recitation: 215 and 213
 *
 *  Compilation:  java Snake.java
 * 
 *  Snake is an object, specifically a LinkedList of Body, an object that stores 
 *  x and y coordinates. Snake's methods allow it to be drawn, grow in size by 
 *  adding on bodies to the end of the LinkedList, return the body at a certain 
 *  index, return its size, update each individual body's coordinates, update 
 *  its velocities which will be used so it can move in different directions, 
 *  and die.
 */

public class Snake {
    
    // fields
    private double vx = 0.0; 
    private double vy = 0.0; 
    private LinkedList<Body> snake;
    private Body lastBody;
    private boolean died = false;
    
    /**
     * Input: none
     * Output: a Snake object with a LinkedList of Body and a head Body
     * Description: a constructor that creates a Snake that is a LinkedList of
     * Body objects, creates the head Body, and adds the head to the Snake
     */
    public Snake() {
        snake = new LinkedList<Body>();
        Body head = new Body(0.75, 0.25);
        snake.add(head);
    }
    
    /**
     * Input: none
     * Output: none
     * Description: draws the snake such that the head is the Wharton logo 
     */
    public void drawSnake() {  
        for (int index = 0; index < snake.size(); index++) {
            Body b = snake.get(index);
            if (index == 0) {
                // just for the head
                PennDraw.picture(b.getX(), b.getY(), "wharton.png", 100, 0);
            }
            else {
                PennDraw.setPenColor(PennDraw.BLUE);
                PennDraw.filledCircle(b.getX(), b.getY(), b.getRadius());
            }
        }
    }
    
    /**
     * Input: none
     * Output: a void function that adds a Body to the end of Snake
     * Description: adds a Body to the LinkedList Snake 
     */
    public void add() {
        double newX = 0.0;
        double newY = 0.0;
        
        // if it's the head 
        if (snake.size() == 1) {
            
            // equation is new x coordinate is the current one minus the 
            // product of the direction (which is why we multiple 250 to make 
            // the velocities either 0, 1, or -1) and the diameter 
            newX = snake.get(0).getX() - (250 * vx * 
                                          2 * snake.get(0).getRadius());
            newY = snake.get(0).getY() - (250 * vy * 
                                          2 * snake.get(0).getRadius());
        } 
        else {
            lastBody = snake.get(snake.size() - 1);
            Body secondLastBody = snake.get(snake.size() - 2);
            
            // distance between the preceding body + current coordinates
            newX = lastBody.getX() - secondLastBody.getX();
            newY = lastBody.getY() - secondLastBody.getY();
            newX += lastBody.getX();
            newY += lastBody.getY();
        }
        
        // creates the new body with the new coordinates 
        Body newBody = new Body(newX, newY);
        
        // calls on the LinkedList method of add 
        snake.add(newBody);
    }
    
    /**
     * Input: int index
     * Output: Body
     * Description: returns Snake's Body at the given index
     */
    public Body get(int index) {
        return snake.get(index);
    }
    
    /**
     * Input: none
     * Output: the size of the snake as an int
     * Description: returns snake's size
     */
    public int size() {
        return snake.size();
    }
    
    /**
     * Input: none
     * Output: a void function that updates each Body's coordinates
     * Description: updates Snake's individual Body's coordinates 
     */
    public void update() {
        for (int index = 0; index < snake.size(); index++) {
            Body body = snake.get(index);
            
            // for head 
            if (index == 0) {
                body.setX(body.getX() + vx);
                body.setY(body.getY() + vy);
            } 
            
            // for the rest 
            else {
                body.setX(body.getX() + 0.08 * ((snake.get(index - 1).getX()) - 
                                                body.getX()));
                body.setY(body.getY() + 0.08 * ((snake.get(index - 1).getY()) - 
                                                body.getY()));
            }
        }
    }
    
    /**
     * Input: none
     * Output: a void function that changes vx to a negative
     * Description: updates velocities to move in the left direction
     */
    public void moveLeft() {
        vx = -0.004; // move left
        vy = 0;
    }
    
    /**
     * Input: none
     * Output: a void function that changes vx to a positive
     * Description: updates velocities to move in the right direction
     */
    public void moveRight() {
        vx = 0.004; // move right
        vy = 0;
    }
    
    /**
     * Input: none
     * Output: a void function that changes vy to a positive
     * Description: updates velocity to move in the up direction
     */
    public void moveUp() {
        vy = 0.004; // move up
        vx = 0;
    }
    
    /**
     * Input: none
     * Output: a void function that changes vy to a negative
     * Description: updates velocities to move in the down direction
     */
    public void moveDown() {
        vy = -0.004; // move down
        vx = 0;
    }
    
    /**
     * Input: none
     * Output: a void function that stops the Snake's movement
     * Description: updates velocities such that the Snake stops and changes
     * boolean died to true
     */
    public void die() {
        vx = 0;
        vy = 0;
        died = true;
    }
    
    /**
     * Input: none
     * Output: true if the Snake died, false otherwise
     * Description: returns boolean died
     */
    public boolean getDied() {
        return died;
    }
}