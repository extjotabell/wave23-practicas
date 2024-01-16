package bootcamp.meli.jpa.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "job")
public class Work {
  @Id
  private String id;

  private String description;

  @Setter
  @Field(type = FieldType.Nested, includeInParent = true)
  private FinishedInfo finishedInfo;

  @Field(type = FieldType.Text)
  private String createdAt;
}
