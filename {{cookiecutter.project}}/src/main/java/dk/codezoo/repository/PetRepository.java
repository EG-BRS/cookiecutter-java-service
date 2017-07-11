package dk.codezoo.repository;

import dk.codezoo.model.Kind;
import dk.codezoo.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class PetRepository implements PagingAndSortingRepository<Pet, String> {

    private List<Pet> pets = new ArrayList<>();

    public PetRepository() {
        pets.add(new Pet("Fido", Kind.DOG));
        pets.add(new Pet("Garfield", Kind.CAT));
        pets.add(new Pet("Jelly", Kind.FISH));
        pets.add(new Pet("Sneaky", Kind.SNAKE));

        for (Pet pet : pets) {
            pet.setId(UUID.randomUUID().toString());
        }
    }

    @Override
    public Iterable<Pet> findAll(Sort sort) {
        return Collections.unmodifiableList(pets);
    }

    @Override
    public Page<Pet> findAll(Pageable pageable) {
        return new PageImpl<Pet>(pets);
    }

    @Override
    public Pet save(Pet entity) {
        if (!entity.isNew()) {
            int index = getIndex(entity);

            if (index >= 0) {
                pets.remove(index);
            }
        } else {
            entity.setId(UUID.randomUUID().toString());
        }

        pets.add(entity);
        return entity;
    }



    @Override
    public <S extends Pet> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Pet findOne(String id) {
        for (Pet pet : pets) {
            if (id.equals(pet.getId())) {
                return pet;
            }
        }
        return null;
    }

    @Override
    public boolean exists(String id) {
        return findOne(id) != null;
    }

    @Override
    public Iterable<Pet> findAll() {
        return pets;
    }

    @Override
    public Iterable<Pet> findAll(Iterable<String> strings) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public long count() {
        return pets.size();
    }

    @Override
    public void delete(String id) {
        int index = getIndex(id);
        if(index >= 0) {
            pets.remove(index);
        }
    }

    @Override
    public void delete(Pet entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(Iterable<? extends Pet> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    private int getIndex(Pet entity) {
        if(entity.isNew()) {
            return -1;
        } else {
            return getIndex(entity.getId());
        }
    }

    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < pets.size(); i++) {
            if (id.equals(pets.get(i).getId())) {
                index = i;
            }
        }
        return index;
    }
}
