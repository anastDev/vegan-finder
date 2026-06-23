package com.anastDev.vegan_finder.model;


import com.anastDev.vegan_finder.core.enums.GenderType;
import com.anastDev.vegan_finder.core.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<SavedRestaurant> savedRestaurants = new HashSet<>();

    public String getFullname() {
        return firstname + " " + lastname;
    }

    @PrePersist
    public void initializeUUID(){
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }

    public void saveRestaurant(SavedRestaurant s) {
        savedRestaurants.add(s);
        s.setUser(this);
    }

    public void removeBorrow(SavedRestaurant s) {
        savedRestaurants.remove(s);
        s.setUser(null);
    }
}

