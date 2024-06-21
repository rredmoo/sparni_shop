package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;


import lv.venta.model.Samaksas_veids;
import lv.venta.model.Veikals_prece;

public interface ISamaksasVeidsRepo extends CrudRepository<Samaksas_veids, Integer>{

    Veikals_prece findByID_Samaksas_Veids(int ID_Samaksas_Veids);
} 
