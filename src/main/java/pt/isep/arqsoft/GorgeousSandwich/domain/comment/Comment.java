package pt.isep.arqsoft.GorgeousSandwich.domain.comment;

import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.SandwichID;
import pt.isep.arqsoft.GorgeousSandwich.domain.shared.Description;
import pt.isep.arqsoft.GorgeousSandwich.domain.shared.IEntity;
import pt.isep.arqsoft.GorgeousSandwich.domain.shared.UserEmail;

public class Comment implements IEntity<Comment> {
	
	private Description description;
	
	private SandwichID sandwichId;

	private UserEmail email;
	
	private CommentID commentId;
	
	public Comment(Description description, SandwichID sandwichId, UserEmail email, CommentID commentId) {
		this.description = description;
		this.sandwichId = sandwichId;
		this.email = email;
		this.commentId = commentId;
	}

	public Comment(Description description, SandwichID sandwichId, UserEmail email) {
		this.description = description;
		this.sandwichId = sandwichId;
		this.email = email;
	}
	
	public Description obtainDescription() {
		return this.description;
	}
	
	public CommentID obtainCommentId() {
		return this.commentId;
	}
	
	public SandwichID obtainSandwichId() {
		return this.sandwichId;
	}

	public UserEmail obtainEmail() { return email; }

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    return sameIdentityAs((Comment) o);
	}
	
	@Override
	public int hashCode() {
		return this.commentId.hashCode();
	}

	@Override
	public boolean sameIdentityAs(Comment other) {
		return other != null && commentId.sameValueAs(other.commentId);
	}
	
	@Override
	public String toString() {
		return this.commentId.toString();
	}

}
