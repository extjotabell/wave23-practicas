package bootcamp;

import java.util.List;
import java.util.Optional;

public interface CRUDInterface<T> {
    public void save(T element);
    public boolean delete(Long id);
    public List<T> getElements();
    public Optional<T> search(Long id);
    public void printElements();

}
