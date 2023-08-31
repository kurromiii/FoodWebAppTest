package ir.foodwebapp.controller;
import ir.foodwebapp.model.bl.OrderBL;
import ir.foodwebapp.model.bl.ReceptionBL;
import ir.foodwebapp.model.entity.Reception;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class ReceptionController {
    private static ReceptionController receptionController = new ReceptionController();

    private ReceptionController() {
    }

    public static ReceptionController getReceptionController() {
        return receptionController;
    }

    public String add(String name, String family, String nationalCode) {
        try {
            if (name != null && !name.isEmpty() && family != null && !family.isEmpty() && nationalCode != null &&
                    !nationalCode.isEmpty()) {
                if (nationalCode.length() == 10) {
                    Reception reception = new Reception(name, family, nationalCode);
                    return ReceptionBL.getReceptionBL().add(reception).toString();
                } else {
                    throw new ValueException("Enter NationalCode correctly!");
                }
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String edit(String name, String family, String nationalCode) {
        try {
            if (name != null && !name.isEmpty() && family != null && !family.isEmpty() && nationalCode != null &&
                    !nationalCode.isEmpty()) {
                if (nationalCode.length() == 10) {
                    Reception reception = new Reception(name, family, nationalCode);
                    return ReceptionBL.getReceptionBL().edit(reception).toString();
                } else {
                    throw new ValueException("Enter NationalCode correctly!");
                }
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String remove(long id){
        try {
            if (id != 0) {
                return ReceptionBL.getReceptionBL().remove(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String findByNameAndFamily(String name, String family) {
        try {
            if (name != null && !name.isEmpty() && family != null && !family.isEmpty()) {
                return ReceptionBL.getReceptionBL().findByNameAndFamily(name,family).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String findByNationalCode(String nationalCode) {
        try {
            if (nationalCode.length() == 10) {
                return ReceptionBL.getReceptionBL().findByNationalCode(nationalCode).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String findById(long id) {
        try {
            if (id != 0) {
                return ReceptionBL.getReceptionBL().findById(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
}
