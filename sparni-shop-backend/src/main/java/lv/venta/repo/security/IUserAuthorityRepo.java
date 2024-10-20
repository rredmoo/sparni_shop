package lv.venta.repo.security;

import org.springframework.data.repository.CrudRepository;
import lv.venta.model.security.UserAuthority;

public interface  IUserAuthorityRepo extends CrudRepository<UserAuthority, Integer> {
    
}
