package Domain.Pets.Hamster;

import Domain.Base.AnimalCommand;

import java.util.UUID;

public class HamsterAnimalCommand extends AnimalCommand {

    public static final String ROLL = "Катить";
    public static final String HIDE = "Скрыться";
    public static final String SPIN = "Вращайся";
    private HamsterAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static HamsterAnimalCommand commandRoll(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, ROLL);
    }

    public static HamsterAnimalCommand commandHide(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, HIDE);
    }

    public static HamsterAnimalCommand commandSpin(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, SPIN);
    }

}
