package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepositories;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepositories petRepositories;

    public PetSDJpaService(PetRepositories petRepositories) {
        this.petRepositories = petRepositories;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepositories.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepositories.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepositories.deleteById(aLong);
    }
}
