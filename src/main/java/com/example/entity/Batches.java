package com.example.entity;

import java.time.LocalTime;
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
@Table(name = "batches")
public class Batches {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "batch_id")
	private int batchId;

	@NotNull
	@Column(name = "batch_name")
	@Size(min = 3, max = 50, message = "Batch name must be between 3 and 50 characters")
	private String batchName;

	@NotNull
	@Column(name = "batch_start_time")
	private LocalTime batchStartTime;

	@NotNull
	@Column(name = "batch_end_time")
	private LocalTime batchEndTime;

	@NotNull
	@Column(name = "batch_size")
	@Min(value = 10, message = "Batch size should be greater than 10")
	@Max(value = 100, message = "Batch size should be less than 100")
	private int batchSize;

	@NotNull
	@Column(name = "batch_remaining_seats")
	@Min(value = 0, message = "Batch size should be greater than 0")
	@Max(value = 100, message = "Batch size should be less than 100")
	private int batchRemainingSeats;

	public Batches() {
		super();
	}

	public Batches(@NotNull int batchId,
			@NotNull @Size(min = 3, max = 50, message = "Batch name must be between 3 and 50 characters") String batchName,
			@NotNull LocalTime batchStartTime, @NotNull LocalTime batchEndTime,
			@NotNull @Min(value = 10, message = "Batch size should be greater than 10") @Max(value = 100, message = "Batch size should be less than 100") int batchSize,
			@NotNull @Min(value = 0, message = "Batch size should be greater than 0") @Max(value = 100, message = "Batch size should be less than 100") int batchRemainingSeats) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchStartTime = batchStartTime;
		this.batchEndTime = batchEndTime;
		this.batchSize = batchSize;
		this.batchRemainingSeats = batchRemainingSeats;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public LocalTime getBatchStartTime() {
		return batchStartTime;
	}

	public void setBatchStartTime(LocalTime batchStartTime) {
		this.batchStartTime = batchStartTime;
	}

	public LocalTime getBatchEndTime() {
		return batchEndTime;
	}

	public void setBatchEndTime(LocalTime batchEndTime) {
		this.batchEndTime = batchEndTime;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public int getBatchRemainingSeats() {
		return batchRemainingSeats;
	}

	public void setBatchRemainingSeats(int batchRemainingSeats) {
		this.batchRemainingSeats = batchRemainingSeats;
	}

	@Override
	public String toString() {
		return "Batches [batchId=" + batchId + ", batchName=" + batchName + ", batchStartTime=" + batchStartTime
				+ ", batchEndTime=" + batchEndTime + ", batchSize=" + batchSize + ", batchRemainingSeats="
				+ batchRemainingSeats + "]";
	}

}
