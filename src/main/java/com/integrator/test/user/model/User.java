package com.integrator.test.user.model;

import com.integrator.test.country.model.Country;
import com.integrator.test.office.model.Office;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "second_name", nullable = false, length = 50)
    private String secondName;

    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;

    @Column(nullable = false, length = 50)
    private String position;

    @Column(length = 50)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "is_identified")
    private boolean isIdentified;

}
