package lv.venta.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import lv.venta.model.ClientsEmail;

public interface IClientsEmailRepo extends JpaRepository<ClientsEmail, Integer> {

}
