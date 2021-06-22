package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seeker_language")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class JobSeekerLanguage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_seeker_language_id")
	private int jobSeekerLanguage;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="language_level")
	@Min(1)
	@Max(5)
	private int languageLevel;

}
