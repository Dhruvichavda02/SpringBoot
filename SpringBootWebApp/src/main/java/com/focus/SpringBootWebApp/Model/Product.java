package com.focus.SpringBootWebApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString(), equals()
@AllArgsConstructor // creates constructor for you
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int price;
}
