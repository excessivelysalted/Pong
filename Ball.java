import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ball that bounces from paddle to paddle.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{   private int dX = 4;
    private int dY = 1;
    public static int pointsLeft = 0;
    public static int pointsRight = 0;
    private long pauseTime;

    private int ballBounceDelayTime;         
    private int bounceDelayCount;

    public Ball()
    {
        ballBounceDelayTime = 30;
        bounceDelayCount = 0;
    }

    /**
     * Basic ball functions that happen upon running the scenario.
     */
    public void act()
    {//make a checklist
        checkIfSpawn();
        if(running())
        {
            move();
            checkForWin();
        }
        bounceOffPaddle();
        sideTouch();

        bounceDelayCount++;
    }

    /**
     * Sets the delay for the bounce on the paddle.
     */
    public void ballBounceDelayTime(int bounceTime)
    {
        ballBounceDelayTime = bounceTime;
    }

    /**
     * Checks if the game is running or if it is paused.
     * If Running running.
     * If paused !running.
     */
    public boolean running()
    {
        long time = System.currentTimeMillis(); //returns the time in millisecons
        return time > pauseTime;
    }

    /**
     * Sets the pause time for the delay that occurs after the ball hits the wall.
     */
    public void pause(int delay)
    {
        long time = System.currentTimeMillis(); //returns the time in millisecons
        pauseTime = time+delay;
    }

    /**
     * Rewriten 'move' method to allow the ball to move better.
     */
    public void move()
    {
        setLocation(getX()+dX,getY()+dY);
    }

    /**
     * Allows the ball to "bounce" off the paddle.
     */
    public void bounceOffPaddle()
    {   
        if(getY() <=0 || getY()>= getWorld().getHeight()-1)
        {
            dY = -dY;
        }
        if(bounceDelayCount >= ballBounceDelayTime)
        {
            if(isTouching(Paddle.class))
            {
                dX = -dX;
                dY = dY;
                paddleHitSound();
                bounceDelayCount = 0;
            }
        }
    }

    /**
     * Detects whether or not the ball is touching the left or right side of the world. 
     * Counts the amount of times it does. 
     * Sends the ball back to the middle.
     */
    public void sideTouch()
    {
        if(getX() <= 0 || getY()>= getWorld().getWidth()-1 )//leftside
        {
            pointsLeft++;//this tallies up the amount of times the ball hits the wall
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);//when the ball touches the left or right wall it will go back to the center
            wallHitSound();
            pause(1000);
        }
        if(getX() >= getWorld().getWidth()-1 || getY()>= getWorld().getWidth()-1 )//rightside
        {
            pointsRight++;//this tallies up the amount of times the ball hits the wall
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);//when the ball touches the left or right wall it will go back to the center
            wallHitSound();
            pause(1000);
        }
    }

    /**
     * Checks if the ball had spawned with the space key.
     */
    public void checkIfSpawn()
    { 
        if(Greenfoot.isKeyDown("space"))
        {
            pause(1500);
            pointsLeft = 0;
            pointsRight = 0;
        }
    }

    /**
     * Checks the points to see if it's a win or not.
     */
    public void checkForWin()
    {
        if(pointsLeft >= 8 || pointsRight >= 8)
        {
            getWorld().addObject(new Gameover(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            gameoverSound();
            Greenfoot.stop();
        }
    }

    /*
     * Sounds
     */
    /**
     * Sets sound and volume for when the ball hits the paddle.
     */
    public void paddleHitSound()
    {
        GreenfootSound sound = new GreenfootSound("button-16.wav");
        sound.setVolume(50);
        sound.play();
    }

    /**
     * Sets sound and volume for when the ball hits the side of the world.
     */
    public void wallHitSound()
    {
        GreenfootSound  sound = new GreenfootSound("failurealert.wav");
        sound.setVolume(50);
        sound.play();
    }

    /**
     * Sets sound and volume for when the ball hits the side of the world.
     */
    public void gameoverSound()
    {
        GreenfootSound  sound = new GreenfootSound("gameoversoundeffect.wav");
        sound.setVolume(50);
        sound.play();
    }
}
