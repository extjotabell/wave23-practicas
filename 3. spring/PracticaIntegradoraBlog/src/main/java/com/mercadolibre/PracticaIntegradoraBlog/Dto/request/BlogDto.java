package com.mercadolibre.PracticaIntegradoraBlog.Dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogDto {

    private String title;
    private String autor;
    private String date;

}
