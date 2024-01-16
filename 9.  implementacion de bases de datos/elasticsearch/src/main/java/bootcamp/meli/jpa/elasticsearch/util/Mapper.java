package bootcamp.meli.jpa.elasticsearch.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

import bootcamp.meli.jpa.elasticsearch.dto.request.NewFinishedInfoDto;
import bootcamp.meli.jpa.elasticsearch.dto.request.NewWorkDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.FinishedInfoDto;
import bootcamp.meli.jpa.elasticsearch.dto.response.WorkInfoDto;
import bootcamp.meli.jpa.elasticsearch.model.FinishedInfo;
import bootcamp.meli.jpa.elasticsearch.model.Work;

public class Mapper {
  public static Work map(NewWorkDto work) {
    String id = UUID.randomUUID().toString();
    try {
      LocalDateTime.parse(work.getCreatedAt(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    } catch (DateTimeParseException e) {
      throw new RuntimeException("Invalid date format: " + work.getCreatedAt(), e);
    }
    return new Work(id, work.getDescription(), null, work.getCreatedAt());
  }

  public static WorkInfoDto map(Work work) {
    String createdAt = work.getCreatedAt().toString();
    FinishedInfoDto finishedInfoDto = null;
    if (work.getFinishedInfo() != null) {
      String finishedAt = work.getFinishedInfo().getFinishedAt().toString();

      finishedInfoDto = new FinishedInfoDto(work.getFinishedInfo().getWorkerName(), finishedAt);
    }

    return new WorkInfoDto(work.getId(), work.getDescription(), createdAt, finishedInfoDto);
  }

  public static Work map(Work work, NewFinishedInfoDto newFinishedInfo) {
    LocalDateTime datetime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = datetime.format(formatter);
    FinishedInfo finishedInfo = new FinishedInfo(newFinishedInfo.getWorkerName(), formattedDateTime);
    work.setFinishedInfo(finishedInfo);
    return work;
  }
}
