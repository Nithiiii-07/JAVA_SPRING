package com.Nithish.E_Commerce.Service;

import com.Nithish.E_Commerce.Repo.ProductRepo;
import com.Nithish.E_Commerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    public Product getProduct(int id){
        return repo.findById(id).orElse(null);
    }
    public Product addorUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getName());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return repo.save(product);
    }
    public void deleteproduct(Integer id){
        repo.deleteById(id);
    }
    public List<Product> search(String keyword){
        return repo.searchbyKey(keyword);
    }
}
