package com.shivamdenge.Projection.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne // Many appointment to one patient
    @JoinColumn(nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}


//This is Owning Side for Patient