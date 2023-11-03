package Presenters;

import Application.Services.StudyDogService;

import java.util.List;

public class StudyDogPresenter {

    private final StudyDogService service = new StudyDogService();
    public List<String> getAvailableDogNames() {
        return service.getAvailableDogNames();
    }

    public String learnCommandBark(String name) {
        return service.educateDogCommandBark(name);
    }

    public String learnCommandSit(String name) {
        return service.educateDogCommandSit(name);
    }

    public String learnCommandStay(String name) {
        return service.educateDogCommandStay(name);
    }

    public String learnCommandFetch(String name) {
        return service.educateDogCommandFetch(name);
    }

    public String learnCommandPaw(String name) {
        return service.educateDogCommandPaw(name);
    }

    public String learnCommandRoll(String name) {
        return service.educateDogCommandRoll(name);
    }
}
