package mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import model.Patient;

public interface PatientMapper {
	@Insert("INSERT INTO patient(userName, password, firstName,"
			+ "lastName, dateOfBirth, emailAddress) VALUES"
			+ "(#{userName},#{password}, #{firstName}, #{lastName},"
			+ "#{dateOfBirth}, #{emailAddress})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertPatient(Patient patient);
		
	@Select("SELECT USERNAME as userName, PASSWORD as password, "
			+ "FIRSTNAME as firstName, LASTNAME as lastName, "
			+ "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
			+ "FROM patient WHERE userName = #{userName}")
	public Patient getPatientByUserName(String userName);


}
