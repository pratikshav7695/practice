package com.example.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "enrollment")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "enrollment_id")
	private int enrollmentId;

	@OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
	@NotNull
	private Users userId;

	@OneToOne(targetEntity = Batches.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_batch_id", referencedColumnName = "batch_id")
	@NotNull
	private Batches batchId;

	@OneToOne(targetEntity = Offers.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_offer_id", referencedColumnName = "offer_id")
	@NotNull
	private Offers offerId;

	@OneToOne(targetEntity = Sports.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_sport_id", referencedColumnName = "sport_id")
	@NotNull
	private Sports sportId;

	@NotNull
	@Column(name = "enrollmentStartDate")
	private Date enrollmentStartDate;

	@NotNull
	@Column(name = "enrollmentEndDate")
	private Date enrollmentEndDate;

	@NotNull
	@Column(name = "enrollmentPayableFees")
	private double enrollmentPayableFees;

	public Enrollment() {
		super();
	}

	public Enrollment(@NotNull int enrollmentId, @NotNull Users userId, @NotNull Batches batchId,
			@NotNull Offers offerId, @NotNull Sports sportId, @NotNull Date enrollmentStartDate,
			@NotNull Date enrollmentEndDate, @NotNull double enrollmentPayableFees) {
		super();
		this.enrollmentId = enrollmentId;
		this.userId = userId;
		this.batchId = batchId;
		this.offerId = offerId;
		this.sportId = sportId;
		this.enrollmentStartDate = enrollmentStartDate;
		this.enrollmentEndDate = enrollmentEndDate;
		this.enrollmentPayableFees = enrollmentPayableFees;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Batches getBatchId() {
		return batchId;
	}

	public void setBatchId(Batches batchId) {
		this.batchId = batchId;
	}

	public Offers getOfferId() {
		return offerId;
	}

	public void setOfferId(Offers offerId) {
		this.offerId = offerId;
	}

	public Sports getSportId() {
		return sportId;
	}

	public void setSportId(Sports sportId) {
		this.sportId = sportId;
	}

	public Date getEnrollmentStartDate() {
		return enrollmentStartDate;
	}

	public void setEnrollmentStartDate(Date enrollmentStartDate) {
		this.enrollmentStartDate = enrollmentStartDate;
	}

	public Date getEnrollmentEndDate() {
		return enrollmentEndDate;
	}

	public void setEnrollmentEndDate(Date enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}

	public double getEnrollmentPayableFees() {
		return enrollmentPayableFees;
	}

	public void setEnrollmentPayableFees(double enrollmentPayableFees) {
		this.enrollmentPayableFees = enrollmentPayableFees;
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", userId=" + userId + ", batchId=" + batchId + ", offerId="
				+ offerId + ", sportId=" + sportId + ", enrollmentStartDate=" + enrollmentStartDate
				+ ", enrollmentEndDate=" + enrollmentEndDate + ", enrollmentPayableFees=" + enrollmentPayableFees + "]";
	}

	

	

	

}
