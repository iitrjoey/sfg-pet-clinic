package guru.springframework.sfgpetclinic.services.springdatajpa;


import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepositories;
import guru.springframework.sfgpetclinic.services.SpecialityServices;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityServices {

    private final SpecialityRepositories specialityRepositories;

    public SpecialitySDJpaService(SpecialityRepositories specialityRepositories) {
        this.specialityRepositories = specialityRepositories;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepositories.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepositories.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialityRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepositories.deleteById(aLong);
    }
}
