package com.RestAPIdb.RestApiDB.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fooditems")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long calories;
    @ManyToMany(mappedBy = "foodItemList", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Menu> menuList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "nutrient_id", referencedColumnName = "id")
    private Nutrient nutrient;
}
