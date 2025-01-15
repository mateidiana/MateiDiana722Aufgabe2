package org.example.model;

public class Medicine extends Entity{
    private String name;
    private Float price;
    private String illness;

    public Medicine(int id, String name, Float price, String illness){
        super(id);
        this.name=name;
        this.price=price;
        this.illness=illness;
    }

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public Float getPrice(){return this.price;}
    public void setPrice(Float price){this.price=price;}

    public String getIllness(){return this.illness;}
    public void setIllness(String illness){this.illness=illness;}

}
