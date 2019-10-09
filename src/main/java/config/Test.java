package config;

import service.RegistrationService;

public class Test {
    public static void main(String[] args) {
        RegistrationService registrationService = new RegistrationService();
        registrationService.sendToDB("Эльдар Сакаев","el","el","el","el","el","el");

    }
}
