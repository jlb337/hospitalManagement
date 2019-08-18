package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class OrderDetail implements Serializable {
	
	private DrugOrder drugOrder;
	
    public DrugOrder getDrugOrder() {
		return drugOrder;
	}

	public void setDrugOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}

	private Integer detailID;

    private Integer drugOrderID;

    private Integer number;

    private Float sumCost;

    private String batchNumber;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getDetailID() {
        return detailID;
    }

    public void setDetailID(Integer detailID) {
        this.detailID = detailID;
    }

    public Integer getDrugOrderID() {
        return drugOrderID;
    }

    public void setDrugOrderID(Integer drugOrderID) {
        this.drugOrderID = drugOrderID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getSumCost() {
        return sumCost;
    }

    public void setSumCost(Float sumCost) {
        this.sumCost = sumCost;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
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
        OrderDetail other = (OrderDetail) that;
        return (this.getDetailID() == null ? other.getDetailID() == null : this.getDetailID().equals(other.getDetailID()))
            && (this.getDrugOrderID() == null ? other.getDrugOrderID() == null : this.getDrugOrderID().equals(other.getDrugOrderID()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getSumCost() == null ? other.getSumCost() == null : this.getSumCost().equals(other.getSumCost()))
            && (this.getBatchNumber() == null ? other.getBatchNumber() == null : this.getBatchNumber().equals(other.getBatchNumber()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailID() == null) ? 0 : getDetailID().hashCode());
        result = prime * result + ((getDrugOrderID() == null) ? 0 : getDrugOrderID().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getSumCost() == null) ? 0 : getSumCost().hashCode());
        result = prime * result + ((getBatchNumber() == null) ? 0 : getBatchNumber().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailID=").append(detailID);
        sb.append(", drugOrderID=").append(drugOrderID);
        sb.append(", number=").append(number);
        sb.append(", sumCost=").append(sumCost);
        sb.append(", batchNumber=").append(batchNumber);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}