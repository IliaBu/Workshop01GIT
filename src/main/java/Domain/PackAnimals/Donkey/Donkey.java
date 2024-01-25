package Domain.PackAnimals.Donkey;

import Domain.Base.Animal;
import Domain.Base.PackAnimalType;

import java.util.Date;
import java.util.UUID;

public class Donkey extends Animal {
    protected Donkey(String name, Date birthday) {
        super(UUID.randomUUID(), name, PackAnimalType.DONKEY, birthday);
    }

    public static Donkey create(String name, Date birthday) {
        return new Donkey(name, birthday);
    }

    public String commandKick() {
        return learnOrExecute(DonkeyAnimalCommand.commandKick(this.id));
    }

    public String commandCarryLoad() {
        return learnOrExecute(DonkeyAnimalCommand.commandCarryLoad(this.id));
    }

    public String commandBray() {
        return learnOrExecute(DonkeyAnimalCommand.commandBray(this.id));
    }

    public String commandWalk() {
        return learnOrExecute(DonkeyAnimalCommand.commandWalk(this.id));
    }
}
