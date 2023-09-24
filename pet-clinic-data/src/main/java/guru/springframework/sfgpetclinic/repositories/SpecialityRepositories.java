package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepositories extends CrudRepository<Speciality, Long> {
}
