package com.app.entities;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BloodBank {	
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
	 @ElementCollection(fetch = FetchType.EAGER) // Change to EAGER
	 @CollectionTable(name = "blood_bank_blood_types", joinColumns = @JoinColumn(name = "blood_bank_id"))
	 @Enumerated(EnumType.STRING)
	 private List<BloodGroup> availableBloodTypes;

	 @OneToOne(mappedBy = "bloodBank", cascade = CascadeType.ALL)
	 private Inventory inventory;
}
