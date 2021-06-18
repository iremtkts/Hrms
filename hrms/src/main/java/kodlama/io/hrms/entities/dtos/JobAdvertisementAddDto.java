package kodlama.io.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {
	private int id;
	private int cityId;
	private int positionId;
	private int employerId;
	private int maxSalary;
	private int minSalary;
	private String jobDescription;
	private Date releaseDate;
	private Date applicationDeadline;

}
