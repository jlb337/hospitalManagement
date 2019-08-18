package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Duty implements Serializable {
    private Integer dutyID;

    private Integer isDelete;

    private Integer userId;

    private Date dutyDate;

    private User user;
    
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

    public Integer getDutyID() {
        return dutyID;
    }

    public void setDutyID(Integer dutyID) {
        this.dutyID = dutyID;
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

    public Date getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
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
        Duty other = (Duty) that;
        return (this.getDutyID() == null ? other.getDutyID() == null : this.getDutyID().equals(other.getDutyID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDutyDate() == null ? other.getDutyDate() == null : this.getDutyDate().equals(other.getDutyDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDutyID() == null) ? 0 : getDutyID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDutyDate() == null) ? 0 : getDutyDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dutyID=").append(dutyID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", userId=").append(userId);
        sb.append(", dutyDate=").append(dutyDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}