package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Entity{
    private String name;
    private int age;
    private String diagnosis;
    private List<Medicine> medicines;

    public Patient(int id, String name,int age, String diagnosis){
        super(id);
        this.name=name;
        this.age=age;
        this.diagnosis=diagnosis;
        this.medicines=new ArrayList<>();
    }

    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}

    public String getDiagnosis(){return this.diagnosis;}
    public void setDiagnosis(String diagnosis){this.diagnosis=diagnosis;}


    public int getAge(){return this.age;}
    public void setAge(int age){this.age=age;}
    public List<Medicine> getMedicines(){return this.medicines;}
    public void setMedicines(List<Medicine> products){this.medicines=products;}
}
