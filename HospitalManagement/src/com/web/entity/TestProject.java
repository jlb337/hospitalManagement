package com.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 门诊检验项目
 * @author guokaixin
 *
 */
public class TestProject implements Serializable {
	
	private User user;
    private PatientHistory patientHistory;

    public PatientHistory getPatientHistory() {
		return patientHistory;
	}

	public void setPatientHistory(PatientHistory patientHistory) {
		this.patientHistory = patientHistory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Integer testID;
	
	private Integer isDelete;

    private Integer patientHistoryID;

    private Integer userId;

    private Date testDate;

    private String testAnalysis;

    private String testRecord;

    private String testResult;

    private Float testCharge;

    private static final long serialVersionUID = 1L;

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getPatientHistoryID() {
        return patientHistoryID;
    }

    public void setPatientHistoryID(Integer patientHistoryID) {
        this.patientHistoryID = patientHistoryID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestAnalysis() {
        return testAnalysis;
    }

    public void setTestAnalysis(String testAnalysis) {
        this.testAnalysis = testAnalysis;
    }

    public String getTestRecord() {
        return testRecord;
    }

    public void setTestRecord(String testRecord) {
        this.testRecord = testRecord;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public Float getTestCharge() {
        return testCharge;
    }

    public void setTestCharge(Float testCharge) {
        this.testCharge = testCharge;
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
        TestProject other = (TestProject) that;
        return (this.getTestID() == null ? other.getTestID() == null : this.getTestID().equals(other.getTestID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getPatientHistoryID() == null ? other.getPatientHistoryID() == null : this.getPatientHistoryID().equals(other.getPatientHistoryID()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTestDate() == null ? other.getTestDate() == null : this.getTestDate().equals(other.getTestDate()))
            && (this.getTestAnalysis() == null ? other.getTestAnalysis() == null : this.getTestAnalysis().equals(other.getTestAnalysis()))
            && (this.getTestRecord() == null ? other.getTestRecord() == null : this.getTestRecord().equals(other.getTestRecord()))
            && (this.getTestResult() == null ? other.getTestResult() == null : this.getTestResult().equals(other.getTestResult()))
            && (this.getTestCharge() == null ? other.getTestCharge() == null : this.getTestCharge().equals(other.getTestCharge()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTestID() == null) ? 0 : getTestID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getPatientHistoryID() == null) ? 0 : getPatientHistoryID().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTestDate() == null) ? 0 : getTestDate().hashCode());
        result = prime * result + ((getTestAnalysis() == null) ? 0 : getTestAnalysis().hashCode());
        result = prime * result + ((getTestRecord() == null) ? 0 : getTestRecord().hashCode());
        result = prime * result + ((getTestResult() == null) ? 0 : getTestResult().hashCode());
        result = prime * result + ((getTestCharge() == null) ? 0 : getTestCharge().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testID=").append(testID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", patientHistoryID=").append(patientHistoryID);
        sb.append(", userId=").append(userId);
        sb.append(", testDate=").append(testDate);
        sb.append(", testAnalysis=").append(testAnalysis);
        sb.append(", testRecord=").append(testRecord);
        sb.append(", testResult=").append(testResult);
        sb.append(", testCharge=").append(testCharge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
