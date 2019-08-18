package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class RegistrationType implements Serializable {
    private Integer registrationTypeID;

    private Integer isDelete;

    private String registrationTypeName;

    private static final long serialVersionUID = 1L;

    public Integer getRegistrationTypeID() {
        return registrationTypeID;
    }

    public void setRegistrationTypeID(Integer registrationTypeID) {
        this.registrationTypeID = registrationTypeID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRegistrationTypeName() {
        return registrationTypeName;
    }

    public void setRegistrationTypeName(String registrationTypeName) {
        this.registrationTypeName = registrationTypeName;
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
        RegistrationType other = (RegistrationType) that;
        return (this.getRegistrationTypeID() == null ? other.getRegistrationTypeID() == null : this.getRegistrationTypeID().equals(other.getRegistrationTypeID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getRegistrationTypeName() == null ? other.getRegistrationTypeName() == null : this.getRegistrationTypeName().equals(other.getRegistrationTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegistrationTypeID() == null) ? 0 : getRegistrationTypeID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getRegistrationTypeName() == null) ? 0 : getRegistrationTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registrationTypeID=").append(registrationTypeID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", registrationTypeName=").append(registrationTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}