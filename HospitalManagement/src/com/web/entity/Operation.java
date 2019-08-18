package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Operation implements Serializable {
	
	private Patient patient;
	
    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	private Integer operationID;

    private Integer isDelete;

    private Integer patientID;

    private String operationName;

    private Integer sleepMethod;

    private String hurtSituation;

    private Date operationDate;

    private Float operationPersistentTime;

    private String operationResult;

    private Float operationCost;

    private static final long serialVersionUID = 1L;

    public Integer getOperationID() {
        return operationID;
    }

    public void setOperationID(Integer operationID) {
        this.operationID = operationID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Integer getSleepMethod() {
        return sleepMethod;
    }

    public void setSleepMethod(Integer sleepMethod) {
        this.sleepMethod = sleepMethod;
    }

    public String getHurtSituation() {
        return hurtSituation;
    }

    public void setHurtSituation(String hurtSituation) {
        this.hurtSituation = hurtSituation;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }



    public Float getOperationPersistentTime() {
		return operationPersistentTime;
	}

	public void setOperationPersistentTime(Float operationPersistentTime) {
		this.operationPersistentTime = operationPersistentTime;
	}

	public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public Float getOperationCost() {
        return operationCost;
    }

    public void setOperationCost(Float operationCost) {
        this.operationCost = operationCost;
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
        Operation other = (Operation) that;
        return (this.getOperationID() == null ? other.getOperationID() == null : this.getOperationID().equals(other.getOperationID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getOperationName() == null ? other.getOperationName() == null : this.getOperationName().equals(other.getOperationName()))
            && (this.getSleepMethod() == null ? other.getSleepMethod() == null : this.getSleepMethod().equals(other.getSleepMethod()))
            && (this.getHurtSituation() == null ? other.getHurtSituation() == null : this.getHurtSituation().equals(other.getHurtSituation()))
            && (this.getOperationDate() == null ? other.getOperationDate() == null : this.getOperationDate().equals(other.getOperationDate()))
            && (this.getOperationPersistentTime() == null ? other.getOperationPersistentTime() == null : this.getOperationPersistentTime().equals(other.getOperationPersistentTime()))
            && (this.getOperationResult() == null ? other.getOperationResult() == null : this.getOperationResult().equals(other.getOperationResult()))
            && (this.getOperationCost() == null ? other.getOperationCost() == null : this.getOperationCost().equals(other.getOperationCost()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperationID() == null) ? 0 : getOperationID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getOperationName() == null) ? 0 : getOperationName().hashCode());
        result = prime * result + ((getSleepMethod() == null) ? 0 : getSleepMethod().hashCode());
        result = prime * result + ((getHurtSituation() == null) ? 0 : getHurtSituation().hashCode());
        result = prime * result + ((getOperationDate() == null) ? 0 : getOperationDate().hashCode());
        result = prime * result + ((getOperationPersistentTime() == null) ? 0 : getOperationPersistentTime().hashCode());
        result = prime * result + ((getOperationResult() == null) ? 0 : getOperationResult().hashCode());
        result = prime * result + ((getOperationCost() == null) ? 0 : getOperationCost().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operationID=").append(operationID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", patientID=").append(patientID);
        sb.append(", operationName=").append(operationName);
        sb.append(", sleepMethod=").append(sleepMethod);
        sb.append(", hurtSituation=").append(hurtSituation);
        sb.append(", operationDate=").append(operationDate);
        sb.append(", operationPersistentTime=").append(operationPersistentTime);
        sb.append(", operationResult=").append(operationResult);
        sb.append(", operationCost=").append(operationCost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}