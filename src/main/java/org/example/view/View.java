package org.example.view;
import org.example.controller.*;
import org.example.model.*;


import java.util.List;
import java.util.Scanner;
public class View {
    private HospitalController hospitalController;
    public View(HospitalController hospitalController){this.hospitalController=hospitalController;}

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Select an option: \n1.Add medicine\n2.Delete medicine\n3.Update medicine\n4.Get medicine by id\n5.Add patient\n6.Delete patient\n7.Update patient\n8.Get patient by id\n9. Filter patients by diagnosis\n10.to do\n11.to do\n12.to do\n13.Exit");
            String option = scanner.nextLine();

            switch(option){
                case "1":
                    int id=readProductId(scanner);
                    String name=readProductName(scanner);
                    String illness=readProductIllness(scanner);
                    Float price=readProductPrice(scanner);
                    if (hospitalController.createMedicine(id,name,price, illness))
                        System.out.println("Medicine added!");
                    else
                        System.out.println("Id in use!");
                    break;

                case "2":
                    int idDelete=readProductId(scanner);
                    if (hospitalController.deleteMedicine(idDelete))
                        System.out.println("Medicine deleted!");
                    else
                        System.out.println("Product not found!");
                    break;

                case "3":
                    int idUpdate=readProductId(scanner);
                    String nameUpdate=readProductName(scanner);
                    String illnessUpdate=readProductIllness(scanner);
                    Float priceUpdate=readProductPrice(scanner);

                    if (hospitalController.updateMedicine(idUpdate,nameUpdate,priceUpdate,illnessUpdate))
                        System.out.println("Product updated!");
                    else
                        System.out.println("Product not found!");
                    break;

                case "4":
                    int idFind=readProductId(scanner);
                    Medicine medicine=hospitalController.getProductById(idFind);
                    if (medicine==null)
                        System.out.println("Product not found!");
                    else System.out.println(medicine.getId()+" "+medicine.getName()+" "+medicine.getIllness()+" "+ medicine.getPrice());
                    break;

                case "5":
                    int idClient=readClientId(scanner);
                    String nameClient=readClientName(scanner);
                    String diagnosis=readClientDiagnosis(scanner);
                    int age=readClientAge(scanner);

                    if (hospitalController.createPatient(idClient,nameClient,age,diagnosis))
                        System.out.println("Patient added!");
                    else
                        System.out.println("Id in use!");
                    break;

                case "6":
                    int idDeleteClient=readClientId(scanner);
                    if (hospitalController.deletePatient(idDeleteClient))
                        System.out.println("Patient deleted!");
                    else
                        System.out.println("Patient not found!");
                    break;

                case "7":
                    int idClientUpdate=readClientId(scanner);
                    String nameClientUpdate=readClientName(scanner);
                    String diagnosisUpdate=readClientDiagnosis(scanner);
                    int ageUpdate=readClientAge(scanner);

                    if (hospitalController.updatePatient(idClientUpdate,nameClientUpdate,ageUpdate,diagnosisUpdate))
                        System.out.println("Client updated!");
                    else
                        System.out.println("Patient not found!");
                    break;

                case "8":
                    int idFindClient=readClientId(scanner);
                    Patient client=hospitalController.getPatientById(idFindClient);
                    if (client==null)
                        System.out.println("Patient not found!");
                    else System.out.println(client.getId()+" "+client.getName()+" "+client.getAge()+" "+client.getDiagnosis());
                    break;

                case "9":
                    String findDiagnosis=readClientDiagnosis(scanner);
                    List<Patient> findClients=hospitalController.filterByDiagnosis(findDiagnosis);
                    for (Patient client1:findClients)
                        System.out.println(client1.getName());
                    break;

                case "10":
//                    int idBought=readProductId(scanner);
//                    int idBuyer=readClientId(scanner);
//                    Product product1=shopController.getProductById(idBought);
//                    shopController.buyProduct(idBuyer,product1);
                    break;

                case "11":
//                    String findSeason=readProductSeason(scanner);
//                    List<Client> clients=shopController.filterByProductAndSeason(Season.valueOf(findSeason));
//                    for (Client client1:clients)
//                        System.out.println(client1.getName());
                    break;

                case "12":
//                    int choice=readChoiceId(scanner);
//                    if (choice==1){
//                        int clientId=readClientId(scanner);
//                        List<Product> products=shopController.sortProducts(clientId);
//                        for (Product product2:products)
//                            System.out.println(product2.getName());
//                    }
//
//                    if (choice==2){
//                        int clientId=readClientId(scanner);
//                        List<Product> products=shopController.sortProductsDescending(clientId);
//                        for (Product product2:products)
//                            System.out.println(product2.getName());
//                    }

                    break;

                case "13":
                    continueLoop=false;
                    break;
            }
        }
    }

    private static int readProductId(Scanner scanner) {
        System.out.print("Enter medicine ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readChoiceId(Scanner scanner) {
        System.out.print("Enter how the products are sorted.\nEnter 1 for sorting in ascending order\nEnter 2 for sorting descending order: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readClientId(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readClientAge(Scanner scanner) {
        System.out.print("Enter patient age: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readProductName(Scanner scanner) {
        System.out.println("Enter medicine name: ");
        return scanner.nextLine();
    }

    private static String readClientName(Scanner scanner) {
        System.out.println("Enter patient name: ");
        return scanner.nextLine();
    }


    private static String readClientDiagnosis(Scanner scanner) {
        System.out.println("Enter patient diagnosis: ");
        return scanner.nextLine();
    }

    private static String readProductIllness(Scanner scanner) {
        System.out.println("Enter medicine illness: ");
        return scanner.nextLine();
    }

    private static Float readProductPrice(Scanner scanner) {
        System.out.print("Enter product price: ");
        return Float.parseFloat(scanner.nextLine());
    }
}
