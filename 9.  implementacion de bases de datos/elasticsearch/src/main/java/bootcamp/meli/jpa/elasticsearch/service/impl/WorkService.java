package bootcamp.meli.jpa.elasticsearch.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import bootcamp.meli.jpa.elasticsearch.dto.request.NewFinishedInfoDto;
import bootcamp.meli.jpa.elasticsearch.dto.request.NewWorkDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.WorkInfoDto;
import bootcamp.meli.jpa.elasticsearch.model.Work;
import bootcamp.meli.jpa.elasticsearch.repository.WorkRepository;
import bootcamp.meli.jpa.elasticsearch.service.IWorkService;
import bootcamp.meli.jpa.elasticsearch.util.Mapper;

@Service
public class WorkService implements IWorkService {
  private final WorkRepository repository;

  public WorkService(WorkRepository repository) {
    this.repository = repository;
  }

  @Override
  public void create(NewWorkDto newWork) {
    Work newWorkEntity = Mapper.map(newWork);
    this.repository.save(newWorkEntity);
  }

  @Override
  public List<WorkInfoDto> getAll() {
    Iterable<Work> allWorkIterable = this.repository.findAll();

    List<WorkInfoDto> allWork = StreamSupport
        .stream(allWorkIterable.spliterator(), false)
        .map(w -> Mapper.map(w))
        .toList();

    return allWork;
  }

  @Override
  public WorkInfoDto getById(String id) {
    Optional<Work> posibleWork = this.repository.findById(id);
    if (!posibleWork.isPresent())
      throw new RuntimeException("Work with id " + id + " not found.");
    return Mapper.map(posibleWork.get());
  }

  @Override
  public List<WorkInfoDto> getAllFinished() {
    return this.repository.findByFinishedInfoIsNotNull().stream().map(w -> Mapper.map(w)).toList();
  }

  @Override
  public List<WorkInfoDto> getByCreatedAtGreaterThanEqual(String date) {
    return this.repository.findByCreatedAtGreaterThanEqual(date).stream().map(w -> Mapper.map(w)).toList();
  }

  @Override
  public void finish(String workId, NewFinishedInfoDto info) {
    Optional<Work> posibleWork = this.repository.findById(workId);
    if (!posibleWork.isPresent())
      throw new RuntimeException("Work with id " + workId + "not found");
    Work finishedWork = Mapper.map(posibleWork.get(), info);
    this.repository.save(finishedWork);
  }

  @Override
  public void delete(String id) {
    this.repository.deleteById(id);
  }
}
