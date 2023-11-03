package Application.Services;

import Domain.Base.Animal;
import Domain.PackAnimals.Camel.Camel;
import Domain.PackAnimals.Donkey.Donkey;
import Domain.PackAnimals.Horse.Horse;
import Domain.Pets.Cat.Cat;
import Domain.Pets.Dog.Dog;
import Domain.Pets.Hamster.Hamster;
import Application.Base.Service;
import java.util.Date;

public class AddAnimalService extends Service {

    //#region add animals
    public void addCat(String name, Date birthday) {
        addAnimal(Cat.create(name, birthday));
    }

    public void addDog(String name, Date birthday) {
        addAnimal(Dog.create(name, birthday));
    }

    public void addHamster(String name, Date birthday) {
        addAnimal(Hamster.create(name, birthday));
    }

    public void addHorse(String name, Date birthday) {
        addAnimal(Horse.create(name, birthday));
    }

    public void addCamel(String name, Date birthday) {
        addAnimal(Camel.create(name, birthday));
    }

    public void addDonkey(String name, Date birthday) {
        addAnimal(Donkey.create(name, birthday));
    }

    private void addAnimal(Animal animal) {
        farm.addAnimal(animal);
        db.save(farm);
    }
    //#endregion

}
