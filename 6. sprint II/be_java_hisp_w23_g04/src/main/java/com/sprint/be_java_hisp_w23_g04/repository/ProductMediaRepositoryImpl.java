package com.sprint.be_java_hisp_w23_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.entity.Product;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductMediaRepositoryImpl implements IProductMediaRepository {
    private List<Product> products = new ArrayList<>();

    public ProductMediaRepositoryImpl() {
        this.products = loadDataBase();
    }

    private List<Product> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:product.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TypeReference<List<Product>> typeRef = new TypeReference<>() {
        };
        List<Product> products = null;
        try {
            products = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public int getNextPostId(User user) {
        return 1;
    }

    @Override
    public void savePost(User user) {

    }

    @Override
    public List<Product> getByIds(List<Integer> listIds) {
        return products.stream().filter(
                        p -> listIds.contains(p.getId())).
                collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public Product getById(Integer id) {
        return products.stream().filter(p -> id.equals(p.getId())).findFirst().orElse(null);
    }


}
