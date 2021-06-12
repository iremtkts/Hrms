package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="system_personnels")
@EqualsAndHashCode(callSuper=false)

public class SystemPersonnel extends User {
	
	@NotBlank(message= "isim alanı boş bırakılamaz")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message= "soyisim alanı boş bırakılamaz")
	@Column(name="last_name")
	private String lastName;

}
