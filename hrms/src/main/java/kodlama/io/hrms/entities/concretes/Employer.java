package kodlama.io.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")

@PrimaryKeyJoinColumn(name = "id" , referencedColumnName = "id")




public class Employer extends User {
	@Id
	@NotBlank
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "Web Site Alanı Boş Bırakılamaz")
	@Column(name="website_adress")
	private String websiteAdress;
	
	@NotBlank(message = "Şirket Adı  Alanı Boş Bırakılamaz")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Telefon Numara Alanı Boş Bırakılamaz")
	@Column(name="phone_number")
	private String phoneNumber;

}
