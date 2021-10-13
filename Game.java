import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world that pong exists on.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{

    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Ball(), getWidth()/2, getHeight()/2);

        addObject(new Paddle(1), 40, getHeight()/2);
        addObject(new Paddle(2), getWidth()-40, getHeight()/2);
        
        addObject(new Counter(1), 242, 30);
        addObject(new Counter(2), getWidth()-242, 30);
        
    }
}
