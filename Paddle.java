import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Moves up and down to stop the ball from touching the wall.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    private int dX = 0;
    private int dY = 4;
    int paddleType;//creates the paddle type integer
    /**
     * Allows for the paddle to have separate instances.
     */
    public Paddle(int paddleType)
    {
        this.paddleType = paddleType;//this allows for the instances of the paddle to be controlled separately
    }

    /**
     * Just paddle things.
     */
    public void act()
    {
        checkKeys();
    }

    /**
     * Sees if the keys pressed are "w", "s", "up", or "down" and moves the objects appropriately.
     */
    public void checkKeys()
    {
        if(paddleType == 1)//paddle type instance 1
        {
            if(Greenfoot.isKeyDown("w"))
            {
                setLocation(getX(),getY()-dY);
            }

            if(Greenfoot.isKeyDown("s"))
            {
                setLocation(getX(),getY()+dY);
            }
        } 
        if (paddleType == 2)//paddle type instance 2
        {
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY()-dY); 
            }
            if(Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(), getY()+dY);
            }
        }
    }

}
