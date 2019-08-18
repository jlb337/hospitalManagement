package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class InRecord implements Serializable {
    private Integer inID;

    private Integer isDelete;

    private Integer bedID;
    
    private Integer patientID;

    private Integer departmentID;

    private Date inTime;

    private Integer inSituation;

    private String changeDepartmentSituation;

    private static final long serialVersionUID = 1L;

    private Bed bed;
    
    private Department department;
    
    private Patient patient;
    
    public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department departmen) {
		this.department = departmen;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getInID() {
        return inID;
    }

    public void setInID(Integer inID) {
        this.inID = inID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getBedID() {
        return bedID;
    }

    public void setBedID(Integer bedID) {
        this.bedID = bedID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Integer getInSituation() {
        return inSituation;
    }

    public void setInSituation(Integer inSituation) {
        this.inSituation = inSituation;
    }

    public String getChangeDepartmentSituation() {
        return changeDepartmentSituation;
    }

    public void setChangeDepartmentSituation(String changeDepartmentSituation) {
        this.changeDepartmentSituation = changeDepartmentSituation;
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
        InRecord other = (InRecord) that;
        return (this.getInID() == null ? other.getInID() == null : this.getInID().equals(other.getInID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getBedID() == null ? other.getBedID() == null : this.getBedID().equals(other.getBedID()))
            && (this.getDepartmentID() == null ? other.getDepartmentID() == null : this.getDepartmentID().equals(other.getDepartmentID()))
            && (this.getInTime() == null ? other.getInTime() == null : this.getInTime().equals(other.getInTime()))
            && (this.getInSituation() == null ? other.getInSituation() == null : this.getInSituation().equals(other.getInSituation()))
            && (this.getChangeDepartmentSituation() == null ? other.getChangeDepartmentSituation() == null : this.getChangeDepartmentSituation().equals(other.getChangeDepartmentSituation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInID() == null) ? 0 : getInID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getBedID() == null) ? 0 : getBedID().hashCode());
        result = prime * result + ((getDepartmentID() == null) ? 0 : getDepartmentID().hashCode());
        result = prime * result + ((getInTime() == null) ? 0 : getInTime().hashCode());
        result = prime * result + ((getInSituation() == null) ? 0 : getInSituation().hashCode());
        result = prime * result + ((getChangeDepartmentSituation() == null) ? 0 : getChangeDepartmentSituation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inID=").append(inID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", bedID=").append(bedID);
        sb.append(", departmentID=").append(departmentID);
        sb.append(", inTime=").append(inTime);
        sb.append(", inSituation=").append(inSituation);
        sb.append(", changeDepartmentSituation=").append(changeDepartmentSituation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}
}