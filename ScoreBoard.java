/*  Name: Jiawen Zhu and Yunhee Hyun
 *  PennKey: jiawenz and yuhy
 *  Recitation: 215 and 213
 *
 *  Compilation:  java ScoreBoard.java
 * 
 *  ScoreBoard is an object that keeps track of the number of LinkedIn connects.
 *  The SnakeGame increases its connects when a Snake eats the Food. ScoreBoard 
 *  has with 3 methods. One method is for increasing the number of connects by 
 *  a corresponding increment depending on whether the Snake ate an internship 
 *  or money. Another method is to draw the actual board. The third is to 
 *  return the number of connects.
 */

public class ScoreBoard {
    
    // fields
    private int connects;
    
    /**
     * Input: none
     * Output: a ScoreBoard object
     * Description: a constructor that initializes connects to 0
     */
    public ScoreBoard() {
        connects = 0;
    }
    
    /**
     * Input: a Food and a Snake
     * Output: a void function that increases the number of LinkedIn connects
     * Description: increases the number of connects
     */
    public void increaseConnects(Food food, Snake snake) {
        
        // for internship
        if (food.destroy(snake) && food.getInternship()) {
            connects += 3;
        }
        
        // for food 
        else if (food.destroy(snake) && food.getMoney()) {
            connects++;
        }
    }
    
    /**
     * Input: none
     * Output: a void function that draws the ScoreBoard
     * Description: displays a LinkedIn image and the total connects 
     */
    public void drawScoreBoard() {
        PennDraw.picture(0.45, 0.95, "connects.png", 135, 0);
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.setFontSize(25);
        PennDraw.text(0.6, 0.95, " " + connects);
    }
    
    /**
     * Input: none
     * Output: the number of connects
     * Description: returns the number of connects
     */
    public int getConnects() {
        return connects;
    }
}