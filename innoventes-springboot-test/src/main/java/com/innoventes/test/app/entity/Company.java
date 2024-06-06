package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import annotations.EvenNumberOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name", nullable = false)
	@NotBlank(message = "Company name is mandatory")
	@Size(min = 5,message = "Company name should be atleast 5 character")
	private String companyName;

	@Column(name = "email", nullable = false)
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Column(name = "strength")
	@EvenNumberOrZero
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;
	
	@Pattern(regexp = "[A-Za-z]{2}[0-9]{2}[ENen]", message = "Invalid company code format")
    private String companyCode;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}


}
