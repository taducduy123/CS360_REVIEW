import java.util.Scanner;

public class Player 
{
    protected String name;
    protected int currentScore;
    protected int lastRoll_Value;

    protected static Scanner keyboard = new Scanner(System.in);
//--------------------------------------
    //Contructor 
    public Player(String name)
    {
        this.name = name;
    }

    public void roll(Die die)
    {
        this.lastRoll_Value = die.roll();
    }


    public void showExpression()
    {
        System.out.println("Congratulation!" + this.name + " wins the game!");
    }


    public void doWork(Game game)
    {
        int choice;
        System.out.println("------------ It is the turn of player " + this.name + "----------------");
        System.out.println("There are 4 dice. Enter a number betweent 1 and 4 to roll a die.");
        System.out.println("Enter your choice: ");
        choice = keyboard.nextInt();

        this.roll(game.getDice().get(choice - 1));
        System.out.println("\n****************************************************************\n");
    }



    public void showState()
    {
        System.out.println("Player " + this.getName());
        System.out.println("Last Rolling Score: " + this.lastRoll_Value);
        System.out.println("Current Score: " + this.currentScore);
    }

    public void setName(String n)
    {this.name = n;}
    public void setCurrentScore(int score)
    {this.currentScore = score;}

    public String getName()
    {return this.name;}
    public int getCurrentScore()
    {return this.currentScore;}
    public int getLastRollValue()
    {return this.lastRoll_Value;}
}
