# Wharton Snake

This project is a variation of the classic game of snakes and slither.io. 
The objective is to eat as many money/internships as possible. Rather than
moving along a grid, the snake's body follows its head instead. In this 
version, the snake only dies when it runs into the walls, and not when it 
runs into itself. 

Our project's design is definitely object-oriented. Class decomposition was 
established by creating different classes for different objects we needed. 
The different objects we created were Food, ScoreBoard, Snake, and Body, all 
of which were called on in SnakeGame, which is the actual game itself. The names
are pretty self-explanatory, except for Body. Body was an object we created 
that stored x and y coordinates. Body was the unit for both Food and Snake. 
Snake is a LinkedList of Bodies. The head of the Snake is a Wharton logo. Food 
is one unit of Body. Food has two forms, which are Goldman Sachs internship and 
a 100 dollar bill. Food and Snake don't really interact until two methods in
Food, which is generate and destroy. The generate method takes in Snake as a 
parameter such that the coordinated of Food will never be any of the coordinates 
of the Snake's bodies. The destroy method takes in Snake as a parameter such 
that it returns a boolean if snake's head and food are equal to each other, 
meaning that their x and y coordinates are the same, plus or minus a certain 
margin of error. ScoreBoard, besides for its draw method, only has one method 
that has both Food and Snake as its parameters. As its name implies, the 
ScoreBoard increments and updates the scores, depending on whether the snake 
eats money or an internship. 

    
We attempted to make our project as computationally efficient as possible. For 
example, instead of creating an array to store all the different coordinates 
of the snake's bodies, which would have taken up a lot of space, we used 
recursion and a for loop instead. This allowed us to figure out what the 
coordinates for the food should be, such that if the food's currently generated 
coordinates matched any of the snake's bodies' coordinates, then it would just 
generate new ones. By doing so, we saved space and made our game more efficient. 


The SnakeGame is the actual game, while all the other files are objects 
necessary to run the game. PennDraw is used to visually portray the 
objects. The goal is to get as many points as possible. The game ends when 
you die, which is when the snake runs into any of the borders/edges of the 
screen. You can run the game with 'java SnakeGame'. The screen then shows
instructions on how to start/play the game (use 'jkli' rather than the arrow 
keys, and you click 'y' to start the game). If you eat a one hundred dollar 
bill, you get 1 LinkedIn connection. If you score a Goldman Sachs internship, 
you get 3 LinkedIn connections. The game stops (you won't be able to move) 
when you run into any of the edges/walls. 
