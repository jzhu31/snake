/*  Name: Jiawen Zhu and Yunhee Hyun
 *  PennKey: jiawenz and yuhy
 *  Recitation: 215 and 213
 *
 *  Compilation:  java SnakeGame.java
 *  Execution: java SnakeGame
 * 
 *  SnakeGame is a class that has objects Food, ScoreBoard, and Snake 
 *  interacting to create a version of a game that is a combination of 
 *  traditional Snake and slither.io. Before the game starts, instruction text 
 *  appears, and the game doesn't start until player presses the 'y' key. Using 
 *  keys i, j , k, and l, the player is able to mobilize snake to eat the money
 *  or internship. Game is over when the snake runs into any of the edges/walls 
 *  of the screen.
 */

public class SnakeGame {
    
    // fields 
    private static Snake snake;
    private static ScoreBoard scoreBoard;
    private static Food food; 
    private static final double headWidth = 0.05;
    private static boolean start = false;
    
    public static void main(String[] args) {
        // set canvas size 
        PennDraw.setCanvasSize(600, 600);
        
        // enable animation 
        PennDraw.enableAnimation(90);
        
        // fields 
        snake = new Snake();
        food = new Food();
        scoreBoard = new ScoreBoard();
        
        while (true) {
            // white background 
            PennDraw.clear(PennDraw.WHITE);
            
            // draw the items 
            snake.drawSnake();
            food.drawFood();
            scoreBoard.drawScoreBoard();
            
            // start the game
            if (!start) {
                PennDraw.setPenColor(PennDraw.RED);
                PennDraw.setFontSize(30);
                PennDraw.text(0.5, 0.6, "Welcome to Snake: Wharton!");
                PennDraw.text(0.5, 0.5, "Use JKLI as the arrow keys.");
                PennDraw.text(0.5, 0.4, "Press 'y' to start the game!");
                if (PennDraw.hasNextKeyTyped()) {
                    char startKey = PennDraw.nextKeyTyped();
                    if (startKey == 'y') {
                        start = true;
                    }   
                }
            }
            
            // controlling snake 
            if (PennDraw.hasNextKeyTyped()) {
                char key = PennDraw.nextKeyTyped();
                if (key == 'j') {
                    snake.moveLeft();
                } 
                else if (key == 'l') {
                    snake.moveRight();
                } 
                else if (key == 'i') {
                    snake.moveUp();
                } 
                else if (key == 'k') {
                    snake.moveDown();
                }
            }
            
            // update snake's position
            snake.update();
            
            // if snake eats food items 
            if (food.destroy(snake)) {
                // increment score
                scoreBoard.increaseConnects(food, snake);
                
                // update food's position 
                food.regenerate(snake);
                
                // update score board 
                scoreBoard.drawScoreBoard();
                
                // add a body to snake 
                snake.add();
            }
            
            // if snake runs into the walls, it dies
            for (int index = 0; index < snake.size(); index++) {
                Body b = snake.get(index);
                if (index == 0) {
                    if (b.getX() - headWidth <= b.getRadius() 
                            || b.getX() + headWidth >= 1 - b.getRadius()
                            || b.getY() - headWidth <= b.getRadius() 
                            || b.getY() + headWidth >= 1 - b.getRadius()) {
                        snake.die();
                        break;
                    }
                }
            }
            
            // if snake dies, game over
            if (snake.getDied()) {
                break;
            }
            
            PennDraw.advance();
        }
    }
}