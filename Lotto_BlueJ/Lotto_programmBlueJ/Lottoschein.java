public class Lottoschein
{
    private int[] tippzahlen = new int [6];
    public Lottoschein()
    {
        
    }
    
    public boolean pruefeTipp()
    {
        for (int k = 0; k < tippzahlen.length; k++) 
        {
            if(tippzahlen[k]<1 || tippzahlen[k]>49)
            {
               return false;
            }
            
            for (int j =k+1; j < tippzahlen.length; j++) 
            {
                    if (tippzahlen[k] == tippzahlen[j]) 
                    {
                        return false;
                    }
            }
         }
         return true;
    }
     
    public void quickTipp()
    {
         do
         {
            for(int i=0; i< tippzahlen.length;i++)
            {
                tippzahlen[i]=(int) (Math.random()*49+1);
            }
         }
         while(!pruefeTipp());     
    }
    
    public void uebernehmen(int z1,int z2, int z3, int z4, int z5,int z6 )
    {
        tippzahlen[0]=z1;
        tippzahlen[1]=z2;
        tippzahlen[2]=z3;
        tippzahlen[3]=z4;
        tippzahlen[4]=z5;
        tippzahlen[5]=z6;
    }
    
    public String zeigeTippzahlen()
    {
           return tippzahlen[0]+", "
           +tippzahlen[1]+", "
           +tippzahlen[2]+", "
           +tippzahlen[3]+", "
           +tippzahlen[4]+", "
           +tippzahlen[5];       
    }
    
    public int[] getTippzahlen()
    {
        return tippzahlen;
    }
}

    
