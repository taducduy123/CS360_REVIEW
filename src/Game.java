import java.util.LinkedList;
import java.util.List;

public class Game 
{
    private final int maxNumplayers = 4;
    private List<Player> players = new LinkedList<>();
    private List<Die> dice = new LinkedList<>();
    private Referee referee;

    private boolean stop = false;
//-------------------------------------------------------------
    //Constructor
    public Game()
    {
        players.add(new AIPlayer("AI1"));
        players.add(new AIPlayer("AI2"));
        players.add(new AIPlayer("AI3"));
        players.add(new AIPlayer("AI4"));

        dice.add(new Die(0.16, 0.16, 0.2, 0.16, 0.16, 0.16));
        dice.add(new Die(0.16, 0.16, 0.16, 0.2, 0.16, 0.16));
        dice.add(new Die(0.16, 0.16, 0.16, 0.16, 0.2, 0.16));
        dice.add(new Die(0.16, 0.16, 0.16, 0.16, 0.16, 0.2));
        
        referee = new Referee();
    }

    public void addPlayer(Player p)
    {
        this.players.removeFirst();
        this.players.add(p);
    }


    public void start()
    {
        int index = 0;
        while(!stop)
        {
            this.players.get(index).doWork(this);
            this.referee.calculateScoreFor(this.players.get(index));
            this.players.get(index).showState();
            this.stop = referee.checkWinFor(this.players.get(index));
            if(stop)
            {
                this.players.get(index).showExpression();
            }
            else
            {
                this.referee.suffleDice(this);
                index = (index + 1) % maxNumplayers;
            }
            
        }
    }



    public void showState()
    {
        for(int i = 0; i < maxNumplayers; i++)
        {
            System.out.println("Player #" + i + 1+": ");
            this.players.get(i).showState();
            System.out.println("--------------------------------------------------------");
        }
    }




    public List<Player> getPlayers()
    {return this.players;}
    public List<Die> getDice()
    {return this.dice;}
}
