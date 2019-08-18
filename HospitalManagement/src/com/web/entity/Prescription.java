package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**Prescription
 * @author 
 */
public class Prescription implements Serializable {
    private Integer prescriptionID2;

    private Integer isDelete;

    private Integer patientID;

    private String prescriptionContent;

    private String note;

    private Date prescriptionDate;

    private Float prescriptionCost;


	Drug drug;
    
    public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	Patient patient;

    public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	private static final long serialVersionUID = 1L;

    public Integer getPrescriptionID2() {
        return prescriptionID2;
    }

    public void setPrescriptionID2(Integer prescriptionID2) {
        this.prescriptionID2 = prescriptionID2;
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

    public String getPrescriptionContent() {
        return prescriptionContent;
    }

    public void setPrescriptionContent(String prescriptionContent) {
        this.prescriptionContent = prescriptionContent;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Float getPrescriptionCost() {
        return prescriptionCost;
    }

    public void setPrescriptionCost(Float prescriptionCost) {
        this.prescriptionCost = prescriptionCost;
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
        Prescription other = (Prescription) that;
        return (this.getPrescriptionID2() == null ? other.getPrescriptionID2() == null : this.getPrescriptionID2().equals(other.getPrescriptionID2()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getPrescriptionContent() == null ? other.getPrescriptionContent() == null : this.getPrescriptionContent().equals(other.getPrescriptionContent()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getPrescriptionDate() == null ? other.getPrescriptionDate() == null : this.getPrescriptionDate().equals(other.getPrescriptionDate()))
            && (this.getPrescriptionCost() == null ? other.getPrescriptionCost() == null : this.getPrescriptionCost().equals(other.getPrescriptionCost()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPrescriptionID2() == null) ? 0 : getPrescriptionID2().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getPrescriptionContent() == null) ? 0 : getPrescriptionContent().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getPrescriptionDate() == null) ? 0 : getPrescriptionDate().hashCode());
        result = prime * result + ((getPrescriptionCost() == null) ? 0 : getPrescriptionCost().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", prescriptionID2=").append(prescriptionID2);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", patientID=").append(patientID);
        sb.append(", prescriptionContent=").append(prescriptionContent);
        sb.append(", note=").append(note);
        sb.append(", prescriptionDate=").append(prescriptionDate);
        sb.append(", prescriptionCost=").append(prescriptionCost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}