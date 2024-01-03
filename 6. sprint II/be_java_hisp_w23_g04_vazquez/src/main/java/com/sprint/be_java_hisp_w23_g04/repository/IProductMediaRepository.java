package com.sprint.be_java_hisp_w23_g04.repository;

import com.sprint.be_java_hisp_w23_g04.entity.Product;
import com.sprint.be_java_hisp_w23_g04.entity.User;

import java.util.List;

public interface IProductMediaRepository {

    List<Product> getByIds(List<Integer> listIds);

    Product getById(Integer id);
}
