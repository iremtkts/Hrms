package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@Table(name="positions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisement"})
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="position_id")
	private int positionId ;
	
	@NotBlank(message="Pozisyon bilgisi alanı boş girilemez")
	@Column(name="position_name")
	private String positionName;
	
	
	@OneToMany(mappedBy="jobPosition")
	private List <JobAdvertisement> jobAdvertisement;
	
	
	

}
