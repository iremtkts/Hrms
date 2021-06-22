package kodlama.io.hrms.entities.concretes;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "job_seeker_id")
@JsonIgnoreProperties({"hibernateLazyInitiliazer" , "handler","cv"})


public class JobSeeker extends User {

	@NotBlank(message = "İsim alanı boş bırakılmaz")
	@Size(min = 3, message = "İsim alanında en az 3 karakter kullanmanız gerekiyor")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim alanı boş bırakılmaz")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message ="Doğum yılı alanı boş bırakılamaz" )
	@Column(name="birth_date")
	private Date birthDate;
	
	@NotBlank(message = "Tc kimlik numarası alanı boş bırakılmaz")
    @Size(min = 11, max=11, message = "TCKimlik No 11 hane olmalıdır")
	@Column(name="identity_number")
	private String identityNumber;

	@JsonIgnore
	@OneToMany(mappedBy="jobSeeker")
	private List <Cv> cv;
	
		
		

	

}