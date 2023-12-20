package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowedListDTO {

    @JsonProperty("user_id")
    public Long userID;
    @JsonProperty("user_name")
    public String userName;
    public List<SellerDTO> followed;
}
