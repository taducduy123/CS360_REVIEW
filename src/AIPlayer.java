import java.util.Random;

public class AIPlayer extends Player
{

//----------------------------------------------------
    public AIPlayer(String name) 
    {
        super(name);
    }

    @Override
    public void showExpression()
    {
        System.out.println(this.name + " wins the game!");
    }
    

    @Override
    public void doWork(Game game)
    {
        Random random = new Random();
        int choice = random.nextInt(4);

        this.roll(game.getDice().get(choice));
    }
}
