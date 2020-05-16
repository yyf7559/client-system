package cn.entity;

import java.io.Serializable;

public class MedicineType implements Serializable {
    private String id;
    private String typeName;
    private String typeCode;

    @Override
    public String toString() {
        return "MedicineType{" +
                "id='" + id + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeCode='" + typeCode + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
