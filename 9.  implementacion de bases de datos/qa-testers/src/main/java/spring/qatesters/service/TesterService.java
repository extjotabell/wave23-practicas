package spring.qatesters.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.qatesters.dto.TestCaseDto;
import spring.qatesters.model.TestCase;
import spring.qatesters.repository.ITesterRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TesterService implements ITesterService{

    @Autowired
    ITesterRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public TestCaseDto addTestCase(TestCaseDto testCaseDto) {
        TestCase createdTestCase = repository.save(map(testCaseDto, TestCase.class));
        return map(createdTestCase, TestCaseDto.class);
    }

    @Override
    public List<TestCaseDto> getAll() {
        return repository.findAll().stream().map(testCase -> map(testCase, TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto getById(long id) {
        return map(repository.findById(id).orElseThrow(() -> new RuntimeException("No existe el testcase con id " + id)), TestCaseDto.class);
    }

    @Override
    public TestCaseDto updateTestCase(long id, Optional<String> description, Optional<Boolean> tested, Optional<Boolean> passed) {
        TestCase testCaseToUpdate = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el testcase con id " + id));

        tested.ifPresent(testCaseToUpdate::setTested);
        passed.ifPresent(testCaseToUpdate::setPassed);
        description.ifPresent(testCaseToUpdate::setDescription);
        testCaseToUpdate.setLastUpdate(LocalDate.now());

        repository.save(testCaseToUpdate);

        return map(testCaseToUpdate, TestCaseDto.class);
    }

    @Override
    @Transactional
    public TestCaseDto deleteTestCase(long id) {
        TestCaseDto deletedTestCase = map(repository.findById(id).orElseThrow(() -> new RuntimeException("No existe el testcase con id " + id)), TestCaseDto.class);
        repository.deleteById(id);
        return deletedTestCase;
    }


    @Override
    public List<TestCaseDto> getAllTestCasesAfterDate(Optional<LocalDate> udpateDate) {
        return repository.findAllByLastUpdateIsAfter(udpateDate).stream().map(testCase -> map(testCase, TestCaseDto.class)).toList();
    }

    private <Origin,Destination> Destination map(Origin origin, Class<Destination> destination){
        return mapper.map(origin, destination);
    }
}
