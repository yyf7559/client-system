package cn.entity;

import java.io.Serializable;

public class PrescriptionModelDetail implements Serializable {
        private Integer id;
        private Integer medicineId;
        private Integer modelId;
        private String useSize;
        private String method;
        private String frequency;
        private Integer count;
        private String medicineName;
        private Long price;

    @Override
    public String toString() {
        return "PrescriptionModelDetail{" +
                "id=" + id +
                ", medicineId=" + medicineId +
                ", modelId=" + modelId +
                ", useSize='" + useSize + '\'' +
                ", method='" + method + '\'' +
                ", frequency='" + frequency + '\'' +
                ", count=" + count +
                ", medicineName='" + medicineName + '\'' +
                '}';
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getUseSize() {
        return useSize;
    }

    public void setUseSize(String useSize) {
        this.useSize = useSize;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
