package com.web.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class IllnessErea implements Serializable {
    private Integer illnessEreaID;

    private Integer isDelete;

    private Integer userId;

    private String illnessEreaName;

    private Integer bedCount;

    private Integer inPeopleCount;

    private Integer outPeopleCount;

    private Float cureRate;
    
    private Float cureRate1;

    private Float betterRate;

    private Float badRate;
    
    private Float deathRate1;

    private Float deathRate;

    private Integer isDiagnoseTrue;

    private Float bedUseRate;
    
    private User user;
    

    public Float getDeathRate1() {
		return deathRate1;
	}

	public void setDeathRate1(Float deathRate1) {
		this.deathRate1 = deathRate1;
	}

	public Float getCureRate1() {
		return cureRate1;
	}

	public void setCureRate1(Float cureRate1) {
		this.cureRate1 = cureRate1;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

    public Integer getIllnessEreaID() {
        return illnessEreaID;
    }

    public void setIllnessEreaID(Integer illnessEreaID) {
        this.illnessEreaID = illnessEreaID;
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

    public String getIllnessEreaName() {
        return illnessEreaName;
    }

    public void setIllnessEreaName(String illnessEreaName) {
        this.illnessEreaName = illnessEreaName;
    }

    public Integer getBedCount() {
        return bedCount;
    }

    public void setBedCount(Integer bedCount) {
        this.bedCount = bedCount;
    }

    public Integer getInPeopleCount() {
        return inPeopleCount;
    }

    public void setInPeopleCount(Integer inPeopleCount) {
        this.inPeopleCount = inPeopleCount;
    }

    public Integer getOutPeopleCount() {
        return outPeopleCount;
    }

    public void setOutPeopleCount(Integer outPeopleCount) {
        this.outPeopleCount = outPeopleCount;
    }

    public Float getCureRate() {
        return cureRate;
    }

    public void setCureRate(Float cureRate) {
        this.cureRate = cureRate;
    }

    public Float getBetterRate() {
        return betterRate;
    }

    public void setBetterRate(Float betterRate) {
        this.betterRate = betterRate;
    }

    public Float getBadRate() {
        return badRate;
    }

    public void setBadRate(Float badRate) {
        this.badRate = badRate;
    }

    public Float getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(Float deathRate) {
        this.deathRate = deathRate;
    }

    public Integer getIsDiagnoseTrue() {
        return isDiagnoseTrue;
    }

    public void setIsDiagnoseTrue(Integer isDiagnoseTrue) {
        this.isDiagnoseTrue = isDiagnoseTrue;
    }

    public Float getBedUseRate() {
        return bedUseRate;
    }

    public void setBedUseRate(Float bedUseRate) {
        this.bedUseRate = bedUseRate;
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
        IllnessErea other = (IllnessErea) that;
        return (this.getIllnessEreaID() == null ? other.getIllnessEreaID() == null : this.getIllnessEreaID().equals(other.getIllnessEreaID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIllnessEreaName() == null ? other.getIllnessEreaName() == null : this.getIllnessEreaName().equals(other.getIllnessEreaName()))
            && (this.getBedCount() == null ? other.getBedCount() == null : this.getBedCount().equals(other.getBedCount()))
            && (this.getInPeopleCount() == null ? other.getInPeopleCount() == null : this.getInPeopleCount().equals(other.getInPeopleCount()))
            && (this.getOutPeopleCount() == null ? other.getOutPeopleCount() == null : this.getOutPeopleCount().equals(other.getOutPeopleCount()))
            && (this.getCureRate() == null ? other.getCureRate() == null : this.getCureRate().equals(other.getCureRate()))
            && (this.getBetterRate() == null ? other.getBetterRate() == null : this.getBetterRate().equals(other.getBetterRate()))
            && (this.getBadRate() == null ? other.getBadRate() == null : this.getBadRate().equals(other.getBadRate()))
            && (this.getDeathRate() == null ? other.getDeathRate() == null : this.getDeathRate().equals(other.getDeathRate()))
            && (this.getIsDiagnoseTrue() == null ? other.getIsDiagnoseTrue() == null : this.getIsDiagnoseTrue().equals(other.getIsDiagnoseTrue()))
            && (this.getBedUseRate() == null ? other.getBedUseRate() == null : this.getBedUseRate().equals(other.getBedUseRate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIllnessEreaID() == null) ? 0 : getIllnessEreaID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIllnessEreaName() == null) ? 0 : getIllnessEreaName().hashCode());
        result = prime * result + ((getBedCount() == null) ? 0 : getBedCount().hashCode());
        result = prime * result + ((getInPeopleCount() == null) ? 0 : getInPeopleCount().hashCode());
        result = prime * result + ((getOutPeopleCount() == null) ? 0 : getOutPeopleCount().hashCode());
        result = prime * result + ((getCureRate() == null) ? 0 : getCureRate().hashCode());
        result = prime * result + ((getBetterRate() == null) ? 0 : getBetterRate().hashCode());
        result = prime * result + ((getBadRate() == null) ? 0 : getBadRate().hashCode());
        result = prime * result + ((getDeathRate() == null) ? 0 : getDeathRate().hashCode());
        result = prime * result + ((getIsDiagnoseTrue() == null) ? 0 : getIsDiagnoseTrue().hashCode());
        result = prime * result + ((getBedUseRate() == null) ? 0 : getBedUseRate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", illnessEreaID=").append(illnessEreaID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", userId=").append(userId);
        sb.append(", illnessEreaName=").append(illnessEreaName);
        sb.append(", bedCount=").append(bedCount);
        sb.append(", inPeopleCount=").append(inPeopleCount);
        sb.append(", outPeopleCount=").append(outPeopleCount);
        sb.append(", cureRate=").append(cureRate);
        sb.append(", betterRate=").append(betterRate);
        sb.append(", badRate=").append(badRate);
        sb.append(", deathRate=").append(deathRate);
        sb.append(", isDiagnoseTrue=").append(isDiagnoseTrue);
        sb.append(", bedUseRate=").append(bedUseRate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}