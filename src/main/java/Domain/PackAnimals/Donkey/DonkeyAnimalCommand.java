package Domain.PackAnimals.Donkey;

import Domain.Base.AnimalCommand;

import java.util.UUID;

public class DonkeyAnimalCommand extends AnimalCommand {

    public static final String WALK = "Ходить";
    public static final String CARRY_LOAD = "Нести груз";
    public static final String BRAY = "Кричать";
    public static final String KICK = "Лягнуть";

    protected DonkeyAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static DonkeyAnimalCommand commandWalk(UUID animalId) {
        return new DonkeyAnimalCommand(UUID.randomUUID(), animalId, WALK);
    }

    public static DonkeyAnimalCommand commandCarryLoad(UUID animalId) {
        return new DonkeyAnimalCommand(UUID.randomUUID(), animalId, CARRY_LOAD);
    }

    public static DonkeyAnimalCommand commandBray(UUID animalId) {
        return new DonkeyAnimalCommand(UUID.randomUUID(), animalId, BRAY);
    }

    public static DonkeyAnimalCommand commandKick(UUID animalId) {
        return new DonkeyAnimalCommand(UUID.randomUUID(), animalId, KICK);
    }
}
