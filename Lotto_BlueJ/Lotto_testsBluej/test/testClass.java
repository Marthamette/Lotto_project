
public class testClass
{
    public testClass()
    {
    }
          int[] tippzahlen = new int [6];
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
        
        do{
            for(int i=0; i< tippzahlen.length;i++)
            {
                tippzahlen[i]=(int) (Math.random()*49+1);
                System.out.println("array["+i+"] "+tippzahlen[i]);
         }
            }
         while(!pruefeTipp());   
    } 
        int[] ziehungszahlen = new int [6];
        public void zieheZahlen()
    {
         
           ziehungszahlen[5] = (int) (Math.random() *50); // Random number created here.
           System.out.println(ziehungszahlen[0]+", "
           +ziehungszahlen[1]+", "
           +ziehungszahlen[2]+", "
           +ziehungszahlen[3]+", "
           +ziehungszahlen[4]+", "
           +ziehungszahlen[5]);  
         
    }
    public void outpu()
    {
        System.out.println(ziehungszahlen[0]+", "
           +ziehungszahlen[1]+", "
           +ziehungszahlen[2]+", "
           +ziehungszahlen[3]+", "
           +ziehungszahlen[4]+", "
           +ziehungszahlen[5]);
    }
    }

