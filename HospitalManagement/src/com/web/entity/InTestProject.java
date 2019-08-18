package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class InTestProject implements Serializable {
    private Integer inTestID;
    
    private String testName;

    private Integer isDelete;

    private Integer patientID;

    private Date testDate;

    private String testLeader;

    private String testContent;

    private String testResult;

    private Float testCost;
    
    private Float testCost1;
    
    private Float testCost2;
    
    private Patient patient;

    
	public Float getTestCost1() {
		return testCost1;
	}

	public void setTestCost1(Float testCost1) {
		this.testCost1 = testCost1;
	}

	public Float getTestCost2() {
		return testCost2;
	}

	public void setTestCost2(Float testCost2) {
		this.testCost2 = testCost2;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	private static final long serialVersionUID = 1L;

    public Integer getInTestID() {
		return inTestID;
	}

	public void setInTestID(Integer inTestID) {
		this.inTestID = inTestID;
	}

	public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    

    public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestLeader() {
        return testLeader;
    }

    public void setTestLeader(String testLeader) {
        this.testLeader = testLeader;
    }

    public String getTestContent() {
        return testContent;
    }

    public void setTestContent(String testContent) {
        this.testContent = testContent;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Float getTestCost() {
        return testCost;
    }

    public void setTestCost(Float testCost) {
        this.testCost = testCost;
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
        InTestProject other = (InTestProject) that;
        return (this.getInTestID() == null ? other.getInTestID() == null : this.getInTestID().equals(other.getInTestID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getTestDate() == null ? other.getTestDate() == null : this.getTestDate().equals(other.getTestDate()))
            && (this.getTestLeader() == null ? other.getTestLeader() == null : this.getTestLeader().equals(other.getTestLeader()))
            && (this.getTestContent() == null ? other.getTestContent() == null : this.getTestContent().equals(other.getTestContent()))
            && (this.getTestResult() == null ? other.getTestResult() == null : this.getTestResult().equals(other.getTestResult()))
            && (this.getTestCost() == null ? other.getTestCost() == null : this.getTestCost().equals(other.getTestCost()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInTestID() == null) ? 0 : getInTestID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getTestDate() == null) ? 0 : getTestDate().hashCode());
        result = prime * result + ((getTestLeader() == null) ? 0 : getTestLeader().hashCode());
        result = prime * result + ((getTestContent() == null) ? 0 : getTestContent().hashCode());
        result = prime * result + ((getTestResult() == null) ? 0 : getTestResult().hashCode());
        result = prime * result + ((getTestCost() == null) ? 0 : getTestCost().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", inTestID=").append(inTestID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", patientID=").append(patientID);
        sb.append(", testDate=").append(testDate);
        sb.append(", testLeader=").append(testLeader);
        sb.append(", testContent=").append(testContent);
        sb.append(", testResult=").append(testResult);
        sb.append(", testCost=").append(testCost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}