package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mappers.PatientMapper;
import model.Patient;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientMapper patientMapper;
	
	@Transactional
	public void insertPatient(Patient patient) {
		patientMapper.insertPatient(patient);
	}

	public boolean getPatientByLogin(String userName, String password) {
		Patient patient = patientMapper.getPatientByUserName(userName);
		
		if(patient != null && patient.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public boolean getPatientByUserName(String userName) {
		Patient patient = patientMapper.getPatientByUserName(userName);
		
		if(patient != null) {
			return true;
		}
		
		return false;
	}

}
