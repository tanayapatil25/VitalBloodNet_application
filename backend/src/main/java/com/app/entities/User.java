package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String name;
	@Column
    private String email;
	@Column
    private String password;
	@Column
    private String phoneNumber;
	@Column
    private LocalDate dob;
	@Column
    private String city;
	@Column
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
	@Column
    private Boolean isActiveDonor;

}
