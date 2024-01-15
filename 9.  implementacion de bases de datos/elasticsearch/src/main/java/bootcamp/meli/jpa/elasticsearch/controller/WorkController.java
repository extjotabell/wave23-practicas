package bootcamp.meli.jpa.elasticsearch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.meli.jpa.elasticsearch.dto.request.NewWorkDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.WorkInfoDto;
import bootcamp.meli.jpa.elasticsearch.service.impl.WorkService;

@RestController
@RequestMapping("work")
public class WorkController {
  private final WorkService service;

  public WorkController(WorkService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody NewWorkDto newWork) {
    this.service.create(newWork);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<List<WorkInfoDto>> getAll() {
    return ResponseEntity.ok(this.service.getAll());
  }

  // TODO

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    this.service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
// public Optional<Work> getById(String id);
// public List<Work> getAllFinished();
// public List<Work> getByCreatedAtGreaterThan(LocalDateTime date);
// public void finish(String workId, FinishedInfo info);
// public void delete(String id);