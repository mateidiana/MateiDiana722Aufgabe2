package org.example.service;
import org.example.model.*;
import org.example.repo.IRepository;

import java.util.ArrayList;
import java.util.List;
public class PatientService {
    private final IRepository<Patient> patientRepo;
    public PatientService(IRepository<Patient> patientRepo){this.patientRepo=patientRepo;}

    public boolean createPatient(int id, String name, int age, String diagnosis){
        for (Patient patient:patientRepo.getAll())
            if (patient.getId()==id)
                return false;
        Patient patient=new Patient(id,name,age,diagnosis);
        patientRepo.create(patient);
        return true;
    }

    public boolean deletePatient(int id){
        for (Patient patient:patientRepo.getAll())
            if(patient.getId()==id){
                patientRepo.delete(id);
                return true;
            }
        return false;

    }

    public boolean updatePatient(int id, String name, int age, String diagnosis){
        for (Patient patient:patientRepo.getAll())
            if (patient.getId()==id)
            {
                patient.setName(name);
                patient.setAge(age);
                patient.setDiagnosis(diagnosis);
                patientRepo.update(patient);
                return true;
            }
        return false;
    }

    public Patient getPatientById(int id){
        return patientRepo.read(id);
    }

    public List<Patient> filterByDiagnosis(String diagnosis){
        List<Patient> clients=new ArrayList<>();
        for (Patient client:patientRepo.getAll())
            if (client.getDiagnosis().equals(diagnosis))
                clients.add(client);
        return clients;
    }

    public void prescribeMedicine(int patientId, Medicine medicine){
        Patient client=getPatientById(patientId);
        List<Medicine> products=client.getMedicines();
        products.add(medicine);
        client.setMedicines(products);
        patientRepo.update(client);
    }

    public List<Patient> filterByMedicineAndIllness(String illness){
        List<Patient> clients=new ArrayList<>();
        for(Patient client:patientRepo.getAll())
            for (Medicine product:client.getMedicines())
                if(product.getIllness().equals(illness)){
                    clients.add(client);
                    break;
                }
        return clients;
    }

    public List<Medicine> sortProducts(int clientId){
        Patient client=getPatientById(clientId);
        List<Medicine> products=client.getMedicines();
        sortStringsAscending(products);
        return products;
    }

    public List<Medicine> sortProductsDescending(int clientId){
        Patient client=getPatientById(clientId);
        List<Medicine> products=client.getMedicines();
        sortStringsDescending(products);
        return products;
    }

    public static void sortStringsAscending(List<Medicine> strings) {
        int n = strings.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareStrings(strings.get(j).getName(), strings.get(j + 1).getName()) > 0) {
                    Medicine temp = strings.get(j);
                    strings.set(j, strings.get(j + 1));
                    strings.set(j + 1, temp);
                }
            }
        }
    }

    public static void sortStringsDescending(List<Medicine> strings) {
        int n = strings.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareStrings(strings.get(j).getName(), strings.get(j + 1).getName()) < 0) {
                    Medicine temp = strings.get(j);
                    strings.set(j, strings.get(j + 1));
                    strings.set(j + 1, temp);
                }
            }
        }
    }

    public static int compareStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return len1 - len2;
    }
}
