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
@Table(name = "sports")
public class Sports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "sport_id")
	private int sportId;

	@NotNull
	@Size(min = 3, max = 50, message = "Sport name must be between 3 and 50 characters")
	@Column(name = "sport_name")
	private String sportName;

	@NotNull
	@Min(value = 1000, message = "Sports Fees should be greater than 1000")
	@Max(value = 100000, message = "Sports Fees should be less than 1,00,000")
	@Column(name = "sport_fees")
	private double sportFees;

	public Sports() {
		super();
	}

	public Sports(@NotNull int sportId,
			@NotNull @Size(min = 3, max = 50, message = "Sport name must be between 3 and 50 characters") String sportName,
			@NotNull @Min(value = 1000, message = "Sports Fees should be greater than 1000") @Max(value = 100000, message = "Sports Fees should be less than 1,00,000") double sportFees) {
		super();
		this.sportId = sportId;
		this.sportName = sportName;
		this.sportFees = sportFees;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public double getSportFees() {
		return sportFees;
	}

	public void setSportFees(double sportFees) {
		this.sportFees = sportFees;
	}

	@Override
	public String toString() {
		return "Sports [sportId=" + sportId + ", sportName=" + sportName + ", sportFees=" + sportFees + "]";
	}

}
