package com.app.entities;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bloodBank_id", referencedColumnName = "id")
    private BloodBank bloodBank;

    @ElementCollection
    @CollectionTable(name = "inventory_blood_types", joinColumns = @JoinColumn(name = "inventory_id"))
    @Column(name = "quantity")
    @MapKeyColumn(name = "bloodType")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<BloodGroup, Integer> bloodTypeQuantities;

    private LocalDate lastUpdated;
}
