package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Drug implements Serializable {
    private String drugID;

    private Integer isDelete;


    private Integer drugStoreID;

    private String drugName;

    private String drugType;

    private String drugUnit;

    private Float drugUnitPrice;

    private Date drugProductionDate;

    private Date drugLife;
    
    DrugStore drugstore;
    

    public DrugStore getDrugstore() {
		return drugstore;
	}

	public void setDrugstore(DrugStore drugstore) {
		this.drugstore = drugstore;
	}


	private static final long serialVersionUID = 1L;

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public Integer getDrugStoreID() {
        return drugStoreID;
    }

    public void setDrugStoreID(Integer drugStoreID) {
        this.drugStoreID = drugStoreID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getDrugUnit() {
        return drugUnit;
    }

    public void setDrugUnit(String drugUnit) {
        this.drugUnit = drugUnit;
    }

    public Float getDrugUnitPrice() {
        return drugUnitPrice;
    }

    public void setDrugUnitPrice(Float drugUnitPrice) {
        this.drugUnitPrice = drugUnitPrice;
    }

    public Date getDrugProductionDate() {
        return drugProductionDate;
    }

    public void setDrugProductionDate(Date drugProductionDate) {
        this.drugProductionDate = drugProductionDate;
    }

    public Date getDrugLife() {
        return drugLife;
    }

    public void setDrugLife(Date drugLife) {
        this.drugLife = drugLife;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Drug other = (Drug) that;
        return (this.getDrugID() == null ? other.getDrugID() == null : this.getDrugID().equals(other.getDrugID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getDrugStoreID() == null ? other.getDrugStoreID() == null : this.getDrugStoreID().equals(other.getDrugStoreID()))
            && (this.getDrugName() == null ? other.getDrugName() == null : this.getDrugName().equals(other.getDrugName()))
            && (this.getDrugType() == null ? other.getDrugType() == null : this.getDrugType().equals(other.getDrugType()))
            && (this.getDrugUnit() == null ? other.getDrugUnit() == null : this.getDrugUnit().equals(other.getDrugUnit()))
            && (this.getDrugUnitPrice() == null ? other.getDrugUnitPrice() == null : this.getDrugUnitPrice().equals(other.getDrugUnitPrice()))
            && (this.getDrugProductionDate() == null ? other.getDrugProductionDate() == null : this.getDrugProductionDate().equals(other.getDrugProductionDate()))
            && (this.getDrugLife() == null ? other.getDrugLife() == null : this.getDrugLife().equals(other.getDrugLife()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugID() == null) ? 0 : getDrugID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getDrugStoreID() == null) ? 0 : getDrugStoreID().hashCode());
        result = prime * result + ((getDrugName() == null) ? 0 : getDrugName().hashCode());
        result = prime * result + ((getDrugType() == null) ? 0 : getDrugType().hashCode());
        result = prime * result + ((getDrugUnit() == null) ? 0 : getDrugUnit().hashCode());
        result = prime * result + ((getDrugUnitPrice() == null) ? 0 : getDrugUnitPrice().hashCode());
        result = prime * result + ((getDrugProductionDate() == null) ? 0 : getDrugProductionDate().hashCode());
        result = prime * result + ((getDrugLife() == null) ? 0 : getDrugLife().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugID=").append(drugID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", drugStoreID=").append(drugStoreID);
        sb.append(", drugName=").append(drugName);
        sb.append(", drugType=").append(drugType);
        sb.append(", drugUnit=").append(drugUnit);
        sb.append(", drugUnitPrice=").append(drugUnitPrice);
        sb.append(", drugProductionDate=").append(drugProductionDate);
        sb.append(", drugLife=").append(drugLife);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}