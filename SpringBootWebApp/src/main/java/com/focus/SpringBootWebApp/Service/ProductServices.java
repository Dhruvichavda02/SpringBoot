package com.focus.SpringBootWebApp.Service;

import com.focus.SpringBootWebApp.Model.Product;
import com.focus.SpringBootWebApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service  // This class contains business logic,Spring creates its bean inside ApplicationContext
public class ProductServices {

        @Autowired
        ProductRepo repo;

//        List<Product> products =new ArrayList<>(Arrays.asList(new Product(101,"YSL",50000),
//                    new Product(102,"Channel",70000 ),
//                new Product(103,"Dior",4000 )
//                ));

    // Business Logic
    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductByID(int prodId){
        return repo.findById(prodId).orElse(new Product(23,"",2131));
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }
    public void updateProduct(Product prod){
//        int index= 0;
//        for(int i =0 ;i<products.size();i++){
//                if(products.get(i).getProdId() == prod.getProdId());
//                    index = i ;
//         }
//        products.set(index,prod);
        repo.save(prod);
    }


    public void deleteProduct(int prodId) {
//        products =  products.stream()
//                .filter(p-> p.getProdId() != prodId).toList();
        repo.deleteById(prodId);
    }
}
