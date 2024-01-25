package UI.Menus;

import Presenters.StudyHamsterPresenter;
import UI.Colors;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHamsterMenu extends Menu {
    private final StudyHamsterPresenter presenter = new StudyHamsterPresenter();

    public StudyHamsterMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyRoll, "Обучить катить что-либо"));
        menuItems.add(new MenuItem(this::studyHide, "Обучить скрыться"));
        menuItems.add(new MenuItem(this::studySpin, "Обучить вращаться"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableHamsterNames();
        if (names.isEmpty()) {
            ConsoleUi.println(Colors.RED + "Не найдено ни одного хомяка для обучения" + Colors.RESET);
        }
        ConsoleUi.println(Colors.GREEN + "Доступные хомяки: " + names + Colors.RESET);
        ConsoleUi.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyRoll() {
        educate(presenter::learnCommandRoll);
    }

    public void studyHide() {
        educate(presenter::learnCommandHide);
    }

    public void studySpin() {
        educate(presenter::learnCommandSpin);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
