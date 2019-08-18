package com.web.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Patient implements Serializable {
    private Integer patientID;

    private Integer isDelete;

    private String patientName;

    private String sex;

    private Date birthday;

    private Integer age;

    private String occupation;

    private String birthPlace;

    private String nation;

    private String ID;

    private String nationality;

    private String workPlace;

    private String tel;

    private String postCode;

    private String permanentAddress;

    private String contactPersonName;

    private String contactPersonAddress;

    private String contactPersonRelationship;

    private String contactPersonTel;

    private String marrySituation;

    
    private List<ChargeProjectSituation> chargeProjectSituations;

    private List<CheckRecord> checkRecords;
    
    private List<DoctorAdvice> doctorAdvices;
    
    private List<Operation> operations;
    
    private List<Prescription> prescriptions;
    
    private List<Registration> registrations;

    
    public List<ChargeProjectSituation> getChargeProjectSituations() {
		return chargeProjectSituations;
	}

	public void setChargeProjectSituations(List<ChargeProjectSituation> chargeProjectSituations) {
		this.chargeProjectSituations = chargeProjectSituations;
	}

	public List<CheckRecord> getCheckRecords() {
		return checkRecords;
	}

	public void setCheckRecords(List<CheckRecord> checkRecords) {
		this.checkRecords = checkRecords;
	}

	public List<DoctorAdvice> getDoctorAdvices() {
		return doctorAdvices;
	}

	public void setDoctorAdvices(List<DoctorAdvice> doctorAdvices) {
		this.doctorAdvices = doctorAdvices;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

    
    private static final long serialVersionUID = 1L;

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getpatientName() {
        return patientName;
    }

    public void setpatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonAddress() {
        return contactPersonAddress;
    }

    public void setContactPersonAddress(String contactPersonAddress) {
        this.contactPersonAddress = contactPersonAddress;
    }

    public String getContactPersonRelationship() {
        return contactPersonRelationship;
    }

    public void setContactPersonRelationship(String contactPersonRelationship) {
        this.contactPersonRelationship = contactPersonRelationship;
    }

    public String getContactPersonTel() {
        return contactPersonTel;
    }

    public void setContactPersonTel(String contactPersonTel) {
        this.contactPersonTel = contactPersonTel;
    }

    public String getMarrySituation() {
        return marrySituation;
    }

    public void setMarrySituation(String marrySituation) {
        this.marrySituation = marrySituation;
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
        Patient other = (Patient) that; 
        return (this.getPatientID() == null ? other.getPatientID() == null : this.getPatientID().equals(other.getPatientID()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getpatientName() == null ? other.getpatientName() == null : this.getpatientName().equals(other.getpatientName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
            && (this.getBirthPlace() == null ? other.getBirthPlace() == null : this.getBirthPlace().equals(other.getBirthPlace()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getID() == null ? other.getID() == null : this.getID().equals(other.getID()))
            && (this.getNationality() == null ? other.getNationality() == null : this.getNationality().equals(other.getNationality()))
            && (this.getWorkPlace() == null ? other.getWorkPlace() == null : this.getWorkPlace().equals(other.getWorkPlace()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getPermanentAddress() == null ? other.getPermanentAddress() == null : this.getPermanentAddress().equals(other.getPermanentAddress()))
            && (this.getContactPersonName() == null ? other.getContactPersonName() == null : this.getContactPersonName().equals(other.getContactPersonName()))
            && (this.getContactPersonAddress() == null ? other.getContactPersonAddress() == null : this.getContactPersonAddress().equals(other.getContactPersonAddress()))
            && (this.getContactPersonRelationship() == null ? other.getContactPersonRelationship() == null : this.getContactPersonRelationship().equals(other.getContactPersonRelationship()))
            && (this.getContactPersonTel() == null ? other.getContactPersonTel() == null : this.getContactPersonTel().equals(other.getContactPersonTel()))
            && (this.getMarrySituation() == null ? other.getMarrySituation() == null : this.getMarrySituation().equals(other.getMarrySituation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPatientID() == null) ? 0 : getPatientID().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getpatientName() == null) ? 0 : getpatientName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getBirthPlace() == null) ? 0 : getBirthPlace().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getID() == null) ? 0 : getID().hashCode());
        result = prime * result + ((getNationality() == null) ? 0 : getNationality().hashCode());
        result = prime * result + ((getWorkPlace() == null) ? 0 : getWorkPlace().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getPermanentAddress() == null) ? 0 : getPermanentAddress().hashCode());
        result = prime * result + ((getContactPersonName() == null) ? 0 : getContactPersonName().hashCode());
        result = prime * result + ((getContactPersonAddress() == null) ? 0 : getContactPersonAddress().hashCode());
        result = prime * result + ((getContactPersonRelationship() == null) ? 0 : getContactPersonRelationship().hashCode());
        result = prime * result + ((getContactPersonTel() == null) ? 0 : getContactPersonTel().hashCode());
        result = prime * result + ((getMarrySituation() == null) ? 0 : getMarrySituation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patientID=").append(patientID);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", patientName=").append(patientName);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", age=").append(age);
        sb.append(", occupation=").append(occupation);
        sb.append(", birthPlace=").append(birthPlace);
        sb.append(", nation=").append(nation);
        sb.append(", ID=").append(ID);
        sb.append(", nationality=").append(nationality);
        sb.append(", workPlace=").append(workPlace);
        sb.append(", tel=").append(tel);
        sb.append(", postCode=").append(postCode);
        sb.append(", permanentAddress=").append(permanentAddress);
        sb.append(", contactPersonName=").append(contactPersonName);
        sb.append(", contactPersonAddress=").append(contactPersonAddress);
        sb.append(", contactPersonRelationship=").append(contactPersonRelationship);
        sb.append(", contactPersonTel=").append(contactPersonTel);
        sb.append(", marrySituation=").append(marrySituation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
