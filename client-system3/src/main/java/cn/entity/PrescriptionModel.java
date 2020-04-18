package cn.entity;


import java.io.Serializable;
import java.util.List;

public class PrescriptionModel implements Serializable {
    private Integer id;
    private String pNumber;
    private String pname;
    private String pinfo;
    private Integer prescriptionTypeId;
    private String permissions;
    private String createDate;
    private Integer createId;
    private List<Disease> diseases;
    private List<PrescriptionModelDetail> prescriptionModelDetail;
    private List<PrescriptionModelCheck> modelCheck;
    private String createName;
    private String typeName;

    @Override
    public String toString() {
        return "PrescriptionModel{" +
                "id=" + id +
                ", pNumber='" + pNumber + '\'' +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", prescriptionTypeId=" + prescriptionTypeId +
                ", permissions='" + permissions + '\'' +
                ", createDate='" + createDate + '\'' +
                ", createId=" + createId +
                ", diseases=" + diseases +
                ", prescriptionModelDetail=" + prescriptionModelDetail +
                ", createName='" + createName + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public List<PrescriptionModelCheck> getModelCheck() {
        return modelCheck;
    }

    public void setModelCheck(List<PrescriptionModelCheck> modelCheck) {
        this.modelCheck = modelCheck;
    }

    public List<PrescriptionModelDetail> getPrescriptionModelDetail() {
        return prescriptionModelDetail;
    }

    public void setPrescriptionModelDetail(List<PrescriptionModelDetail> prescriptionModelDetail) {
        this.prescriptionModelDetail = prescriptionModelDetail;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public Integer getPrescriptionTypeId() {
        return prescriptionTypeId;
    }

    public void setPrescriptionTypeId(Integer prescriptionTypeId) {
        this.prescriptionTypeId = prescriptionTypeId;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
}
