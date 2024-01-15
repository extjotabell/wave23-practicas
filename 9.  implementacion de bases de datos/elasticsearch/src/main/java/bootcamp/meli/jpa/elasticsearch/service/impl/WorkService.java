package bootcamp.meli.jpa.elasticsearch.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import bootcamp.meli.jpa.elasticsearch.dto.request.NewWorkDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.WorkInfoDto;
import bootcamp.meli.jpa.elasticsearch.model.FinishedInfo;
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
  public Optional<Work> getById(String id) {
    return this.repository.findById(id);
  }

  @Override
  public List<Work> getAllFinished() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllFinished'");
  }

  @Override
  public List<Work> getByCreatedAtGreaterThan(LocalDateTime date) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getByCreatedAtGreaterThan'");
  }

  @Override
  public void finish(String workId, FinishedInfo info) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'finish'");
  }

  @Override
  public void delete(String id) {
    this.repository.deleteById(id);
  }
}
