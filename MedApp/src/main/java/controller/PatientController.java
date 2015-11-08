package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Patient;
import model.PatientLogin;
import service.PatientService;

@Controller
@SessionAttributes("patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("patient") Patient patient, Model model) {
		if(patientService.getPatientByUserName(patient.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			patientService.insertPatient(patient);
			model.addAttribute("message", "Saved patient details");
			return "redirect:login.html";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		PatientLogin patientLogin = new PatientLogin();
		model.addAttribute("patientLogin", patientLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("patientLogin") PatientLogin patientLogin) {
		boolean found = patientService.getPatientByLogin(patientLogin.getUserName(), patientLogin.getPassword());
		if (found) {				
			return "success";
		} else {				
			return "failure";
		}
	}
}
