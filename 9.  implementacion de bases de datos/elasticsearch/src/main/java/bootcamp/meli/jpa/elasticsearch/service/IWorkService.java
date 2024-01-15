package bootcamp.meli.jpa.elasticsearch.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import bootcamp.meli.jpa.elasticsearch.dto.request.NewWorkDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.WorkInfoDto;
import bootcamp.meli.jpa.elasticsearch.model.FinishedInfo;
import bootcamp.meli.jpa.elasticsearch.model.Work;

public interface IWorkService {
  public void create(NewWorkDto newWork);

  public List<WorkInfoDto> getAll();

  public Optional<Work> getById(String id);

  public List<Work> getAllFinished();

  public List<Work> getByCreatedAtGreaterThan(LocalDateTime date);

  public void finish(String workId, FinishedInfo info);

  public void delete(String id);
}
