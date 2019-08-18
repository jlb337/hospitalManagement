package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Supplier implements Serializable {
    private Integer supplierID;

    private Integer isDelete;

    private String supplierAddress;

    private String supplierTel;

    private Integer supplierReditStatus;

    private static final long serialVersionUID = 1L;

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public Integer getSupplierReditStatus() {
        return supplierReditStatus;
    }

    public void setSupplierReditStatus(Integer supplierReditStatus) {
        this.supplierReditStatus = supplierReditStatus;
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
        Supplier other = (Supplier) that;
        return (this.getSupplierID() == null ? other.getSupplierID() == null : this.getSupplierID().equals(other.getSupplierID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getSupplierAddress() == null ? other.getSupplierAddress() == null : this.getSupplierAddress().equals(other.getSupplierAddress()))
            && (this.getSupplierTel() == null ? other.getSupplierTel() == null : this.getSupplierTel().equals(other.getSupplierTel()))
            && (this.getSupplierReditStatus() == null ? other.getSupplierReditStatus() == null : this.getSupplierReditStatus().equals(other.getSupplierReditStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSupplierID() == null) ? 0 : getSupplierID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getSupplierAddress() == null) ? 0 : getSupplierAddress().hashCode());
        result = prime * result + ((getSupplierTel() == null) ? 0 : getSupplierTel().hashCode());
        result = prime * result + ((getSupplierReditStatus() == null) ? 0 : getSupplierReditStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierID=").append(supplierID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", supplierAddress=").append(supplierAddress);
        sb.append(", supplierTel=").append(supplierTel);
        sb.append(", supplierReditStatus=").append(supplierReditStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}