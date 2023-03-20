package pt.isep.arqsoft.GorgeousSandwich.dto.comment;

public class CommentDTO {
	
	private Long commentId;
	
	private String description;
	
	private Long sandwichId;

	private String email;
	
	public CommentDTO(Long commentId, String description, Long sandwichId, String email) {
		this.commentId = commentId;
		this.description = description;
		this.sandwichId = sandwichId;
		this.email = email;
	}
	
	public CommentDTO(String description, Long sandwichId, String email) {
		this.description = description;
		this.sandwichId = sandwichId;
		this.email = email;
	}

	public Long obtainCommentId() {
		return this.commentId;
	}

	public String obtainDescription() {
		return this.description;
	}

	public Long obtainSandwichId() {
		return this.sandwichId;
	}

	public String obtainEmail() { return email; }

}
