package bootcamp;

import java.util.*;
import java.util.stream.IntStream;

public class ItemImp implements CRUDInterface<Item> {

    private List<Item> items;

    public ItemImp() {
       items = new ArrayList<>();
    }
    @Override
    public void save(Item element) {
        items.add(element);
    }

    @Override
    public boolean delete(Long id) {
        OptionalInt indexOpt = IntStream.range(0, items.size())
                .filter(i -> Objects.equals(id, items.get(i).getCodigo())).findFirst();
        if (indexOpt.isPresent()) items.remove(indexOpt.getAsInt());
        return indexOpt.isPresent();
    }

    @Override
    public List<Item> getElements() {
        return this.items;
    }

    @Override
    public Optional<Item> search(Long id) {
        return items.stream().filter(cliente -> cliente.getCodigo().equals(id)).findFirst();
    }

    @Override
    public void printElements() {
        System.out.println(this.items);
    }
}
