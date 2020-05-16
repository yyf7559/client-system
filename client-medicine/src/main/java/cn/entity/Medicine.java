package cn.entity;

import java.io.Serializable;
import java.util.List;

public class Medicine implements Serializable {
    private Integer id;
    private Integer typeId;
    private String medicineNo;
    private String medicineName;
    private String code;
    private String medicineSize;
    private int stock;
    private float price;
    private String typeName;
    private List<Method> method;
    private Integer prescriptionId;

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", medicineNo='" + medicineNo + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", code='" + code + '\'' +
                ", medicineSize='" + medicineSize + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", typeName='" + typeName + '\'' +
                ", prescriptionTypeId=" + prescriptionId +
                '}';
    }

    public List<Method> getMethod() {
        return method;
    }

    public void setMethod(List<Method> method) {
        this.method = method;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getPrescriptionTypeId() {
        return prescriptionId;
    }

    public void setPrescriptionTypeId(Integer prescriptionTypeId) {
        this.prescriptionId = prescriptionTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getMedicineNo() {
        return medicineNo;
    }

    public void setMedicineNo(String medicineNo) {
        this.medicineNo = medicineNo;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMedicineSize() {
        return medicineSize;
    }

    public void setMedicineSize(String medicineSize) {
        this.medicineSize = medicineSize;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
