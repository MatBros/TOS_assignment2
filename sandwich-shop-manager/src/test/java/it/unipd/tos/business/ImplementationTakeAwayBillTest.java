package it.unipd.tos.business;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.ImplementationTakeAwayBill;
import it.unipd.tos.business.exception.RestaurantBillException;


import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class ImplementationTakeAwayBillTest {
	ImplementationTakeAwayBill ordine1= new ImplementationTakeAwayBill();
	ImplementationTakeAwayBill ordine2= new ImplementationTakeAwayBill();
	ImplementationTakeAwayBill ordine3= new ImplementationTakeAwayBill();
	ImplementationTakeAwayBill ordine4= new ImplementationTakeAwayBill();
	ImplementationTakeAwayBill ordine5= new ImplementationTakeAwayBill();
	ImplementationTakeAwayBill ordine6= new ImplementationTakeAwayBill();
	//creazione liste per test successivi
	ArrayList<MenuItem> listaOrdineNormale= new ArrayList<MenuItem>();{
		listaOrdineNormale.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineNormale.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineNormale.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
	}
	ArrayList<MenuItem> listaOrdineSconto5p= new ArrayList<MenuItem>();{ 
		listaOrdineSconto5p.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineSconto5p.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineSconto5p.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineSconto5p.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineSconto5p.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineSconto5p.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
	}
	ArrayList<MenuItem> listaOrdineSconto50e= new ArrayList<MenuItem>();{
		listaOrdineSconto50e.add(new MenuItem(MenuItem.items.Panino,"Placcato d'Oro",50.0));
		listaOrdineSconto50e.add(new MenuItem(MenuItem.items.Fritto,"Patatine",3.50));
	}
	ArrayList<MenuItem> listaOrdineErrore30= new ArrayList<MenuItem>();{
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Inverno",3.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Autunno",4.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
		listaOrdineErrore30.add(new MenuItem(MenuItem.items.Panino,"Estate",2.0));
	}
	ArrayList<MenuItem> listaOrdineCommissione= new ArrayList<MenuItem>();{
		listaOrdineCommissione.add(new MenuItem(MenuItem.items.Panino,"Primavera",1.0));
	}
	
	//tests
	@Test
	public void TakeAwayBill_NormalOrder_RightPrice() throws RestaurantBillException{
		assertEquals(12.0,ordine1.getOrderPrice(listaOrdineNormale),0.0);
	}
	@Test
	public void TakeAwayBill_Plus5PaniniOrder_LessExpensivePaninoHalfPrice() throws RestaurantBillException{
		assertEquals(12.5,ordine2.getOrderPrice(listaOrdineSconto5p),0.0);
	}
	@Test
	public void TakeAwayBill_Plus50EuroTotOrderNoDrinks_TotMinusOneTenthOfTot() throws RestaurantBillException{
		assertEquals(48.15,ordine3.getOrderPrice(listaOrdineSconto50e),0.0);
	}
	@Test(expected=RestaurantBillException.class)
	public void TakeAwayBill_Plus30ItemsOrder_Exception() throws RestaurantBillException{
		ordine4.getOrderPrice(listaOrdineErrore30);
	}
	@Test
	public void TakeAwayBill_Less10EuroOrder_TotPlus50cents() throws RestaurantBillException{
		assertEquals(1.50,ordine5.getOrderPrice(listaOrdineCommissione),0.0);

	}
}
