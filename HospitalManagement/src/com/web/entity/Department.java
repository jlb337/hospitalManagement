package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Department implements Serializable {
    private Integer departmentID;

    private Integer isDelete;

    private String departmentName;


    private String departmentAddress;

    private String departmentPhone;

    private static final long serialVersionUID = 1L;

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone;
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
        Department other = (Department) that;
        return (this.getDepartmentID() == null ? other.getDepartmentID() == null : this.getDepartmentID().equals(other.getDepartmentID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
          
            && (this.getDepartmentAddress() == null ? other.getDepartmentAddress() == null : this.getDepartmentAddress().equals(other.getDepartmentAddress()))
            && (this.getDepartmentPhone() == null ? other.getDepartmentPhone() == null : this.getDepartmentPhone().equals(other.getDepartmentPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDepartmentID() == null) ? 0 : getDepartmentID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
       
        result = prime * result + ((getDepartmentAddress() == null) ? 0 : getDepartmentAddress().hashCode());
        result = prime * result + ((getDepartmentPhone() == null) ? 0 : getDepartmentPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", departmentID=").append(departmentID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", departmentName=").append(departmentName);
      
        sb.append(", departmentAddress=").append(departmentAddress);
        sb.append(", departmentPhone=").append(departmentPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}