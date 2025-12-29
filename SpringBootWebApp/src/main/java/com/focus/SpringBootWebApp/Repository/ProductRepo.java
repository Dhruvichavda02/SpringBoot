package com.focus.SpringBootWebApp.Repository;

import com.focus.SpringBootWebApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> // class name.Primary_key_dataType
{

}
