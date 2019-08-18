package com.web.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.entity.PatientHistory;

public interface PatientHistoryBiz {
	public boolean insert(PatientHistory patientHistory);
	public List<PatientHistory> queryByCondition(PatientHistory patientHistory);
	public PatientHistory findById(@Param("patientHistoryID") Integer patientHistoryID);
	public boolean update(PatientHistory patientHistory);
	public boolean delete(PatientHistory patientHistory);
}
