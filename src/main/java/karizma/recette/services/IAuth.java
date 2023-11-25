package karizma.recette.services;


import karizma.recette.entities.AuthRespense;

public interface IAuth {

    public AuthRespense login(String login, String password);
    public void logout(Long id);
}
