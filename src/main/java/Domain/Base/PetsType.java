package Domain.Base;


public enum PetsType implements IAnimalType {
    DOG(1, "Собака"),
    CAT(2, "Кошка"),
    HAMSTER(3, "Хомяк");

    private final int id;
    private final String name;
    private final Category category;

    PetsType(int id, String name) {
        this.id = id;
        this.name = name;
        this.category = Category.PETS;
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
