package com.web.entity;

import java.io.Serializable;

/**
 * 手术室
 * @author 
 */
public class OperationRoom implements Serializable {
	
	private User user;
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Integer operationRoomID;

    private Integer userId;

    private String operationRoomAddress;

    private String operationDescrip;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getOperationRoomID() {
        return operationRoomID;
    }

    public void setOperationRoomID(Integer operationRoomID) {
        this.operationRoomID = operationRoomID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOperationRoomAddress() {
        return operationRoomAddress;
    }

    public void setOperationRoomAddress(String operationRoomAddress) {
        this.operationRoomAddress = operationRoomAddress;
    }

    public String getOperationDescrip() {
        return operationDescrip;
    }

    public void setOperationDescrip(String operationDescrip) {
        this.operationDescrip = operationDescrip;
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
        OperationRoom other = (OperationRoom) that;
        return (this.getOperationRoomID() == null ? other.getOperationRoomID() == null : this.getOperationRoomID().equals(other.getOperationRoomID()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOperationRoomAddress() == null ? other.getOperationRoomAddress() == null : this.getOperationRoomAddress().equals(other.getOperationRoomAddress()))
            && (this.getOperationDescrip() == null ? other.getOperationDescrip() == null : this.getOperationDescrip().equals(other.getOperationDescrip()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperationRoomID() == null) ? 0 : getOperationRoomID().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOperationRoomAddress() == null) ? 0 : getOperationRoomAddress().hashCode());
        result = prime * result + ((getOperationDescrip() == null) ? 0 : getOperationDescrip().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operationRoomID=").append(operationRoomID);
        sb.append(", userId=").append(userId);
        sb.append(", operationRoomAddress=").append(operationRoomAddress);
        sb.append(", operationDescrip=").append(operationDescrip);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}