package com.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class OutRecord implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer outID;

    private Integer isDelete;

    private Integer patientID;
    
    private String outSituation;
    
    private String outCost;
    
    private String outCostClear;
    
    private Date outTime;

    private Patient patient;
    
    
    
	public String getOutCostClear() {
		return outCostClear;
	}

	public void setOutCostClear(String outCostClear) {
		this.outCostClear = outCostClear;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getOutID() {
		return outID;
	}

	public void setOutID(Integer outID) {
		this.outID = outID;
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

	public String getOutSituation() {
		return outSituation;
	}

	public void setOutSituation(String outSituation) {
		this.outSituation = outSituation;
	}

	public String getOutCost() {
		return outCost;
	}

	public void setOutCost(String outCost) {
		this.outCost = outCost;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
    
    
}