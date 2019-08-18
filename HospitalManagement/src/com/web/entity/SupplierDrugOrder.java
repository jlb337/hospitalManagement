package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SupplierDrugOrder extends SupplierDrugOrderKey implements Serializable {
    private Date supplierOrderMakeDate;

    private Date supplierOrderFinishDate;

    private String supplierOrderAddress;

    private Integer supplierOrderCount;

    private Integer isDelete;
    
    private Supplier supplier;
    
    private DrugOrder drugOrder;

    public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public DrugOrder getDrugOrder() {
		return drugOrder;
	}

	public void setDrugOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}

	private static final long serialVersionUID = 1L;

    public Date getSupplierOrderMakeDate() {
        return supplierOrderMakeDate;
    }

    public void setSupplierOrderMakeDate(Date supplierOrderMakeDate) {
        this.supplierOrderMakeDate = supplierOrderMakeDate;
    }

    public Date getSupplierOrderFinishDate() {
        return supplierOrderFinishDate;
    }

    public void setSupplierOrderFinishDate(Date supplierOrderFinishDate) {
        this.supplierOrderFinishDate = supplierOrderFinishDate;
    }

    public String getSupplierOrderAddress() {
        return supplierOrderAddress;
    }

    public void setSupplierOrderAddress(String supplierOrderAddress) {
        this.supplierOrderAddress = supplierOrderAddress;
    }

    public Integer getSupplierOrderCount() {
        return supplierOrderCount;
    }

    public void setSupplierOrderCount(Integer supplierOrderCount) {
        this.supplierOrderCount = supplierOrderCount;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        SupplierDrugOrder other = (SupplierDrugOrder) that;
        return (this.getSupplierID() == null ? other.getSupplierID() == null : this.getSupplierID().equals(other.getSupplierID()))
            && (this.getDrugOrderID() == null ? other.getDrugOrderID() == null : this.getDrugOrderID().equals(other.getDrugOrderID()))
            && (this.getSupplierOrderMakeDate() == null ? other.getSupplierOrderMakeDate() == null : this.getSupplierOrderMakeDate().equals(other.getSupplierOrderMakeDate()))
            && (this.getSupplierOrderFinishDate() == null ? other.getSupplierOrderFinishDate() == null : this.getSupplierOrderFinishDate().equals(other.getSupplierOrderFinishDate()))
            && (this.getSupplierOrderAddress() == null ? other.getSupplierOrderAddress() == null : this.getSupplierOrderAddress().equals(other.getSupplierOrderAddress()))
            && (this.getSupplierOrderCount() == null ? other.getSupplierOrderCount() == null : this.getSupplierOrderCount().equals(other.getSupplierOrderCount()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSupplierID() == null) ? 0 : getSupplierID().hashCode());
        result = prime * result + ((getDrugOrderID() == null) ? 0 : getDrugOrderID().hashCode());
        result = prime * result + ((getSupplierOrderMakeDate() == null) ? 0 : getSupplierOrderMakeDate().hashCode());
        result = prime * result + ((getSupplierOrderFinishDate() == null) ? 0 : getSupplierOrderFinishDate().hashCode());
        result = prime * result + ((getSupplierOrderAddress() == null) ? 0 : getSupplierOrderAddress().hashCode());
        result = prime * result + ((getSupplierOrderCount() == null) ? 0 : getSupplierOrderCount().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierOrderMakeDate=").append(supplierOrderMakeDate);
        sb.append(", supplierOrderFinishDate=").append(supplierOrderFinishDate);
        sb.append(", supplierOrderAddress=").append(supplierOrderAddress);
        sb.append(", supplierOrderCount=").append(supplierOrderCount);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}