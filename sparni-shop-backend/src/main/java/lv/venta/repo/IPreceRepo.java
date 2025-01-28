package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Veikals_prece;




public interface IPreceRepo extends CrudRepository<Veikals_prece, Integer> {

    ArrayList<Veikals_prece> findByIdvp(int idvp);

    ArrayList<Veikals_prece> findByCenaGreaterThan(float cena);

    ArrayList<Veikals_prece> findByCenaLessThan(float cena);

    ArrayList<Veikals_prece> OrderByCenaDesc();

    ArrayList<Veikals_prece> OrderByCenaAsc();

    ArrayList<Veikals_prece> findByCenaBetween(float minCena, float maxCena);

    ArrayList<Veikals_prece> findByNosaukumsLvContaining(String keyword);

    ArrayList<Veikals_prece> findByNosaukumsEnContaining(String keyword); 
    ArrayList<Veikals_prece> findByDaudzumsGreaterThan(int daudzums);

    // ArrayList<Veikals_prece> findByVeikals_kategorijasIdvk(int idvk);

    ArrayList<Veikals_prece> findByIdAtlaideNotNull();

    ArrayList<Veikals_prece> findByIdAtlaideNull();

    ArrayList<Veikals_prece> findByNosaukumsEn(String nosaukumsEn);
    ArrayList<Veikals_prece> findByNosaukumsLv(String nosaukumsLv);
    ArrayList<Veikals_prece> findByAprakstsEn(String aprakstsEn);
    ArrayList<Veikals_prece> findByAprakstsLv(String aprakstsLv);




} 