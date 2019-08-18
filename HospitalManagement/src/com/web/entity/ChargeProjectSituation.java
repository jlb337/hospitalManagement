package com.web.entity;

import java.io.Serializable;

public class ChargeProjectSituation implements Serializable {
    private Integer chargeID;

    //外键 patientID
    private Integer patientID;
    
    private Patient patient;

	private Integer chargeType;

    private Float chargeTypeMoney;

    private Integer flagCheckOut;

    private Integer flagTransfer;

    private Integer isDelete;
    

    private static final long serialVersionUID = 1L;


    
    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
    
    public Integer getChargeID() {
        return chargeID;
    }

    public void setChargeID(Integer chargeID) {
        this.chargeID = chargeID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Float getChargeTypeMoney() {
        return chargeTypeMoney;
    }

    public void setChargeTypeMoney(Float chargeTypeMoney) {
        this.chargeTypeMoney = chargeTypeMoney;
    }

    public Integer getFlagCheckOut() {
        return flagCheckOut;
    }

    public void setFlagCheckOut(Integer flagCheckOut) {
        this.flagCheckOut = flagCheckOut;
    }

    public Integer getFlagTransfer() {
        return flagTransfer;
    }

    public void setFlagTransfer(Integer flagTransfer) {
        this.flagTransfer = flagTransfer;
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
        ChargeProjectSituation other = (ChargeProjectSituation) that;
        return (this.getChargeID() == null ? other.getChargeID() == null : this.getChargeID().equals(other.getChargeID()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getChargeTypeMoney() == null ? other.getChargeTypeMoney() == null : this.getChargeTypeMoney().equals(other.getChargeTypeMoney()))
            && (this.getFlagCheckOut() == null ? other.getFlagCheckOut() == null : this.getFlagCheckOut().equals(other.getFlagCheckOut()))
            && (this.getFlagTransfer() == null ? other.getFlagTransfer() == null : this.getFlagTransfer().equals(other.getFlagTransfer()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChargeID() == null) ? 0 : getChargeID().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getChargeTypeMoney() == null) ? 0 : getChargeTypeMoney().hashCode());
        result = prime * result + ((getFlagCheckOut() == null) ? 0 : getFlagCheckOut().hashCode());
        result = prime * result + ((getFlagTransfer() == null) ? 0 : getFlagTransfer().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chargeID=").append(chargeID);
        sb.append(", patientID=").append(patientID);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", chargeTypeMoney=").append(chargeTypeMoney);
        sb.append(", flagCheckOut=").append(flagCheckOut);
        sb.append(", flagTransfer=").append(flagTransfer);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
