package Presenters;

import Application.Services.StudyDonkeyService;

import java.util.List;

public class StudyDonkeyPresenter{

    private final StudyDonkeyService service = new StudyDonkeyService();

    public List<String> getAvailableDonkeyNames() {
        return service.getAvailableDonkeyNames();
    }

    public String learnCommandWalk(String name) {
        return service.educateDonkeyCommandWalk(name);
    }

    public String learnCommandCarryLoad(String name) {
        return service.educateDonkeyCommandCarryLoad(name);
    }

    public String learnCommandBray(String name) {
        return service.educateDonkeyCommandBray(name);
    }

    public String learnCommandKick(String name) {
        return service.educateDonkeyCommandKick(name);
    }
}
