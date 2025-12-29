package com.focus.SpringBootWebApp.Controller;

import com.focus.SpringBootWebApp.Model.Product;
import com.focus.SpringBootWebApp.Service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServices service ;

    // responsible to accept request from the Product
    @GetMapping ("/products")
    public List<Product> getProducts(){
        return service.getProducts();

    }
    @GetMapping("/products/{prodId}")
    public  Product getProductBuId(@PathVariable int prodId){

        return service.getProductByID(prodId);
    }


    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }
    //Here we are getting json from client but we store object in server-side.It is converted automatically

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
            service.deleteProduct(prodId);
    }
}
