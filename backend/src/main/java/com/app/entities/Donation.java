package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Donation {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User donor;
    @ManyToOne
    private User receiver;
    @ManyToOne
    private BloodBank bloodBank;
	@Column
    private BloodGroup bloodType;
	@Column
    private Integer quantity;
	@Column
    private LocalDate donationDate;
	@Column
    private Boolean isCompleted;
	
	@PrePersist
    protected void onCreate() {
        if (isCompleted == null) {
            isCompleted = false;
        }
    }
}
