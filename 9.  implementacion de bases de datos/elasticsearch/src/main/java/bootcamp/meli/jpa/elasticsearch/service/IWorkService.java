package bootcamp.meli.jpa.elasticsearch.service;

import java.util.List;

import bootcamp.meli.jpa.elasticsearch.dto.request.NewFinishedInfoDto;
import bootcamp.meli.jpa.elasticsearch.dto.request.NewWorkDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.WorkInfoDto;

public interface IWorkService {
  public void create(NewWorkDto newWork);

  public List<WorkInfoDto> getAll();

  public WorkInfoDto getById(String id);

  public List<WorkInfoDto> getAllFinished();

  public List<WorkInfoDto> getByCreatedAtGreaterThanEqual(String date);

  public void finish(String workId, NewFinishedInfoDto info);

  public void delete(String id);
}
