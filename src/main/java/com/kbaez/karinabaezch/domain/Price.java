package com.kbaez.karinabaezch.domain;

import java.sql.Timestamp;

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
@Getter
@Setter
@Accessors(chain = true)
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String lprice;
	private String curr1;
	private String curr2;
	private Timestamp createDate;
}
