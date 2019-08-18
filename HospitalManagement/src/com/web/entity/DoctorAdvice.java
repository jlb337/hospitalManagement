package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class DoctorAdvice implements Serializable {

	private Integer willID;
	
    private Integer isDelete;

    private Integer userId;

    private Integer patientHistoryID;

    private Integer patientID;

    private Date startDate;

    private Date endDate;

    private String doctorAdvice;

    private String illnessName;

    private Integer flagOut;
    
    //外键
    Patient patient;
    
    User user;

    PatientHistory patienthistory;
    
    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public PatientHistory getPatienthistory() {
		return patienthistory;
	}

	public void setPatienthistory(PatientHistory patienthistory) {
		this.patienthistory = patienthistory;
	}


	private static final long serialVersionUID = 1L;

    public Integer getWillID() {
        return willID;
    }

    public void setWillID(Integer willID) {
        this.willID = willID;
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

    public Integer getPatientHistoryID() {
        return patientHistoryID;
    }

    public void setPatientHistoryID(Integer patientHistoryID) {
        this.patientHistoryID = patientHistoryID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public Integer getFlagOut() {
        return flagOut;
    }

    public void setFlagOut(Integer flagOut) {
        this.flagOut = flagOut;
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
        DoctorAdvice other = (DoctorAdvice) that;
        return (this.getWillID() == null ? other.getWillID() == null : this.getWillID().equals(other.getWillID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPatientHistoryID() == null ? other.getPatientHistoryID() == null : this.getPatientHistoryID().equals(other.getPatientHistoryID()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getDoctorAdvice() == null ? other.getDoctorAdvice() == null : this.getDoctorAdvice().equals(other.getDoctorAdvice()))
            && (this.getIllnessName() == null ? other.getIllnessName() == null : this.getIllnessName().equals(other.getIllnessName()))
            && (this.getFlagOut() == null ? other.getFlagOut() == null : this.getFlagOut().equals(other.getFlagOut()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWillID() == null) ? 0 : getWillID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPatientHistoryID() == null) ? 0 : getPatientHistoryID().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getDoctorAdvice() == null) ? 0 : getDoctorAdvice().hashCode());
        result = prime * result + ((getIllnessName() == null) ? 0 : getIllnessName().hashCode());
        result = prime * result + ((getFlagOut() == null) ? 0 : getFlagOut().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", willID=").append(willID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", userId=").append(userId);
        sb.append(", patientHistoryID=").append(patientHistoryID);
        sb.append(", patientID=").append(patientID);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", doctorAdvice=").append(doctorAdvice);
        sb.append(", illnessName=").append(illnessName);
        sb.append(", flagOut=").append(flagOut);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}