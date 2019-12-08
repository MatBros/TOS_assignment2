////////////////////////////////////////////////////////////////////
// [MATTEO] [BROSOLO] [1170660]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class ImplementationTakeAwayBill implements TakeAwayBill{
   public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException{
      //inizializzazioni   
      double Tot=0.0, solidiTot=0.0, bevTot=0.0, paninoMenoCaro=10000.0;
            int nPanini=0, nItems=0;
            
            //scorrimento lista per salvare le cose che mi interessano
            for (MenuItem menuItem : itemsOrdered){
                nItems++;
                //conta totale bevande e fritti+panini
                if(menuItem.getType()==MenuItem.items.Bevanda) {
                    bevTot+=menuItem.getPrice();
                }else{
                    solidiTot+=menuItem.getPrice();
                }
                //conta i panini e segna il panino meno caro
                if(menuItem.getType() == MenuItem.items.Panino) {
                    nPanini++;
                    if(paninoMenoCaro > menuItem.getPrice()) {
                        paninoMenoCaro = menuItem.getPrice();
                    }
                }
            }
            
            //3) controllo che l'ordinazione sia di <=30 items 
            if(nItems>=30) throw new RestaurantBillException();
            
            Tot=bevTot+solidiTot;
            //1) sconto 50% al panino meno costoso con >5 panini acquistati
            if(nPanini>5) Tot-=(paninoMenoCaro/2); 
            
            //2) sconto 10% al totale con >50 euro di panini+fritti
            if(solidiTot>50.0) Tot-=Tot/10;
            
            //3) commissione per tot <10 euro e calcolo finale
            if(bevTot + solidiTot< 10.0) return Tot+0.5;    
            else return Tot;
     }
}
