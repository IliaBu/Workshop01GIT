package UI.Menus;

import Presenters.StudyDogPresenter;
import UI.Colors;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyDogMenu extends Menu {
    private final StudyDogPresenter presenter = new StudyDogPresenter();

    public StudyDogMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyBark, "Обучить дать голос"));
        menuItems.add(new MenuItem(this::studyFetch, "Обучить принести"));
        menuItems.add(new MenuItem(this::studyRoll, "Обучить катить"));
        menuItems.add(new MenuItem(this::studyPaw, "Обучить дать лапу"));
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyStay, "Обучить стоять на месте"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableDogNames();
        if (names.isEmpty()) {
            ConsoleUi.println(Colors.RED + "Не найдено ни одной собаки для обучения" + Colors.RESET);
        }
        ConsoleUi.println(Colors.GREEN + "Доступные собаки: " + names + Colors.RESET);
        ConsoleUi.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }


    public void studyBark() {
        educate(presenter::learnCommandBark);
    }

    public void studyPaw() {
        educate(presenter::learnCommandPaw);
    }

    public void studyRoll() {
        educate(presenter::learnCommandRoll);
    }

    public void studyFetch() {
        educate(presenter::learnCommandFetch);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyStay() {
        educate(presenter::learnCommandStay);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
