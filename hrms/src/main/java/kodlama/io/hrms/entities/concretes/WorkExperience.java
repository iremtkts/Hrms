package kodlama.io.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class WorkExperience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="work_experience_id")
	private int workExperienceId;
	
	@ManyToOne(targetEntity=Cv.class)
	private Cv cv;
	
	@ManyToOne(targetEntity=JobPosition.class,fetch = FetchType.LAZY)
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	@Column(name="workplace_name")
	private String workplaceName;
	
	@Column(name="starting_date")
	private Date startingDate;
	
	@Column(name="ending_date")
	private Date endingDate;

}
