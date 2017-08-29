/*  Name: Jiawen Zhu and Yunhee Hyun
 *  PennKey: jiawenz and yuhy
 *  Recitation: 215 and 213
 *
 *  Compilation:  java Food.java
 * 
 *  The SnakeGame has one Food object at all times. Food is what the Snake eats
 *  in order to increase the number of LinkedIn connects. Food can either be
 *  money or a Goldman Sachs internship. There is a 20% probability that Food 
 *  is the internship. A Food is a type Body, and it keeps track of whether or 
 *  not it is currently money or an internship with two boolean variables. Food 
 *  also has a final foodWidth that is used for regenerating a new Food object 
 *  that is within the screen.
 * 
 *  Food is drawn, destroyed, regenerated. The current Food object is destroyed 
 *  when the Snake eats it, and then the Food objected is regenerated at a 
 *  different random location a different probability of whether or not it is
 *  money of an internship. Food also has three getters functions.
 */

public class Food {
    
    // fields
    private Body food;
    private boolean money;
    private boolean internship;
    private static final double foodWidth = 0.05;  
    
    /**
     * Input: none
     * Output: a Food object that is randomly either an internship or money
     * and has a Body with a preset location
     * Description: a constructor that creates a Food object 
     */
    public Food() {
        double probability = Math.random();
        if (probability < 0.2) {
            internship = true;
            money = false;
        }
        else {
            internship = false;
            money = true;
        }
        food = new Body(0.25, 0.75);
    }
    
    /**
     * Input: none
     * Output: a void function that draws the food as either a Goldman Sachs 
     * picture or a Ben Franklin $100 bill as money
     * Description: draws the correct type of Food at Food's current location
     */
    public void drawFood() {
        if (internship) {
            PennDraw.picture(food.getX(), food.getY(), "goldman.png", 60, 0);
        }
        else if (money) {
            PennDraw.picture(food.getX(), food.getY(), "money.jpeg", 100, 50);
        }
    }
    
    /**
     * Input: none
     * Output: the Body object of the food
     * Description: a getter function for the Food's food as a Body object
     */
    public Body getFood() {
        return food;
    }
    
    /**
     * Input: none
     * Output: the value of money as a boolean
     * Description: a getter function for the value of money
     */
    public boolean getMoney() {
        return money;
    }
    
    /**
     * Input: none
     * Output: the value of internship as a boolean
     * Description: a getter function the value of internship
     */
    public boolean getInternship() {
        return internship;
    }
    
    /**
     * Input: a Body that is the head of the snake
     * Output: true if the Food and the Snake's head are at the same location
     * (with some margin of error), and false otherwise
     * Description: a helper function for destroy(snake) that overwrites Java's
     * default equals method
     */
    public boolean equals(Body head) {
        double error = 0.05;
        double foodX = this.food.getX();
        double foodY = this.food.getY();
        double headX = head.getX();
        double headY = head.getY();
        if ((headX <= foodX + error) && (headX >= foodX - error) && 
            (headY <= foodY + error) && (headY >= foodY - error)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Input: a Snake
     * Output: a boolean that is true when the Snake eats the Food and false 
     * otherwise
     * Description: determines if the given Snake has eaten the Food
     */
    public boolean destroy(Snake snake) {
        Body head = snake.get(0);
        if (equals(head)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Input: a Snake
     * Output: a void function that regenerates a new Food object
     * Description: generates a new Food object for the given Snake if the
     * Snake has eaten the current Food object
     */
    public void regenerate(Snake snake) {
        if (destroy(snake)) {
            generate(snake);
        }
    }
    
    /**
     * Input: none
     * Output: a void function that generates a new probability to make the new
     * instance of Food either an internship or money
     * Description: a helper function for generate(snake) that determines
     * if the new Food will be an internship or money
     */
    public void generateNewProbability() {
        double probability = Math.random();
        if (probability < 0.2) {
            internship = true;
            money = false;
        }
        else {
            internship = false;
            money = true;
        }
    }
    
    /**
     * Input: none
     * Output: a void function that generates a location
     * Description: a helper function for generate(snake) that determines
     * new x and y coordinates for the new instance of Food
     */
    public void generateNewLocation() {
        double newX = Math.random();
        double newY = Math.random();
        
        // if newX or newY makes the Food go off the screen, 
        // run generateNewLocation() again
        if (newX - foodWidth <= food.getRadius() 
                || newX + foodWidth >= 1 - food.getRadius()
                || newY - foodWidth <= food.getRadius() 
                || newY + foodWidth >= 1 - food.getRadius()) {
            generateNewLocation();
        }
        
        // set Food's x and y to the newX and new Y
        else {
            this.food.setX(newX);
            this.food.setY(newY);
        }
        
    }
    
    /**
     * Input: a Snake
     * Output: a void function that ensures the new location for Food 
     * does not overlap with any part of the given Snake
     * Description: a helper function for regenerate() that makes sure the 
     * new location is not where any part of the Snake currently is
     */
    public void generate(Snake snake) {
        generateNewProbability();
        generateNewLocation();
        
        // make sure the new location is not where the snake currently is
        for (int index = 0; index < snake.size(); index++) {
            Body curr = snake.get(index);
            
            // if the new location overlaps with any part of the Snake, 
            // generate again
            if (equals(curr)) {
                generate(snake);
            }
        }
    }
}