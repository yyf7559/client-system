package cn.entity;

import java.io.Serializable;

public class PrescriptionAddPrice implements Serializable {
   private Integer id;
   private Integer prescriptionId;
   private Integer addPriceId;
   private Integer number;
   private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getAddPriceId() {
        return addPriceId;
    }

    public void setAddPriceId(Integer addPriceId) {
        this.addPriceId = addPriceId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
