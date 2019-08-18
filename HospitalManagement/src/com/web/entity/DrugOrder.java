package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class DrugOrder implements Serializable {
    private Integer drugOrderID;

    private Integer isDelete;

    private Integer userId;

    private String standard;

    private Date orderDate;

    private Date commitDate;
    
    private User user;
    private static final long serialVersionUID = 1L;

    public Integer getDrugOrderID() {
        return drugOrderID;
    }

    public void setDrugOrderID(Integer drugOrderID) {
        this.drugOrderID = drugOrderID;
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

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
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
        DrugOrder other = (DrugOrder) that;
        return (this.getDrugOrderID() == null ? other.getDrugOrderID() == null : this.getDrugOrderID().equals(other.getDrugOrderID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStandard() == null ? other.getStandard() == null : this.getStandard().equals(other.getStandard()))
            && (this.getOrderDate() == null ? other.getOrderDate() == null : this.getOrderDate().equals(other.getOrderDate()))
            && (this.getCommitDate() == null ? other.getCommitDate() == null : this.getCommitDate().equals(other.getCommitDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugOrderID() == null) ? 0 : getDrugOrderID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStandard() == null) ? 0 : getStandard().hashCode());
        result = prime * result + ((getOrderDate() == null) ? 0 : getOrderDate().hashCode());
        result = prime * result + ((getCommitDate() == null) ? 0 : getCommitDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugOrderID=").append(drugOrderID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", userId=").append(userId);
        sb.append(", standard=").append(standard);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", commitDate=").append(commitDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}