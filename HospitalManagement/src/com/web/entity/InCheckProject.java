package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class InCheckProject implements Serializable {
    private Integer inCheckID;

    private Integer isDelete;

    private Integer patientID;
    
    private String checkName;

    private Date checkDate;

    private String checkLeader;

    private String checkContent;

    private String checkResult;
    
    private Patient patient;

    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	private static final long serialVersionUID = 1L;

    
    public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Integer getInCheckID() {
		return inCheckID;
	}

	public void setInCheckID(Integer inCheckID) {
		this.inCheckID = inCheckID;
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

	public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckLeader() {
        return checkLeader;
    }

    public void setCheckLeader(String checkLeader) {
        this.checkLeader = checkLeader;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
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
        InCheckProject other = (InCheckProject) that;
        return (this.getInCheckID() == null ? other.getInCheckID() == null : this.getInCheckID().equals(other.getInCheckID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getCheckDate() == null ? other.getCheckDate() == null : this.getCheckDate().equals(other.getCheckDate()))
            && (this.getCheckLeader() == null ? other.getCheckLeader() == null : this.getCheckLeader().equals(other.getCheckLeader()))
            && (this.getCheckContent() == null ? other.getCheckContent() == null : this.getCheckContent().equals(other.getCheckContent()))
            && (this.getCheckResult() == null ? other.getCheckResult() == null : this.getCheckResult().equals(other.getCheckResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInCheckID() == null) ? 0 : getInCheckID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getCheckDate() == null) ? 0 : getCheckDate().hashCode());
        result = prime * result + ((getCheckLeader() == null) ? 0 : getCheckLeader().hashCode());
        result = prime * result + ((getCheckContent() == null) ? 0 : getCheckContent().hashCode());
        result = prime * result + ((getCheckResult() == null) ? 0 : getCheckResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkID2=").append(inCheckID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", patientID=").append(patientID);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", checkLeader=").append(checkLeader);
        sb.append(", checkContent=").append(checkContent);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}