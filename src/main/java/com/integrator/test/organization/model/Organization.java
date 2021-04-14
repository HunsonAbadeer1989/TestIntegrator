package com.integrator.test.organization.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "organization")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, name = "full_name", length = 500)
    private String fullName;

    @Column(nullable = false, length = 12)
    private String inn;

    @Column(nullable = false, length = 10)
    private String kpp;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(length = 50)
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

}
