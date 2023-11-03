package UI.Menus;

import Presenters.StudyDonkeyPresenter;
import UI.Colors;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyDonkeyMenu extends Menu {

    private final StudyDonkeyPresenter presenter = new StudyDonkeyPresenter();

    public StudyDonkeyMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Обучить ходить"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Обучить нести груз"));
        menuItems.add(new MenuItem(this::studyBray, "Обучить дать голос"));
        menuItems.add(new MenuItem(this::studyKick, "Обучить лягнуть"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableDonkeyNames();
        if (names.isEmpty()) {
            ConsoleUi.println(Colors.RED + "Не найдено ни одного осла для обучения" + Colors.RESET);
        }
        ConsoleUi.println(Colors.GREEN + "Доступные ослы: " + names + Colors.RESET);
        ConsoleUi.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyWalk() {
        educate(presenter::learnCommandWalk);
    }

    public void studyCarryLoad() {
        educate(presenter::learnCommandCarryLoad);
    }

    public void studyBray() {
        educate(presenter::learnCommandBray);
    }

    public void studyKick() {
        educate(presenter::learnCommandKick);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}