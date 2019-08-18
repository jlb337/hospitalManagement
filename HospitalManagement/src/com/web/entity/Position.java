package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Position implements Serializable {
    private Integer poId;

    private Integer departmentID;

    private String poName;

    private String poSalary;

    private Integer isDelete;
    
    private Department department;

    private static final long serialVersionUID = 1L;

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getPoName() {
        return poName;
    }

    public void setPoName(String poName) {
        this.poName = poName;
    }

    public String getPoSalary() {
        return poSalary;
    }

    public void setPoSalary(String poSalary) {
        this.poSalary = poSalary;
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
        Position other = (Position) that;
        return (this.getPoId() == null ? other.getPoId() == null : this.getPoId().equals(other.getPoId()))
            && (this.getDepartmentID() == null ? other.getDepartmentID() == null : this.getDepartmentID().equals(other.getDepartmentID()))
            && (this.getPoName() == null ? other.getPoName() == null : this.getPoName().equals(other.getPoName()))
            && (this.getPoSalary() == null ? other.getPoSalary() == null : this.getPoSalary().equals(other.getPoSalary()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPoId() == null) ? 0 : getPoId().hashCode());
        result = prime * result + ((getDepartmentID() == null) ? 0 : getDepartmentID().hashCode());
        result = prime * result + ((getPoName() == null) ? 0 : getPoName().hashCode());
        result = prime * result + ((getPoSalary() == null) ? 0 : getPoSalary().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", poId=").append(poId);
        sb.append(", departmentID=").append(departmentID);
        sb.append(", poName=").append(poName);
        sb.append(", poSalary=").append(poSalary);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}