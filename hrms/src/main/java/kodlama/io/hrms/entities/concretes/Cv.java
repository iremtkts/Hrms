package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cvs")
//jsonignore

public class Cv {
	@Id
	@Column(name="cv_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cvId;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name="description")
	private String description;
	
	@Column(name="github_adress")
	private String githubAddress;
	
	@Column(name="linkedin_adress")
	private String linkedinAddress;

}
