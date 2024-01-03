package com.mercadolibre.be_java_hisp_w23_g2.dto.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDTO {

  private String explanation;
  private List<String> message;
}
