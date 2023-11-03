package Domain.Pets.Dog;

import Domain.Base.Animal;
import Domain.Base.PetsType;

import java.util.Date;
import java.util.UUID;

public class Dog extends Animal {

    private Dog(String name, Date birthday) {
        super(UUID.randomUUID(), name, PetsType.DOG, birthday);
    }

    public static Dog create(String name, Date birthday) {
        return new Dog(name, birthday);
    }

    public String commandSit() {
        return learnOrExecute(DogAnimalCommand.commandSit(this.id));
    }

    public String commandStay() {
        return learnOrExecute(DogAnimalCommand.commandStay(this.id));
    }

    public String commandFetch() {
        return learnOrExecute(DogAnimalCommand.commandFetch(this.id));
    }

    public String commandPaw() {
        return learnOrExecute(DogAnimalCommand.commandPaw(this.id));
    }

    public String commandBark() {
        return learnOrExecute(DogAnimalCommand.commandBark(this.id));
    }

    public String commandRoll() {
        return learnOrExecute(DogAnimalCommand.commandRoll(this.id));
    }
}
