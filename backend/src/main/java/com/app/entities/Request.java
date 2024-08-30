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
public class Request {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User requester;
    @ManyToOne
    private User donor;
    @ManyToOne
    private BloodBank bloodBank;
    @ManyToOne
    private Hospital hospital;
	@Column
    private BloodGroup bloodType;
	@Column
    private Integer quantity;
	@Column
    private String status;
	@Column
    private LocalDate requestDate;
	@Column
    private LocalDate fulfillDate;
	
	@PrePersist
    protected void onCreate() {
        this.requestDate = LocalDate.now(); // Automatically set requestDate to current date
    }
}
