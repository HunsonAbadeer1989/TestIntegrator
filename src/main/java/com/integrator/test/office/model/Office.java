package com.integrator.test.office.model;

import com.integrator.test.organization.model.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "office")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(length = 50)
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

}
