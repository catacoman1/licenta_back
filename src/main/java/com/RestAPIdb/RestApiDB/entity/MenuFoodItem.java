package com.RestAPIdb.RestApiDB.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MENU_FOODITEMS_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuFoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "fooditem_id", referencedColumnName = "id")
    private FoodItem foodItem;

    @Column(nullable = false)
    private Float quantity;
}
