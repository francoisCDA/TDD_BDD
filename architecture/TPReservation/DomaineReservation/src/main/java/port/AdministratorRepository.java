package port;

import entity.Administrator;

public interface  AdministratorRepository {


    Administrator getAdminByIDs(String userName, String password);
}
