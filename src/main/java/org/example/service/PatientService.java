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
}
