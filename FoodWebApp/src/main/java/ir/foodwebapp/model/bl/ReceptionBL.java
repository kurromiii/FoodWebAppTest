package ir.foodwebapp.model.bl;

import ir.foodwebapp.model.da.ReceptionDA;
import ir.foodwebapp.model.entity.Reception;

import java.util.List;

public class ReceptionBL {
    private static ReceptionBL receptionBL = new ReceptionBL();

    private ReceptionBL() {
    }

    public static ReceptionBL getReceptionBL() {
        return receptionBL;
    }

    public Reception add(Reception reception) throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.add(reception);
        }
    }

    public Reception edit(Reception reception) throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.edit(reception);
        }
    }

    public Reception remove(long id) throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.remove(id);
        }
    }

    public List<Reception> findByNameAndFamily(String name, String family) throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.findByNameAndFamily(name, family);
        }
    }
    public Reception findByNationalCode(String nationalCode) throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.findByNationalCode(nationalCode);
        }
    }
    public Reception findById(long id) throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.findById(id);
        }
    }

    public List<Reception> findAll() throws Exception {
        try(ReceptionDA receptionDA = new ReceptionDA()){
            return receptionDA.findAll();
        }
    }

}
