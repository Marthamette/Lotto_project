
public class Lottomaschine
{
    private int[] ziehungszahlen = new int [6];
    public Lottomaschine()
    {
    }
    
    public void zieheZahlen()
    {
        int randomNum;
         for (int i = 0; i < 6; i++) 
         {
             randomNum = (int) (Math.random() *49+1); // Random number created here.
             for (int x = 0; x < i; x++) 
             {
                if (ziehungszahlen[x] == randomNum) // Here, code checks if same random number generated before.
                {
                    randomNum = (int) (Math.random() * 49+1);// If random number is same, another number generated.
                    x = -1; // restart the loop
                }
             }
            ziehungszahlen[i] = randomNum;
         }
    }
    
    public String zeigeZiehungszahlen()
    {
       return ziehungszahlen[0]+", "
           +ziehungszahlen[1]+", "
           +ziehungszahlen[2]+", "
           +ziehungszahlen[3]+", "
           +ziehungszahlen[4]+", "
           +ziehungszahlen[5];
    }
    
    public int[] getZiehungszahlen()
    {
        return ziehungszahlen;
    }
}
