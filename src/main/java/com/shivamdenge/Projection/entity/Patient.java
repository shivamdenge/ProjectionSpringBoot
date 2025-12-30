package com.shivamdenge.Projection.entity;

import com.shivamdenge.Projection.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroupType;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
