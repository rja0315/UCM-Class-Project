package service;

import model.Patient;

public interface PatientService {
	void insertPatient(Patient patient);
	boolean getPatientByLogin(String userName, String password);
	boolean getPatientByUserName(String userName);
}
