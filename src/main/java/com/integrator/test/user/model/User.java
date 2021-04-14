package com.integrator.test.user.model;

import com.integrator.test.country.model.Country;
import com.integrator.test.document.model.Document;
import com.integrator.test.office.model.Office;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToOne(mappedBy="user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Document document;

}
