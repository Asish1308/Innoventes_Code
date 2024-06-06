package com.innoventes.test.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;
	@NotBlank(message = "Company name is mandatory")
    @Size(min = 5, message = "Company name should be at least 5 characters")
	private String companyName;
	
	@Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
	private String email;
	
	@Min(value = 0, message = "Strength should be positive or zero")
	private Integer strength;
	
	private String webSiteURL;
	
	@Pattern(regexp = "[A-Za-z]{2}[0-9]{2}[ENen]", message = "Invalid company code format")
    private String companyCode;

}
