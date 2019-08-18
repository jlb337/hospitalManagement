package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class DrugStore implements Serializable {
    private Integer drugStoreID;

    private Integer isDelete;

    private Integer userId;
    private User user;
  

	private Integer drugStoreLeader;

    private String drugStoreType;

    private Float drugStoreArea;

    private static final long serialVersionUID = 1L;
    public User getUser() {
  		return user;
  	}

  	public void setUser(User user) {
  		this.user = user;
  	}
    public Integer getDrugStoreID() {
        return drugStoreID;
    }

    public void setDrugStoreID(Integer drugStoreID) {
        this.drugStoreID = drugStoreID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDrugStoreLeader() {
        return drugStoreLeader;
    }

    public void setDrugStoreLeader(Integer drugStoreLeader) {
        this.drugStoreLeader = drugStoreLeader;
    }

    public String getDrugStoreType() {
        return drugStoreType;
    }

    public void setDrugStoreType(String drugStoreType) {
        this.drugStoreType = drugStoreType;
    }

    public Float getDrugStoreArea() {
        return drugStoreArea;
    }

    public void setDrugStoreArea(Float drugStoreArea) {
        this.drugStoreArea = drugStoreArea;
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
        DrugStore other = (DrugStore) that;
        return (this.getDrugStoreID() == null ? other.getDrugStoreID() == null : this.getDrugStoreID().equals(other.getDrugStoreID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDrugStoreLeader() == null ? other.getDrugStoreLeader() == null : this.getDrugStoreLeader().equals(other.getDrugStoreLeader()))
            && (this.getDrugStoreType() == null ? other.getDrugStoreType() == null : this.getDrugStoreType().equals(other.getDrugStoreType()))
            && (this.getDrugStoreArea() == null ? other.getDrugStoreArea() == null : this.getDrugStoreArea().equals(other.getDrugStoreArea()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugStoreID() == null) ? 0 : getDrugStoreID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDrugStoreLeader() == null) ? 0 : getDrugStoreLeader().hashCode());
        result = prime * result + ((getDrugStoreType() == null) ? 0 : getDrugStoreType().hashCode());
        result = prime * result + ((getDrugStoreArea() == null) ? 0 : getDrugStoreArea().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugStoreID=").append(drugStoreID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", userId=").append(userId);
        sb.append(", drugStoreLeader=").append(drugStoreLeader);
        sb.append(", drugStoreType=").append(drugStoreType);
        sb.append(", drugStoreArea=").append(drugStoreArea);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}