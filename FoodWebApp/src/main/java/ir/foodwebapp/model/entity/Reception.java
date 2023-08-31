package ir.foodwebapp.model.entity;

import java.time.LocalDate;

public class Reception extends Person{
    private String nationalCode;
    private LocalDate birthDate;

    public Reception(long id, String name, String family, String phoneNumber, boolean status, String nationalCode, LocalDate birthDate) {
        super(id, name, family, phoneNumber, status);
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
    }

    public Reception(String name, String family, String phoneNumber, boolean status, String nationalCode, LocalDate birthDate) {
        super(name, family, phoneNumber, status);
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
    }

    public Reception(String name, String family, String phoneNumber, String nationalCode, LocalDate birthDate) {
        super(name, family, phoneNumber);
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
    }

    public Reception(String name, String family, String nationalCode) {
        super(name, family);
        this.nationalCode = nationalCode;
    }

    public Reception() {
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public Reception setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Reception setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
