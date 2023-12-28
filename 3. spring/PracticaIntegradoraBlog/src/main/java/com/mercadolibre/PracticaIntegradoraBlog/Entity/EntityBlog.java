package com.mercadolibre.PracticaIntegradoraBlog.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntityBlog {

    private Long id;
    private String title;
    private String autor;
    private String date;
}
