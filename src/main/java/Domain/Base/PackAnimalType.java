package Domain.Base;

public enum PackAnimalType implements IAnimalType {
    HORSE(4, "Лошадь"),
    CAMEL(5, "Верблюд"),
    DONKEY(6, "Осёл");

    private final int id;
    private final String name;
    private final Category category;

    PackAnimalType(int id, String name) {
        this.id = id;
        this.name = name;
        this.category = Category.PACK_ANIMALS;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
}
