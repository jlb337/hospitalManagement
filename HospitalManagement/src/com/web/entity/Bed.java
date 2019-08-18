package com.web.entity;

import java.io.Serializable;


/**
 * @author 
 */
public class Bed implements Serializable {
    private Integer bedID;

    private Integer isDelete;

    private Integer illnessEreaID;

    private String cureResult;

    private Integer isEmpty;

    private Float bedCost;
    
    private  IllnessErea illnessErea;
    
    private Float bedCost1;
     
    private Float bedCost2;


	public Float getBedCost1() {
		return bedCost1;
	}

	public void setBedCost1(Float bedCost1) {
		this.bedCost1 = bedCost1;
	}

	public Float getBedCost2() {
		return bedCost2;
	}

	public void setBedCost2(Float bedCost2) {
		this.bedCost2 = bedCost2;
	}

	public IllnessErea getIllnessErea() {
		return illnessErea;
	}

	public void setIllnessErea(IllnessErea illnessErea) {
		this.illnessErea = illnessErea;
	}

	public Integer getBedID() {
        return bedID;
    }

    public void setBedID(Integer bedID) {
        this.bedID = bedID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIllnessEreaID() {
        return illnessEreaID;
    }

    public void setIllnessEreaID(Integer illnessEreaID) {
        this.illnessEreaID = illnessEreaID;
    }

    public String getCureResult() {
        return cureResult;
    }

    public void setCureResult(String cureResult) {
        this.cureResult = cureResult;
    }

    public Integer getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Integer isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Float getBedCost() {
        return bedCost;
    }

    public void setBedCost(Float bedCost) {
        this.bedCost = bedCost;
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
        Bed other = (Bed) that;
        return (this.getBedID() == null ? other.getBedID() == null : this.getBedID().equals(other.getBedID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIllnessEreaID() == null ? other.getIllnessEreaID() == null : this.getIllnessEreaID().equals(other.getIllnessEreaID()))
            && (this.getCureResult() == null ? other.getCureResult() == null : this.getCureResult().equals(other.getCureResult()))
            && (this.getIsEmpty() == null ? other.getIsEmpty() == null : this.getIsEmpty().equals(other.getIsEmpty()))
            && (this.getBedCost() == null ? other.getBedCost() == null : this.getBedCost().equals(other.getBedCost()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBedID() == null) ? 0 : getBedID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIllnessEreaID() == null) ? 0 : getIllnessEreaID().hashCode());
        result = prime * result + ((getCureResult() == null) ? 0 : getCureResult().hashCode());
        result = prime * result + ((getIsEmpty() == null) ? 0 : getIsEmpty().hashCode());
        result = prime * result + ((getBedCost() == null) ? 0 : getBedCost().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bedID=").append(bedID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", illnessEreaID=").append(illnessEreaID);
        sb.append(", cureResult=").append(cureResult);
        sb.append(", isEmpty=").append(isEmpty);
        sb.append(", bedCost=").append(bedCost);
        sb.append("]");
        return sb.toString();
    }

}