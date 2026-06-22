package com.anastDev.vegan_finder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "restaurants")
public class Restaurant extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String googlePlaceId;

    private String name;
    private String address;
    private Double lat;
    private Double lng;
    private Double rating;
    private String websiteUri;
    private Boolean veganFriendly;

    @OneToMany(mappedBy = "restaurant")
    private Set<SavedRestaurant> savedRestaurants = new HashSet<>();
}
