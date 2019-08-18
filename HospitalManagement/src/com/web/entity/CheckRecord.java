package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 检查记录
 * @author guokaixin
 *
 */
public class CheckRecord implements Serializable {
	
	private Patient patient;
	
	private CheckProject checkProject;
	
    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public CheckProject getCheckProject() {
		return checkProject;
	}

	public void setCheckProject(CheckProject checkProject) {
		this.checkProject = checkProject;
	}

	private Integer checkRecordID;

    private Integer checkID;

    private Integer patientID;

    private Date checkDate;

    private String checkResult;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getCheckRecordID() {
        return checkRecordID;
    }

    public void setCheckRecordID(Integer checkRecordID) {
        this.checkRecordID = checkRecordID;
    }

    public Integer getCheckID() {
        return checkID;
    }

    public void setCheckID(Integer checkID) {
        this.checkID = checkID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
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
        CheckRecord other = (CheckRecord) that;
        return (this.getCheckRecordID() == null ? other.getCheckRecordID() == null : this.getCheckRecordID().equals(other.getCheckRecordID()))
            && (this.getCheckID() == null ? other.getCheckID() == null : this.getCheckID().equals(other.getCheckID()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getCheckDate() == null ? other.getCheckDate() == null : this.getCheckDate().equals(other.getCheckDate()))
            && (this.getCheckResult() == null ? other.getCheckResult() == null : this.getCheckResult().equals(other.getCheckResult()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCheckRecordID() == null) ? 0 : getCheckRecordID().hashCode());
        result = prime * result + ((getCheckID() == null) ? 0 : getCheckID().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getCheckDate() == null) ? 0 : getCheckDate().hashCode());
        result = prime * result + ((getCheckResult() == null) ? 0 : getCheckResult().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkRecordID=").append(checkRecordID);
        sb.append(", checkID=").append(checkID);
        sb.append(", patientID=").append(patientID);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}