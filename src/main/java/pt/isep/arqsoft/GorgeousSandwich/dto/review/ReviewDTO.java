package pt.isep.arqsoft.GorgeousSandwich.dto.review;

public class ReviewDTO {

	private Long reviewId;
	
	private String description;

	private Integer grade;

	private Long sandwichId;

	private String email;
	
	public ReviewDTO(Long reviewId, String description, Integer grade, Long sandwichId,String email) {
		this.reviewId = reviewId;
		this.description = description;
		this.grade = grade;
		this.sandwichId = sandwichId;
		this.email = email;
	}
	
	public ReviewDTO(String description, Integer grade, Long sandwichId, String email) {
		this.description = description;
		this.grade = grade;
		this.sandwichId = sandwichId;
		this.email = email;
	}

	public String obtainDescription() {
		return description;
	}

	public Integer obtainGrade() {
		return grade;
	}

	public Long obtainSandwichId() {
		return sandwichId;
	}

	public String obtainEmail() {
		return email;
	}
}
