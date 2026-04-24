package com.Nithish.E_Commerce.controller;

import com.Nithish.E_Commerce.Service.ProductService;
import com.Nithish.E_Commerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("products")
    public List<Product> getproduct(){
        return service.getAllProducts();
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> GetProductById(@PathVariable  int id){
        Product p= service.getProduct(id);
        if(p!=null) {
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<?> addproduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try {
            Product p=service.addorUpdateProduct(product,imageFile);
            return new ResponseEntity<>(p,HttpStatus.CREATED);
        } catch (IOException e) {
             return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{pid}/image")
    public ResponseEntity<byte[]> getProductById(@PathVariable int pid) {
        Product p = service.getProduct(pid);
        return new ResponseEntity<>(p.getImageData(), HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> Update(@PathVariable Integer id,@RequestPart Product product,@RequestPart MultipartFile imageFile){
            try{
                Product updatedProduct=service.addorUpdateProduct(product,imageFile);
                return new ResponseEntity<>("Updated",HttpStatus.OK);
            }catch(IOException e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> DeleteProduct(@PathVariable Integer id){
        Product p=service.getProduct(id);
        if(p!=null){
            service.deleteproduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No Product",HttpStatus.NOT_FOUND);
        }
        }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> SearchKeyword(@RequestParam String keyword){
        List<Product> ls=service.search(keyword);
        return new ResponseEntity<>(ls,HttpStatus.OK);
    }
    }
