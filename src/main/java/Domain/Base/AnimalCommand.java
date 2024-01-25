package Domain.Base;

import java.io.Serializable;
import java.util.UUID;

public abstract class AnimalCommand implements Serializable {
    private final UUID id;
    private final UUID animalId;
    private final String title;

    protected AnimalCommand(UUID id, UUID animalId, String title){
        this.id = id;
        this.animalId = animalId;
        this.title = title;
    }

    public UUID getId(){
        return id;
    }
    public UUID getAnimalId(){
        return animalId;
    }
    public String getTitle(){
        return title;
    }
}
