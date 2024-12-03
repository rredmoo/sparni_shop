package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {

    Product findByIdvp(int idvp);

    ArrayList<Product> findByCenaGreaterThan(float cena); // cena > value

    ArrayList<Product> findByCenaLessThan(float cena); // cena < value

    ArrayList<Product> OrderByCenaDesc(); // cena desc

    ArrayList<Product> OrderByCenaAsc(); // cena asc

    ArrayList<Product> findByCenaBetween(float minCena, float maxCena); // value-value

    ArrayList<Product> findByNosaukumsContaining(String keyword);

    ArrayList<Product> findByDaudzumsGreaterThan(int daudzums); // daudzums > value

    // ArrayList<Veikals_prece> findByVeikals_kategorijasIdvk(int idvk);

    ArrayList<Product> findByIdAtlaideNotNull(); // ar atlaidi

    ArrayList<Product> findByIdAtlaideNull(); // bez atlaidi
}