package com.kbaez.karinabaezch.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "prices")
@Accessors(chain = true)
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String lprice;
	private String curr1;
	private String curr2;
	@Column(name = "create_date")
	private LocalDateTime createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLprice() {
		return lprice;
	}
	public void setLprice(String lprice) {
		this.lprice = lprice;
	}
	public String getCurr1() {
		return curr1;
	}
	public void setCurr1(String curr1) {
		this.curr1 = curr1;
	}
	public String getCurr2() {
		return curr2;
	}
	public void setCurr2(String curr2) {
		this.curr2 = curr2;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime localDateTime) {
		this.createDate = localDateTime;
	}
	
	
}
