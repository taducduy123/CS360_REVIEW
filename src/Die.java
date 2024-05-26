

import java.util.Random;

public class Die 
{
    private final int side = 6;
    private int value;
    double rate1, rate2, rate3, rate4, rate5, rate6;
    

//--------------------------------

    //Constructor
    public Die(double r1, double r2, double r3, double r4, double r5, double r6)
    {
       this.value = 0;
       this.rate1 = r1;
       this.rate2 = r2;
       this.rate3 = r3;
       this.rate4 = r4;
       this.rate5 = r5;
       this.rate6 = r6;
    }

    public int roll()
    {
        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;

        double[] endPoints = new double[7];
        endPoints[0] = 1.0;
        endPoints[1] = endPoints[0] + 100 * rate1;     // 21
        endPoints[2] = endPoints[1] + 100 * rate2;     //37
        endPoints[3] = endPoints[2] + 100 * rate3;     //53
        endPoints[4] = endPoints[3] + 100 * rate4;     //69
        endPoints[5] = endPoints[4] + 100 * rate5;     //85
        endPoints[6] = endPoints[5] + 100 * rate6;     //101

        if(endPoints[0] <= ranNum && ranNum < endPoints[1])
            this.value = 1;
        else if(endPoints[1] <= ranNum && ranNum < endPoints[2])
            this.value = 2;
        else if(endPoints[2] <= ranNum && ranNum < endPoints[3])
            this.value = 3;
        else if(endPoints[3] <= ranNum && ranNum < endPoints[4])
            this.value = 4;
        else if(endPoints[4] <= ranNum && ranNum < endPoints[5])
            this.value = 5;
        else if(endPoints[5] <= ranNum && ranNum < endPoints[6])
            this.value = 6;

        return this.value;
    }
    
    public int getSide()
    {return this.side;}
    public int getValue()
    {return this.value;}

}
