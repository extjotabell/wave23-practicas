package com.sprint.be_java_hisp_w23_g04.utils;


import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.*;

import java.time.LocalDate;
import java.util.List;

public class IntegrationUtils {

    public static ProductDTO getProductDTO() {
        return new ProductDTO(1, "Silla gamer", "Gamer", "Racer", "Red", "Special Edition");
    }

    public static PostDTO getPostDTO() {
        return new PostDTO(1, LocalDate.now(), getProductDTO(), 100, 100.00);
    }
}
