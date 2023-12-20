package com.sprint.be_java_hisp_w23_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellersDTO {
    private List<SellerDTO> sellers;
}
