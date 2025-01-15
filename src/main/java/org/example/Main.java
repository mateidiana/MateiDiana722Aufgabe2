package org.example;
import org.example.model.*;
import org.example.service.*;
import org.example.controller.*;
import org.example.view.*;
import org.example.repo.IRepository;
import org.example.repo.InMemoryRepository;

import java.time.LocalDate;

public class Main {
    public  static void main(String[] args){
//        String dateString = "2020-11-11"; // Input string
//        LocalDate date = LocalDate.parse(dateString); // Convert string to LocalDate
//        int year = date.getYear(); // Extract the year
//        System.out.println("Year: " + year); // Print the year
        IRepository<Medicine> productRepo=new InMemoryRepository<>();
        IRepository<Patient> clientRepo=new InMemoryRepository<>();

        PatientService clientService=new PatientService(clientRepo);
        MedicineService productService=new MedicineService(productRepo);

        HospitalController hospitalController=new HospitalController(productService,clientService);

        View view=new View(hospitalController);
        view.start();

    }
}
