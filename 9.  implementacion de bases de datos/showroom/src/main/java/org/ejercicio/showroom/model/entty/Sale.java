package org.ejercicio.showroom.model.entty;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("sale")
@Document(indexName = "sale")
public class Sale {
    @Id
    private String id;
    private Integer number;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Field(type = Date, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Clothes> clothesList;
}
