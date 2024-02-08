package service;

import entity.Administrator;
import port.AdministratorRepository;

public class AdministratorService {

    private final AdministratorRepository administratorRepository;


    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }
    public boolean isAdmin(String userName, String password) {
        Administrator admin =  administratorRepository.getAdminByIDs(userName,password);
        return admin != null;
    }



}
