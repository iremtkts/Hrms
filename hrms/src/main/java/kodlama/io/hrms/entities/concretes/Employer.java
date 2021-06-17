package kodlama.io.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "employer_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisement"})



public class Employer extends User {

	@NotBlank(message = "Web Site Alanı Boş Bırakılamaz")
	@Column(name="website_adress")
	private String websiteAdress;
	
	@NotBlank(message = "Şirket Adı  Alanı Boş Bırakılamaz")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Telefon Numara Alanı Boş Bırakılamaz")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@Transient
	private boolean confirm ;
	
	@JsonIgnore
	@OneToMany(mappedBy= "employer")
	private List<JobAdvertisement> jobAdvertisements;

}
