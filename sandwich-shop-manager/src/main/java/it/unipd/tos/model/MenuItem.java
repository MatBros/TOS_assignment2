package it.unipd.tos.model;

public class MenuItem {
    public enum items {Panino, Fritto, Bevanda}
    
    private items itemType;
    private String name;
    private double price;

    public MenuItem(items tipoIt, String nome, double prezzo){
        this.itemType = tipoIt;
        this.name = nome;
        this.price = prezzo;
    }

    public items getType(){
        return itemType;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}
