package com.lmig.gfc.charicycle.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Charity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = true)
	private String longInId;
	
	@Column(nullable = true)
	private String password;
	
	@OneToMany(mappedBy = "charity")
	private List<items> items;

	@Column(length = 75, nullable = false)
	private String organizationName;

	@Column(length = 75, nullable = true)
	private String taxId;

	@Column(nullable = true)
	private String address;
	
		@Column(nullable = true)
	private String contactName;
	
	@Column(nullable = true)
	private String emailAddress;
	
	public Charity() {
	};

	public Charity(String organizationName, String taxId, String charitable403Id, String address, String longInIdPassword, String contactName, String emailAddress) {
		
	}

}
