package com.RestAPIdb.RestApiDB.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="nutrients")
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long carbs;
    private Long proteins;
    private Long fats;
    private Long fibers;
    private Long vitamins;
    private Float IG;
    @JsonBackReference
    @OneToOne(mappedBy = "nutrient")
    private FoodItem foodItem;

}