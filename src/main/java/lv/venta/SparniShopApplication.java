package lv.venta;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Atlaide;
import lv.venta.model.Kontakti;
import lv.venta.model.MainPage_BiedribaDarbojas;
import lv.venta.model.Pasakumi;
import lv.venta.model.Pasakumi_kategorijas;
import lv.venta.model.Piegades_Veids;
import lv.venta.model.Samaksas_veids;
import lv.venta.model.Veikals_kategorijas;
import lv.venta.model.Veikals_prece;
import lv.venta.repo.IAtlaideRepo;
import lv.venta.repo.IKontaktiRepo;
import lv.venta.repo.IMainPageBiedribasDarbojasRepo;
import lv.venta.repo.IPasakumiKategorijasRepo;
import lv.venta.repo.IPasakumiRepo;
import lv.venta.repo.IPiegadesVeidiRepo;
import lv.venta.repo.IPreceRepo;
import lv.venta.repo.ISamaksasVeidsRepo;
import lv.venta.repo.IVeikalsKategorijasRepo;

@SpringBootApplication
public class SparniShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparniShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDatabase(IAtlaideRepo atlaideRepo, IPasakumiRepo pasakumiRepo, IPreceRepo preceRepo,
            IVeikalsKategorijasRepo veikalsKategorijasRepo, IKontaktiRepo kontaktiRepo, IMainPageBiedribasDarbojasRepo mainPageBiedribaDarbojasRepo,
            IPasakumiKategorijasRepo pasakumiKategorijasRepo,
            IPiegadesVeidiRepo piegadesVeidiRepo, ISamaksasVeidsRepo samakasasVeidRepo) {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                Atlaide a1 = new Atlaide(70, LocalDateTime.of(2024, 05, 10, 15, 30), LocalDateTime.of(2024, 05, 15, 15, 31));
                atlaideRepo.save(a1);
                Atlaide a2 = new Atlaide(50, LocalDateTime.of(2024, 05, 10, 15, 30), LocalDateTime.of(2024, 05, 15, 15, 31));
                atlaideRepo.save(a2);
                Atlaide a3 = new Atlaide(50, LocalDateTime.of(2024, 05, 10, 15, 30), LocalDateTime.of(2024, 05, 15, 15, 31));
                atlaideRepo.save(a3);
                Atlaide a4 = new Atlaide(50, LocalDateTime.of(2024, 05, 10, 15, 30), LocalDateTime.of(2024, 05, 15, 15, 31));
                atlaideRepo.save(a4);

                //Kontakti 
                Kontakti kontakt1 = new Kontakti("Company A", "Contact info for Company A");
                kontaktiRepo.save(kontakt1);
                Kontakti kontakt2 = new Kontakti("Company B", "Contact info for Company B");
                kontaktiRepo.save(kontakt2);
                Kontakti kontakt3 = new Kontakti("Company C", "Contact info for Company C");
                kontaktiRepo.save(kontakt3);
                Kontakti kontakt4 = new Kontakti("Company D", "Contact info for Company D");
                kontaktiRepo.save(kontakt4);

                //Pasakumi 
                Pasakumi pasakumi1 = new Pasakumi(
                        LocalDateTime.of(2024, 6, 30, 18, 0), // sakumaDatums
                        LocalDateTime.of(2024, 6, 30, 20, 0), // beiguDatums
                        "Summer Concert", // nosaukums
                        LocalDateTime.of(2024, 6, 30, 19, 0), // laiks
                        "Riga Concert Hall", // vieta
                        "Join us for an evening of music!", // apraksts
                        "https://example.com/concert.jpg" // bildesUrl-
                );
                pasakumiRepo.save(pasakumi1);
                Pasakumi pasakumi2 = new Pasakumi(
                        LocalDateTime.of(2024, 7, 15, 19, 30), // sakumaDatums
                        LocalDateTime.of(2024, 7, 15, 22, 0), // beiguDatums
                        "Summer Jazz Night", // nosaukums
                        LocalDateTime.of(2024, 7, 15, 20, 0), // laiks
                        "Riga Jazz Club", // vieta
                        "Enjoy an evening of smooth jazz melodies!", // apraksts
                        "https://example.com/jazz-night.jpg" // bildesUrl
                );
                pasakumiRepo.save(pasakumi2);
                Pasakumi pasakumi3 = new Pasakumi(
                        LocalDateTime.of(2024, 8, 5, 18, 0), // sakumaDatums
                        LocalDateTime.of(2024, 8, 5, 21, 0), // beiguDatums
                        "Art Exhibition", // nosaukums
                        LocalDateTime.of(2024, 8, 5, 19, 0), // laiks
                        "Riga Art Gallery", // vieta
                        "Explore captivating artworks by local artists.", // apraksts
                        "https://example.com/art-exhibition.jpg" // bildesUrl
                );
                pasakumiRepo.save(pasakumi3);
                Pasakumi pasakumi4 = new Pasakumi(
                        LocalDateTime.of(2024, 9, 10, 17, 0), // sakumaDatums
                        LocalDateTime.of(2024, 9, 10, 21, 0), // beiguDatums
                        "Food Festival", // nosaukums
                        LocalDateTime.of(2024, 9, 10, 18, 0), // laiks
                        "Riga Central Park", // vieta
                        "Savor delicious dishes from around the world!", // apraksts
                        "https://example.com/food-festival.jpg" // bildesUrl
                );
                pasakumiRepo.save(pasakumi4);

                Veikals_prece prece1 = new Veikals_prece(
                        "Laptop", // nosaukums
                        "High performance laptop with SSD", // apraksts
                        10, // daudzums
                        899.99f, // cena
                        null, // pirkums_Elements 
                        null, // veikals_kategorijas
                        null, // veikals_prece_bildes 
                        null // idAtlaide 
                );
                preceRepo.save(prece1);

                Veikals_prece prece2 = new Veikals_prece(
                        "Wireless Headphones", // nosaukums
                        "Noise canceling headphones with Bluetooth connectivity", // apraksts
                        50, // daudzums
                        129.99f, // cena
                        null, // pirkums_Elements 
                        null, // veikals_kategorijas
                        null, // veikals_prece_bildes 
                        null // idAtlaide 
                );
                preceRepo.save(prece2);

                Veikals_prece prece3 = new Veikals_prece(
                        "Smartphone", // nosaukums
                        "High performance Android phone with dual cameras", // apraksts
                        20, // daudzums
                        699.99f, // cena
                        null, // pirkums_Elements 
                        null, // veikals_kategorijas
                        null, // veikals_prece_bildes 
                        null // idAtlaide 
                );

                preceRepo.save(prece3);
                Veikals_prece prece4 = new Veikals_prece(
                        "Fitness Tracker", // nosaukums
                        "Waterproof fitness band with heart rate monitor", // apraksts
                        100, // daudzums
                        49.99f, // cena
                        null, // pirkums_Elements 
                        null, // veikals_kategorijas
                        null, // veikals_prece_bildes 
                        null // idAtlaide 
                );
                preceRepo.save(prece4);

                // Veikals kategorijas
                Veikals_kategorijas kategorijas1 = new Veikals_kategorijas(
                        "Electronics", //nosaukums
                        "Electronic gadgets" //apraksts
                );

                veikalsKategorijasRepo.save(kategorijas1);

                Veikals_kategorijas kategorijas2 = new Veikals_kategorijas(
                        "Clothing", //nosaukums
                        "Fashion apparel" //apraksts
                );
                veikalsKategorijasRepo.save(kategorijas2);

                Veikals_kategorijas kategorijas3 = new Veikals_kategorijas(
                        "Books", //nosaukums
                        "Literary works" //apraksts
                );
                veikalsKategorijasRepo.save(kategorijas3);

                Veikals_kategorijas kategorijas4 = new Veikals_kategorijas(
                        "Home Decor", //nosaukums
                        "Interior furnishings" //apraksts
                );
                veikalsKategorijasRepo.save(kategorijas4);

                // MainPage_BiedribaDarbojas
                MainPage_BiedribaDarbojas biedribadarbojas1 = new MainPage_BiedribaDarbojas("Value1", "Description1", 0);
                mainPageBiedribaDarbojasRepo.save(biedribadarbojas1);

                MainPage_BiedribaDarbojas biedribadarbojas2 = new MainPage_BiedribaDarbojas("Value2", "Description2", 0);
                mainPageBiedribaDarbojasRepo.save(biedribadarbojas2);

                MainPage_BiedribaDarbojas biedribadarbojas3 = new MainPage_BiedribaDarbojas("Value3", "Description3", 0);
                mainPageBiedribaDarbojasRepo.save(biedribadarbojas3);

                MainPage_BiedribaDarbojas biedribadarbojas4 = new MainPage_BiedribaDarbojas("Value4", "Description4", 0);
                mainPageBiedribaDarbojasRepo.save(biedribadarbojas4);

                // Pasakumi_kategorijas
                Pasakumi_kategorijas pasakumi_kategorijas1 = new Pasakumi_kategorijas("Category1", "Description1");
                pasakumiKategorijasRepo.save(pasakumi_kategorijas1);

                Pasakumi_kategorijas pasakumi_kategorijas2 = new Pasakumi_kategorijas("Category2", "Description2");
                pasakumiKategorijasRepo.save(pasakumi_kategorijas2);

                Pasakumi_kategorijas pasakumi_kategorijas3 = new Pasakumi_kategorijas("Category3", "Description3");
                pasakumiKategorijasRepo.save(pasakumi_kategorijas3);

                Pasakumi_kategorijas pasakumi_kategorijas4 = new Pasakumi_kategorijas("Category4", "Description4");
                pasakumiKategorijasRepo.save(pasakumi_kategorijas4);
 
                //	Piegades_Veids
                Piegades_Veids Piegades_Veids1 = new Piegades_Veids("Value1", "Description1");
                piegadesVeidiRepo.save(Piegades_Veids1);

                Piegades_Veids Piegades_Veids2 = new Piegades_Veids("Value2", "Description2");
                piegadesVeidiRepo.save(Piegades_Veids2);

                Piegades_Veids Piegades_Veids3 = new Piegades_Veids("Value3", "Description3");
                piegadesVeidiRepo.save(Piegades_Veids3);

                Piegades_Veids Piegades_Veids4 = new Piegades_Veids("Value4", "Description4");
                piegadesVeidiRepo.save(Piegades_Veids4);

                // Samaksas_veids

                Samaksas_veids Samaksas_veids1 = new Samaksas_veids("Value1", "Description2", null);
                samakasasVeidRepo.save(Samaksas_veids1);

                Samaksas_veids Samaksas_veids2 = new Samaksas_veids("Value2", "Description2", null);
                samakasasVeidRepo.save(Samaksas_veids2);

                Samaksas_veids Samaksas_veids3 = new Samaksas_veids("Value3", "Description3", null);
                samakasasVeidRepo.save(Samaksas_veids3);

                Samaksas_veids Samaksas_veids4 = new Samaksas_veids("Value4", "Description4",null);
                samakasasVeidRepo.save(Samaksas_veids4);

            }
        };

    }
}
