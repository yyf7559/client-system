package cn.entity;

import java.io.Serializable;

public class PrescriptionDetail implements Serializable {
   private Integer id;
   private Integer prescriptId;
   private Integer medicineId;
   private Integer useSize;
   private String methodId;
   private String frequency;
   private Integer days;
   private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrescriptId() {
        return prescriptId;
    }

    public void setPrescriptId(Integer prescriptId) {
        this.prescriptId = prescriptId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getUseSize() {
        return useSize;
    }

    public void setUseSize(Integer useSize) {
        this.useSize = useSize;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
