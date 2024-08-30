package com.app.entities;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String name;
	@Column
    private String city;
	@Column
    private String address;
	@Column
    private String contact;
	@Column
    private String password;
    @ManyToOne
    private BloodBank bloodBank;
}
