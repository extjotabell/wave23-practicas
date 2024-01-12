package spring.qatesters.service;

import spring.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITesterService {

    TestCaseDto addTestCase(TestCaseDto testCaseDto);
    List<TestCaseDto> getAll();
    TestCaseDto getById(long id);
    TestCaseDto updateTestCase(long id, Optional<String> description, Optional<Boolean> tested, Optional<Boolean> passed);
    TestCaseDto deleteTestCase(long id);

    List<TestCaseDto> getAllTestCasesAfterDate(Optional<LocalDate> updateDate);
}
