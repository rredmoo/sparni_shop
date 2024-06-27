package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Veikals_prece;

public interface IPreceRepo extends CrudRepository<Veikals_prece, Integer> {

    Veikals_prece findByIdvp(int idvp);

    ArrayList<Veikals_prece> findByCenaGreaterThan(float cena); // cena > value

    ArrayList<Veikals_prece> findByCenaLessThan(float cena); // cena < value

    ArrayList<Veikals_prece> OrderByCenaDesc(); // cena desc

    ArrayList<Veikals_prece> OrderByCenaAsc(); // cena asc

    ArrayList<Veikals_prece> findByCenaBetween(float minCena, float maxCena); // value-value

    ArrayList<Veikals_prece> findByNosaukumsContaining(String keyword);

    ArrayList<Veikals_prece> findByDaudzumsGreaterThan(int daudzums); // daudzums > value

    // ArrayList<Veikals_prece> findByVeikals_kategorijasIdvk(int idvk);

    ArrayList<Veikals_prece> findByIdAtlaideNotNull(); // ar atlaidi

    ArrayList<Veikals_prece> findByIdAtlaideNull(); // bez atlaidi
}