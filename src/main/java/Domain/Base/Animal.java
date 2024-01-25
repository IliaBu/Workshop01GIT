package Domain.Base;

import java.io.Serializable;
import java.util.*;

public abstract class Animal implements Serializable {
    protected final UUID id;
    protected final String name;
    protected final IAnimalType type;
    protected final Date birthday;

    protected final List<AnimalCommand> commands;

    protected Animal(UUID id, String name, IAnimalType type, Date birthday) {
        commands = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IAnimalType getType() {
        return type;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge()
    {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(birthday);
        if (birthDate.after(today)) {
            throw new IllegalArgumentException("Тебя ещё не существует" );
        }
        int yearDiff = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        int monthsBetween = today.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH) + 12 * yearDiff;

        if(today.get(Calendar.DAY_OF_MONTH) >= birthDate.get(Calendar.DAY_OF_MONTH))
            monthsBetween = monthsBetween + 1;
        return monthsBetween;
    }

    public String getLearnedCommands(){
        return commands.stream().map(AnimalCommand::getTitle).toList().toString().replaceAll("^\\[|\\]$", "");
    }

    protected String learnOrExecute(AnimalCommand command){
        if (isCommandLearned(command.getTitle())) {
            return "команда  '" + command.getTitle() + "' была успешно выполнена";
        } else {
            commands.add(command);
            return "команда '" + command.getTitle() + "' была успешно обучена";
        }
    }

    private boolean isCommandLearned(String title) {
        return commands.stream().anyMatch(command -> Objects.equals(command.getTitle(), title));
    }
}
