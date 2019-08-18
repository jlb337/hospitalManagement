package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Registration implements Serializable {
    private Integer registrationID;

    private Integer patientHistoryID;
    private PatientHistory patientHistory;
    
    private Integer patientID;
    private Patient patient;
    
    private Integer userId;
    private User user;
    
    private Integer registrationTypeID;
    private RegistrationType registrationType;
    
    private Integer departmentID;
    private  Department department;
    
    private Float registrationFee;

	private Date registrationDate;

    private Integer isDelete;

    private Integer operatorID;
    private static final long serialVersionUID = 1L;
   

    public PatientHistory getPatientHistory() {
  		return patientHistory;
  	}

  	public Patient getPatient() {
  		return patient;
  	}

  	public User getUser() {
  		return user;
  	}

  	public RegistrationType getRegistrationType() {
  		return registrationType;
  	}

  	public Department getDepartment() {
  		return department;
  	}

  	public void setPatientHistory(PatientHistory patientHistory) {
  		this.patientHistory = patientHistory;
  	}

  	public void setPatient(Patient patient) {
  		this.patient = patient;
  	}

  	public void setUser(User user) {
  		this.user = user;
  	}

  	public void setRegistrationType(RegistrationType registrationType) {
  		this.registrationType = registrationType;
  	}

  	public void setDepartment(Department department) {
  		this.department = department;
  	}

    public Integer getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Integer registrationID) {
        this.registrationID = registrationID;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRegistrationTypeID() {
        return registrationTypeID;
    }

    public void setRegistrationTypeID(Integer registrationTypeID) {
        this.registrationTypeID = registrationTypeID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Float getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Float registrationFee) {
        this.registrationFee = registrationFee;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Integer operatorID) {
        this.operatorID = operatorID;
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
        Registration other = (Registration) that;
        return (this.getRegistrationID() == null ? other.getRegistrationID() == null : this.getRegistrationID().equals(other.getRegistrationID()))
            && (this.getPatientHistoryID() == null ? other.getPatientHistoryID() == null : this.getPatientHistoryID().equals(other.getPatientHistoryID()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRegistrationTypeID() == null ? other.getRegistrationTypeID() == null : this.getRegistrationTypeID().equals(other.getRegistrationTypeID()))
            && (this.getDepartmentID() == null ? other.getDepartmentID() == null : this.getDepartmentID().equals(other.getDepartmentID()))
            && (this.getRegistrationFee() == null ? other.getRegistrationFee() == null : this.getRegistrationFee().equals(other.getRegistrationFee()))
            && (this.getRegistrationDate() == null ? other.getRegistrationDate() == null : this.getRegistrationDate().equals(other.getRegistrationDate()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getOperatorID() == null ? other.getOperatorID() == null : this.getOperatorID().equals(other.getOperatorID()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegistrationID() == null) ? 0 : getRegistrationID().hashCode());
        result = prime * result + ((getPatientHistoryID() == null) ? 0 : getPatientHistoryID().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRegistrationTypeID() == null) ? 0 : getRegistrationTypeID().hashCode());
        result = prime * result + ((getDepartmentID() == null) ? 0 : getDepartmentID().hashCode());
        result = prime * result + ((getRegistrationFee() == null) ? 0 : getRegistrationFee().hashCode());
        result = prime * result + ((getRegistrationDate() == null) ? 0 : getRegistrationDate().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getOperatorID() == null) ? 0 : getOperatorID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", registrationID=").append(registrationID);
        sb.append(", patientHistoryID=").append(patientHistoryID);
        sb.append(", patientID=").append(patientID);
        sb.append(", userId=").append(userId);
        sb.append(", registrationTypeID=").append(registrationTypeID);
        sb.append(", departmentID=").append(departmentID);
        sb.append(", registrationFee=").append(registrationFee);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", operatorID=").append(operatorID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}