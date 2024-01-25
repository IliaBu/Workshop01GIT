package Infrastructure;

import Domain.Base.Animal;
import Domain.PackAnimals.Camel.Camel;
import Domain.PackAnimals.Donkey.Donkey;
import Domain.PackAnimals.Horse.Horse;
import Domain.Pets.Cat.Cat;
import Domain.Pets.Dog.Dog;
import Domain.Pets.Hamster.Hamster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Farm implements Serializable {
    private final List<Animal> animals;


    public Farm(){
        animals = new ArrayList<>();
    }
    public List<Animal> getAllAnimals() {
        return animals;
    }

    public List<Cat> getCats() {
        return animals.stream()
                .filter(Cat.class::isInstance)
                .map(Cat.class::cast)
                .toList();
    }

    public List<Dog> getDogs() {
        return animals.stream()
                .filter(Dog.class::isInstance)
                .map(Dog.class::cast)
                .toList();
    }

    public List<Hamster> getHamsters() {
        return animals.stream()
                .filter(Hamster.class::isInstance)
                .map(Hamster.class::cast)
                .toList();
    }

    public List<Horse> getHorses() {
        return animals.stream()
                .filter(Horse.class::isInstance)
                .map(Horse.class::cast)
                .toList();
    }

    public List<Camel> getCamels() {
        return animals.stream()
                .filter(Camel.class::isInstance)
                .map(Camel.class::cast)
                .toList();
    }

    public List<Donkey> getDonkeys() {
        return animals.stream()
                .filter(Donkey.class::isInstance)
                .map(Donkey.class::cast)
                .toList();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
}

