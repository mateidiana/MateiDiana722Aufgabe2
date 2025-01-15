package org.example.service;
import org.example.model.*;
import org.example.repo.IRepository;

import java.util.ArrayList;
import java.util.List;
public class MedicineService {
    private final IRepository<Medicine> medicineRepo;
    public MedicineService(IRepository<Medicine> medicineRepo){this.medicineRepo=medicineRepo;}

    public boolean createMedicine(int id, String name, Float price, String illness){
        for (Medicine product:medicineRepo.getAll())
            if (product.getId()==id)
                return false;
        Medicine product=new Medicine(id,name,price,illness);
        medicineRepo.create(product);
        return true;
    }

    public boolean deleteMedicine(int id){
        for (Medicine product:medicineRepo.getAll())
            if(product.getId()==id){
                medicineRepo.delete(id);
                return true;
            }
        return false;

    }

    public boolean updateMedicine(int id, String name, Float price, String illness){
        for (Medicine product:medicineRepo.getAll())
            if (product.getId()==id)
            {
                product.setName(name);
                product.setPrice(price);
                product.setIllness(illness);
                medicineRepo.update(product);
                return true;
            }
        return false;
    }

    public Medicine getProductById(int id){
        return medicineRepo.read(id);
    }
}
