package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class SupplierDrugOrderKey implements Serializable {
    private Integer supplierID;

    private Integer drugOrderID;

    private static final long serialVersionUID = 1L;

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getDrugOrderID() {
        return drugOrderID;
    }

    public void setDrugOrderID(Integer drugOrderID) {
        this.drugOrderID = drugOrderID;
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
        SupplierDrugOrderKey other = (SupplierDrugOrderKey) that;
        return (this.getSupplierID() == null ? other.getSupplierID() == null : this.getSupplierID().equals(other.getSupplierID()))
            && (this.getDrugOrderID() == null ? other.getDrugOrderID() == null : this.getDrugOrderID().equals(other.getDrugOrderID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSupplierID() == null) ? 0 : getSupplierID().hashCode());
        result = prime * result + ((getDrugOrderID() == null) ? 0 : getDrugOrderID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierID=").append(supplierID);
        sb.append(", drugOrderID=").append(drugOrderID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}