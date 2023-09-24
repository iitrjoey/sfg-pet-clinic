package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityServices specialityServices;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityServices specialityServices, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityServices = specialityServices;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }
    private void loadData() {

        PetType dog= new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityServices.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityServices.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityServices.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Abhishek");
        owner1.setLastName("Gautam");
        owner1.setAddress("Delhi");
        owner1.setCity("Saket");
        owner1.setTelephone("13131311");

        Pet abhishekPet = new Pet();
        abhishekPet.setPetType(saveDogPetType);
        abhishekPet.setOwner(owner1);
        abhishekPet.setBirthDate(LocalDate.now());
        abhishekPet.setName("Mike");
        owner1.getPets().add(abhishekPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dullu");
        owner2.setLastName("Bhai");
        owner2.setAddress("Delhi");
        owner2.setCity("Saket");
        owner2.setTelephone("22222222");


        Pet dulluPet = new Pet();
        dulluPet.setPetType(saveCatPetType);
        dulluPet.setOwner(owner2);
        dulluPet.setBirthDate(LocalDate.now());
        dulluPet.setName("Lucy");
        owner2.getPets().add(dulluPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(dulluPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneeze kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners.....");

        Vet vet1= new Vet();
        vet1.setFirstName("Harshit");
        vet1.setLastName("Jadon");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Sahil");
        vet2.setLastName("Gautam");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets......");
    }
}
