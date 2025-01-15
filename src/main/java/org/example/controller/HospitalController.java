package org.example.controller;
import org.example.model.*;
import org.example.service.*;

import java.util.List;
public class HospitalController {
    private MedicineService medicineService;
    private PatientService patientService;
    public HospitalController(MedicineService medicineService, PatientService patientService){
        this.medicineService=medicineService;
        this.patientService=patientService;}

    public boolean createMedicine(int id, String name, Float price, String illness){return medicineService.createMedicine(id,name,price,illness);}
    public boolean deleteMedicine(int id){return medicineService.deleteMedicine(id);}

    public boolean updateMedicine(int id, String name, Float price, String illness){return medicineService.updateMedicine(id,name,price,illness);}
    public Medicine getProductById(int id){return medicineService.getProductById(id);}

    public boolean createPatient(int id, String name, int age, String diagnosis){return patientService.createPatient(id,name,age,diagnosis);}

    public boolean deletePatient(int id){return patientService.deletePatient(id);}

    public boolean updatePatient(int id, String name, int age, String diagnosis){return patientService.updatePatient(id,name,age,diagnosis);}

    public Patient getPatientById(int id){return patientService.getPatientById(id);}

    public List<Patient> filterByDiagnosis(String diagnosis){return patientService.filterByDiagnosis(diagnosis);}

    public void prescribeMedicine(int patientId, Medicine medicine){patientService.prescribeMedicine(patientId,medicine);}

    public List<Patient> filterByMedicineAndIllness(String illness){return patientService.filterByMedicineAndIllness(illness);}

    public List<Medicine> sortProducts(int clientId){return patientService.sortProducts(clientId);}

    public List<Medicine> sortProductsDescending(int clientId){return patientService.sortProductsDescending(clientId);}
}
