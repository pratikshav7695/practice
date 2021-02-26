package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comments")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "comment_id")
	private int commentId;

	@NotNull
	@ManyToOne(optional = false, targetEntity = Offers.class, fetch =
	 FetchType.EAGER, cascade = CascadeType.ALL)
	 
	  @JoinColumn(name = "fk_offer_id", referencedColumnName = "offer_id")
	 
	private Offers offerId;

	@NotNull
	
	  @ManyToOne(optional = false, targetEntity = Users.class, fetch =
	  FetchType.EAGER, cascade = CascadeType.PERSIST)
	  
	 @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
	 
	private Users userId;

	@NotNull
	@Column(name = "Comments")
	private String Comments;

	@NotNull
	@Column(name = "isLiked")
	private boolean isLiked;

	public Comments() {
		super();
	}

	public Comments(@NotNull int commentId, @NotNull Offers offerId, @NotNull Users userId, @NotNull String comments,
			@NotNull boolean isLiked) {
		super();
		this.commentId = commentId;
		this.offerId = offerId;
		this.userId = userId;
		Comments = comments;
		this.isLiked = isLiked;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Offers getOfferId() {
		return offerId;
	}

	public void setOfferId(Offers offerId) {
		this.offerId = offerId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public boolean isLiked() {
		return isLiked;
	}

	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", offerId=" + offerId + ", userId=" + userId + ", Comments="
				+ Comments + ", isLiked=" + isLiked + "]";
	}

	
}
