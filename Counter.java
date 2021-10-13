import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the amount of points a certain side has during the game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int counterType;
    public Counter(int counterType)
    {    
        this.counterType = counterType;
    }

    /**
     * What causes the counter to count.
     */

    public void act()
    {
        counterImageDisplay1();
        counterImageDisplay2();
    }
    
    public void counterImageDisplay1()
    {
        if(counterType == 1)
        {
            if(Ball.pointsRight == 1)
            {
                setImage("Score1.png");
            }
            if(Ball.pointsRight == 2)
            {
                setImage("Score2.png");
            }
            if(Ball.pointsRight == 3)
            {
                setImage("Score3.png");
            }
            if(Ball.pointsRight == 4)
            {
                setImage("Score4.png");
            }
            if(Ball.pointsRight == 5)
            {
                setImage("Score5.png");
            }
            if(Ball.pointsRight == 6)
            {
                setImage("Score6.png");
            }
            if(Ball.pointsRight == 7)
            {
                setImage("Score7.png");
            }
            if(Ball.pointsRight == 8)
            {
                setImage("Score8.png");
            }
        }
    }
    
    public void counterImageDisplay2()
    {
        if(counterType == 2)
        {
            if(Ball.pointsLeft == 1)
            {
                setImage("Score1.png");
            }
            if(Ball.pointsLeft == 2)
            {
                setImage("Score2.png");
            }
            if(Ball.pointsLeft == 3)
            {
                setImage("Score3.png");
            }
            if(Ball.pointsLeft == 4)
            {
                setImage("Score4.png");
            }
            if(Ball.pointsLeft == 5)
            {
                setImage("Score5.png");
            }
            if(Ball.pointsLeft == 6)
            {
                setImage("Score6.png");
            }
            if(Ball.pointsLeft == 7)
            {
                setImage("Score7.png");
            }
            if(Ball.pointsLeft == 8)
            {
                setImage("Score8.png");
            }
        }
    }
}
