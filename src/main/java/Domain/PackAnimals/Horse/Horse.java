package Domain.PackAnimals.Horse;

import Domain.Base.Animal;
import Domain.Base.PackAnimalType;
import java.util.Date;
import java.util.UUID;

public class Horse extends Animal {
    protected Horse(String name, Date birthday) {
        super(UUID.randomUUID(), name, PackAnimalType.HORSE, birthday);
    }
    public static Horse create(String name, Date birthday){
        return new Horse(name, birthday);
    }

    public String commandJump() {
        return learnOrExecute(HorseAnimalCommand.commandJump(this.id));
    }

    public String commandCanter() {
        return learnOrExecute(HorseAnimalCommand.commandCanter(this.id));
    }

    public String commandTrot() {
        return learnOrExecute(HorseAnimalCommand.commandTrot(this.id));
    }

    public String commandGallop() {
        return learnOrExecute(HorseAnimalCommand.commandGallop(this.id));
    }
}
