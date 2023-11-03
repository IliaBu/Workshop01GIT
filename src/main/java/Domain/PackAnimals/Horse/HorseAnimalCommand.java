package Domain.PackAnimals.Horse;


import Domain.Base.AnimalCommand;

import java.util.UUID;

public class HorseAnimalCommand extends AnimalCommand {

    public static final String TROT = "Рысь";
    public static final String CANTER = "Шаг";
    public static final String GALLOP = "Галоп";
    public static final String JUMP = "Прыжок";

    protected HorseAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static HorseAnimalCommand commandTrot(UUID animalId) {
        return new HorseAnimalCommand(UUID.randomUUID(), animalId, TROT);
    }

    public static HorseAnimalCommand commandCanter(UUID animalId) {
        return new HorseAnimalCommand(UUID.randomUUID(), animalId, CANTER);
    }

    public static HorseAnimalCommand commandGallop(UUID animalId) {
        return new HorseAnimalCommand(UUID.randomUUID(), animalId, GALLOP);
    }

    public static HorseAnimalCommand commandJump(UUID animalId) {
        return new HorseAnimalCommand(UUID.randomUUID(), animalId, JUMP);
    }
}
