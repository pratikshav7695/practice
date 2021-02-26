package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "offers")
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	/* @OneToOne(mappedBy = "offerId") */
	@Column(name = "offer_id")
	private int offerId;

	@NotNull
	@Column(name = "offer_name")
	@Size(min = 3, max = 50, message = "Offer name must be between 3 and 50 characters")
	private String offerName;

	@NotNull
	@Column(name = "offer_duration")
	@Min(value = 0, message = "Offer Duration should be greater than 0")
	@Max(value = 12, message = "Offer Duration should be less than 12")
	private int offerDuration;

	@Column(name = "offer_discount")
	@NotNull
	private int offerDiscount;

	@Column(name = "likes_on_offer")
	private int likesOnOffer;

	public Offers() {
		super();
	}

	public Offers(@NotNull int offerId,
			@NotNull @Size(min = 3, max = 50, message = "Offer name must be between 3 and 50 characters") String offerName,
			@NotNull @Min(value = 0, message = "Offer Duration should be greater than 0") @Max(value = 12, message = "Offer Duration should be less than 12") int offerDuration,
			@NotNull int offerDiscount, int likesOnOffer) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerDuration = offerDuration;
		this.offerDiscount = offerDiscount;
		this.likesOnOffer = likesOnOffer;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public int getOfferDuration() {
		return offerDuration;
	}

	public void setOfferDuration(int offerDuration) {
		this.offerDuration = offerDuration;
	}

	public int getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(int offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

	public int getLikesOnOffer() {
		return likesOnOffer;
	}

	public void setLikesOnOffer(int likesOnOffer) {
		this.likesOnOffer = likesOnOffer;
	}

	@Override
	public String toString() {
		return "Offers [offerId=" + offerId + ", offerName=" + offerName + ", offerDuration=" + offerDuration
				+ ", offerDiscount=" + offerDiscount + ", likesOnOffer=" + likesOnOffer + "]";
	}

}
