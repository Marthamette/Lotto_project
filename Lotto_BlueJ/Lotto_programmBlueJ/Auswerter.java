
public class Auswerter
{
  private Lottomaschine aLottomaschine;
  private Lottoschein aLottoschein;
  
  public Auswerter(Lottoschein pLottoschein, Lottomaschine pLottomaschine)
  {
     aLottoschein = pLottoschein;
     aLottomaschine = pLottomaschine;
  }
    
   public int bestimmeGewinnrang()
  {
    int rang = 0;
    int anzahlRichtige = bestimmeAnzahlRichtige();
    
    switch (anzahlRichtige)
    {
      case 0:
      case 1:
      case 2: rang=0; break;
      case 3: rang = 1; break;
      case 4: rang = 2; break;
      case 5: rang = 3; break; 
      case 6: rang = 4; break;
      default: rang = 0;
    }
    return rang;
  }
    
  private int bestimmeAnzahlRichtige()
  {
        int counter=0;
        for(int i=0; i<6;i++)
        {
            for(int j=0; j<6; j++)
            {
                if(aLottomaschine.getZiehungszahlen()[i]==aLottoschein.getTippzahlen()[j])
                {
                    counter++;
                }
            }
        }
        return counter;
  }
    
}
