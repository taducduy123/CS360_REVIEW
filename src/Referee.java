import java.util.Collections;

public class Referee 
{
    private final int ceilingScore = 18;
//-------------------------------------------

    public Referee()
    {

    }

    public void calculateScoreFor(Player player)
    {
        if(player.getCurrentScore() + player.getLastRollValue() > 18)
        {
            player.setCurrentScore(0);
        }
        else
        {
            player.setCurrentScore(player.getCurrentScore() + player.getLastRollValue());
        }
    }

    public void suffleDice(Game game)
    {
        Collections.shuffle(game.getDice());
    }


    public boolean checkWinFor(Player player)
    {
        if(player.getCurrentScore() == ceilingScore)
            return true;
        return false;
    }

    public void announceResultFor(Player player)
    {
        System.out.println(player.getName() + " rolled a die and the die generate " + player.getLastRollValue() + ". The current score of player is " + player.getCurrentScore());
    }
}
