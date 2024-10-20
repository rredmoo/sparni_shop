package lv.venta.repo.security;

import org.springframework.data.repository.CrudRepository;
import lv.venta.model.security.AccessUsers;

public interface IAccessUsersRepo extends CrudRepository<AccessUsers, Integer>{

    AccessUsers findByUsername(String username);

}