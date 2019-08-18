package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class PatientHistory implements Serializable {
    private Integer patientHistoryID;

    private Integer isDelete;

    private Integer userId;
   
	private Date diagnosisDate;

    private String patientHistoryRecord;

    private Integer historytype;

    private static final long serialVersionUID = 1L;

    public Integer getPatientHistoryID() {
        return patientHistoryID;
    }

    public void setPatientHistoryID(Integer patientHistoryID) {
        this.patientHistoryID = patientHistoryID;
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

    private User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getPatientHistoryRecord() {
        return patientHistoryRecord;
    }

    public void setPatientHistoryRecord(String patientHistoryRecord) {
        this.patientHistoryRecord = patientHistoryRecord;
    }

    public Integer getHistorytype() {
        return historytype;
    }

    public void setHistorytype(Integer historytype) {
        this.historytype = historytype;
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
        PatientHistory other = (PatientHistory) that;
        return (this.getPatientHistoryID() == null ? other.getPatientHistoryID() == null : this.getPatientHistoryID().equals(other.getPatientHistoryID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDiagnosisDate() == null ? other.getDiagnosisDate() == null : this.getDiagnosisDate().equals(other.getDiagnosisDate()))
            && (this.getPatientHistoryRecord() == null ? other.getPatientHistoryRecord() == null : this.getPatientHistoryRecord().equals(other.getPatientHistoryRecord()))
            && (this.getHistorytype() == null ? other.getHistorytype() == null : this.getHistorytype().equals(other.getHistorytype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPatientHistoryID() == null) ? 0 : getPatientHistoryID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDiagnosisDate() == null) ? 0 : getDiagnosisDate().hashCode());
        result = prime * result + ((getPatientHistoryRecord() == null) ? 0 : getPatientHistoryRecord().hashCode());
        result = prime * result + ((getHistorytype() == null) ? 0 : getHistorytype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patientHistoryID=").append(patientHistoryID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", userId=").append(userId);
        sb.append(", diagnosisDate=").append(diagnosisDate);
        sb.append(", patientHistoryRecord=").append(patientHistoryRecord);
        sb.append(", historytype=").append(historytype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}