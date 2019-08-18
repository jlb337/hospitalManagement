package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class CheckProject implements Serializable {
    private Integer checkID;

    private Integer isDelete;

    private String checkRecord;

    private String checkAnalysis;

    private Float checkCharge;

    private String checkName;

    public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	private static final long serialVersionUID = 1L;

    public Integer getCheckID() {
        return checkID;
    }

    public void setCheckID(Integer checkID) {
        this.checkID = checkID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCheckRecord() {
        return checkRecord;
    }

    public void setCheckRecord(String checkRecord) {
        this.checkRecord = checkRecord;
    }

    public String getCheckAnalysis() {
        return checkAnalysis;
    }

    public void setCheckAnalysis(String checkAnalysis) {
        this.checkAnalysis = checkAnalysis;
    }

    public Float getCheckCharge() {
        return checkCharge;
    }

    public void setCheckCharge(Float checkCharge) {
        this.checkCharge = checkCharge;
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
        CheckProject other = (CheckProject) that;
        return (this.getCheckID() == null ? other.getCheckID() == null : this.getCheckID().equals(other.getCheckID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getCheckRecord() == null ? other.getCheckRecord() == null : this.getCheckRecord().equals(other.getCheckRecord()))
            && (this.getCheckAnalysis() == null ? other.getCheckAnalysis() == null : this.getCheckAnalysis().equals(other.getCheckAnalysis()))
            && (this.getCheckCharge() == null ? other.getCheckCharge() == null : this.getCheckCharge().equals(other.getCheckCharge()))
            && (this.getCheckName() == null ? other.getCheckName() == null : this.getCheckName().equals(other.getCheckName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCheckID() == null) ? 0 : getCheckID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCheckRecord() == null) ? 0 : getCheckRecord().hashCode());
        result = prime * result + ((getCheckAnalysis() == null) ? 0 : getCheckAnalysis().hashCode());
        result = prime * result + ((getCheckCharge() == null) ? 0 : getCheckCharge().hashCode());
        result = prime * result + ((getCheckName() == null) ? 0 : getCheckName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkID=").append(checkID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", checkRecord=").append(checkRecord);
        sb.append(", checkAnalysis=").append(checkAnalysis);
        sb.append(", checkCharge=").append(checkCharge);
        sb.append(", checkName=").append(checkName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}