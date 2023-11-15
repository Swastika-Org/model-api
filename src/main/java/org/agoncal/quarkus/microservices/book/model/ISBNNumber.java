package org.agoncal.quarkus.microservices.book.model;

import java.time.Instant;

public class ISBNNumber {

	private String isbnNumber;
	private Instant creationTime;

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	
	public Instant getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Instant creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "ISBNNumber [isbnNumber=" + isbnNumber + ", creationTime=" + creationTime + "]";
	}

}
