package lv.venta;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Atlaide;
import lv.venta.model.Informacija;
import lv.venta.model.Kontakti;
import lv.venta.model.MainPage_BiedribaDarbojas;
import lv.venta.model.Pasakumi;
import lv.venta.model.Veikals_kategorijas;
import lv.venta.model.Veikals_prece;
import lv.venta.repo.IAtlaideRepo;
import lv.venta.repo.IInformacijasRepo;
import lv.venta.repo.IKontaktiRepo;
import lv.venta.repo.IMainPageBiedribasDarbojasRepo;
import lv.venta.repo.IPasakumiKategorijasRepo;
import lv.venta.repo.IPasakumiRepo;
import lv.venta.repo.IPiegadesVeidiRepo;
import lv.venta.repo.IPreceRepo;
import lv.venta.repo.ISamaksasVeidsRepo;
import lv.venta.repo.IVeikalsKategorijasRepo;
import lv.venta.service.IMainPageBiedribasDarbojasCRUDService;

@SpringBootApplication
public class SparniShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparniShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabase(IAtlaideRepo atlaideRepo, IPasakumiRepo pasakumiRepo, IPreceRepo preceRepo,
			IVeikalsKategorijasRepo veikalsKategorijasRepo, IKontaktiRepo kontaktiRepo,
			IMainPageBiedribasDarbojasRepo mainPageBiedribaDarbojasRepo,
			IPasakumiKategorijasRepo pasakumiKategorijasRepo,
			IPiegadesVeidiRepo piegadesVeidiRepo, ISamaksasVeidsRepo samakasasVeidRepo, IInformacijasRepo infoRepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {


				Atlaide a1 = new Atlaide(70, LocalDateTime.of(2024, 05, 10, 15, 30),
						LocalDateTime.of(2024, 05, 15, 15, 31));
				atlaideRepo.save(a1);
				Atlaide a2 = new Atlaide(50, LocalDateTime.of(2024, 05, 10, 15, 30),
						LocalDateTime.of(2024, 05, 15, 15, 31));
				atlaideRepo.save(a2);
				Atlaide a3 = new Atlaide(50, LocalDateTime.of(2024, 05, 10, 15, 30),
						LocalDateTime.of(2024, 05, 15, 15, 31));
				atlaideRepo.save(a3);
				Atlaide a4 = new Atlaide(50, LocalDateTime.of(2024, 05, 10, 15, 30),
						LocalDateTime.of(2024, 05, 15, 15, 31));
				atlaideRepo.save(a4);

				// Kontakti

				Kontakti kontakt1 = new Kontakti("Company A", "Contact info for Company A");
				kontaktiRepo.save(kontakt1);
				Kontakti kontakt2 = new Kontakti("Company B", "Contact info for Company B");
				kontaktiRepo.save(kontakt2);
				Kontakti kontakt3 = new Kontakti("Company C", "Contact info for Company C");
				kontaktiRepo.save(kontakt3);
				Kontakti kontakt4 = new Kontakti("Company D", "Contact info for Company D");
				kontaktiRepo.save(kontakt4);

				// Pasakumi

				Pasakumi pasakumi1 = new Pasakumi(
						LocalDateTime.of(2024, 6, 30, 18, 0), // sakumaDatums
						LocalDateTime.of(2024, 6, 30, 20, 0), // beiguDatums
						"Summer Concert", // nosaukums
						LocalDateTime.of(2024, 6, 30, 19, 0), // laiks
						"Riga Concert Hall", // vieta
						"Join us for an evening of music!", // apraksts
						"https://oak-islandnc.com/wp-content/uploads/2020/06/Oak-Island-Summer-Concerts.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi1);
				Pasakumi pasakumi2 = new Pasakumi(
						LocalDateTime.of(2024, 7, 15, 19, 30), // sakumaDatums
						LocalDateTime.of(2024, 7, 15, 22, 0), // beiguDatums
						"Summer Jazz Night", // nosaukums
						LocalDateTime.of(2024, 7, 15, 20, 0), // laiks
						"Riga Jazz Club", // vieta
						"Enjoy an evening of smooth jazz melodies!", // apraksts
						"https://media-cdn.tripadvisor.com/media/photo-s/10/21/7c/c3/pashkevich-jazz-club.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi2);
				Pasakumi pasakumi3 = new Pasakumi(
						LocalDateTime.of(2024, 8, 5, 18, 0), // sakumaDatums
						LocalDateTime.of(2024, 8, 5, 21, 0), // beiguDatums
						"Art Exhibition", // nosaukums
						LocalDateTime.of(2024, 8, 5, 19, 0), // laiks
						"Riga Art Gallery", // vieta
						"Explore captivating artworks by local artists.", // apraksts
						"https://cdn11.bigcommerce.com/s-81oa1bc/images/stencil/1600x700/t/print%20decor%20gallery%2020__22187.original.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi3);
				Pasakumi pasakumi4 = new Pasakumi(
						LocalDateTime.of(2024, 9, 10, 17, 0), // sakumaDatums
						LocalDateTime.of(2024, 9, 10, 21, 0), // beiguDatums
						"Food Festival", // nosaukums
						LocalDateTime.of(2024, 9, 10, 18, 0), // laiks
						"Riga Central Park", // vieta
						"Savor delicious dishes from around the world!", // apraksts
						"https://us.123rf.com/450wm/ynos999/ynos9991909/ynos999190900126/142675619-city-riga-latvia-republic-riga-central-park-with-tourists-and-flowers-resting-place-18-aug-2019.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi4);

				Pasakumi pasakumi5 = new Pasakumi(
						LocalDateTime.of(2024, 9, 10, 17, 0), // sakumaDatums
						LocalDateTime.of(2024, 9, 10, 21, 0), // beiguDatums
						"Zeķu adīšana", // nosaukums
						LocalDateTime.of(2024, 9, 10, 18, 0), // laiks
						"Majas", // vieta
						"Stradajam un adam!", // apraksts
						"https://gitaozola.wordpress.com/wp-content/uploads/2014/11/wpid-dsc_01172.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi5);

				Pasakumi pasakumi6 = new Pasakumi(
						LocalDateTime.of(2024, 9, 10, 17, 0), // sakumaDatums
						LocalDateTime.of(2024, 9, 10, 21, 0), // beiguDatums
						"Maratons", // nosaukums
						LocalDateTime.of(2024, 9, 10, 18, 0), // laiks
						"Lemberga hūte", // vieta
						"Skrienam daudz!", // apraksts
						"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmPVsGwzGHhaZcq6c4xvoV8AzdoNa4G0bG5w&s" // bildesUrl
				);
				pasakumiRepo.save(pasakumi6);

				Pasakumi pasakumi7 = new Pasakumi(
						LocalDateTime.of(2024, 9, 10, 17, 0), // sakumaDatums
						LocalDateTime.of(2024, 9, 10, 21, 0), // beiguDatums
						"Pikniks", // nosaukums
						LocalDateTime.of(2024, 9, 10, 18, 0), // laiks
						"Plava", // vieta
						"Ēdam!", // apraksts
						"https://www.greatbritishfoodawards.com/assets/images/main/picnic_photo.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi7);

				Pasakumi pasakumi8 = new Pasakumi(
						LocalDateTime.of(2024, 9, 10, 17, 0), // sakumaDatums
						LocalDateTime.of(2024, 9, 10, 21, 0), // beiguDatums
						"Radošās darbnīcas", // nosaukums
						LocalDateTime.of(2024, 9, 10, 18, 0), // laiks
						"Plava", // vieta
						"Radoši darbi ar zeķēm!", // apraksts
						"https://altona.riga.lv/wp-content/uploads/2022/10/Meistarklases_2.jpg" // bildesUrl
				);
				pasakumiRepo.save(pasakumi8);

				


				Veikals_prece prece1 = new Veikals_prece(
						"Pilnīgs Gaļaks Cepure", // nosaukums
						"100% cotton", // apraksts
						74, // daudzums
						19.99f, // cena
						null, // pirkums_Elements
						null, // veikals_kategorijas
						"https://printtoo.com/cdn/shop/files/pilnigsgalaks-melnaziemascepure.png?v=1705062180&width=640", // veikals_prece_bildes
						null // idAtlaide
				);
				preceRepo.save(prece1);

				Veikals_prece prece2 = new Veikals_prece(
						"Darba cimdi ECO", // nosaukums
						"Labi darba cimdi", // apraksts
						50, // daudzums
						7.99f, // cena
						null, // pirkums_Elements
						null, // veikals_kategorijas
						"https://www.gandrs.lv/content/items/2024-01/cimdi-yaras-warm-gloves-2000x1400.jpg", // veikals_prece_bildes
						null // idAtlaide
				);
				preceRepo.save(prece2);

				Veikals_prece prece3 = new Veikals_prece(
						"Ŗudens Šalle", // nosaukums
						"Laba rudens šalle", // apraksts
						20, // daudzums
						25.99f, // cena
						null, // pirkums_Elements
						null, // veikals_kategorijas
						"https://milbaza.lv/wp-content/uploads/2022/12/eng_pl_Mil-Tec-Shemagh-Scarf-Skull-Coyote-19103_1.jpg", // veikals_prece_bildes
						null // idAtlaide
				);

				preceRepo.save(prece3);
				Veikals_prece prece4 = new Veikals_prece(
						"Aproce Latvija", // nosaukums
						"Laba aproce", // apraksts
						100, // daudzums
						2.99f, // cena
						null, // pirkums_Elements
						null, // veikals_kategorijas
						"https://visivar.lv/cdn/shop/products/EJP_7173._Visi_var_jpg_1024x1024.jpg?v=1635360889", // veikals_prece_bildes
						null // idAtlaide
				);
				preceRepo.save(prece4);

				Veikals_prece prece5 = new Veikals_prece(
					"Dzintars S izmērs", // nosaukums
					"Labi saglabājies, apstrādāts dzintars", // apraksts
					3, // daudzums
					7.00f, // cena
					null, // pirkums_Elements
					null, // veikals_kategorijas
					"https://pic.latvijasradio.lv/public/assets/media/f/9/mlarge_5ca30e1d.jpg", // veikals_prece_bildes
					null // idAtlaide
			);
			preceRepo.save(prece5);

			Veikals_prece prece6 = new Veikals_prece(
					"Koka pulkstenis #7", // nosaukums
					"Amatnieku veidots koka pulkstenis", // apraksts
					1, // daudzums
					24.99f, // cena
					null, // pirkums_Elements
					null, // veikals_kategorijas
					"https://www.parsteigumuagentura.lv/assets/images/Klasisks%20koka%20sienas%20pulkstenis%20ar%20grav%C4%93jumu%20nr.3.png", // veikals_prece_bildes
					null // idAtlaide
			);
			preceRepo.save(prece6);

			Veikals_prece prece7 = new Veikals_prece(
					"Adīts spilvens", // nosaukums
					"100% vilnas spilvens", // apraksts
					20, // daudzums
					25.99f, // cena
					null, // pirkums_Elements
					null, // veikals_kategorijas
					"https://lv2.pigugroup.eu/colours/132/252/69/13225269/spilvenu-spilvendranas-ar-rokam-adita-dizaina-3e906_reference.jpg", // veikals_prece_bildes
					null // idAtlaide
			);
			preceRepo.save(prece7);
		

				// Veikals kategorijas
				Veikals_kategorijas kategorijas1 = new Veikals_kategorijas(
						"Electronics", // nosaukums
						"Electronic gadgets" // apraksts
				);

				veikalsKategorijasRepo.save(kategorijas1);

				Veikals_kategorijas kategorijas2 = new Veikals_kategorijas(
						"Clothing", // nosaukums
						"Fashion apparel" // apraksts
				);
				veikalsKategorijasRepo.save(kategorijas2);

				Veikals_kategorijas kategorijas3 = new Veikals_kategorijas(
						"Books", // nosaukums
						"Literary works" // apraksts
				);
				veikalsKategorijasRepo.save(kategorijas3);

				Veikals_kategorijas kategorijas4 = new Veikals_kategorijas(
						"Home Decor", // nosaukums
						"Interior furnishings" // apraksts
				);
				veikalsKategorijasRepo.save(kategorijas4);

				// MainPage_BiedribaDarbojas
				MainPage_BiedribaDarbojas biedribadarbojas1 = new MainPage_BiedribaDarbojas(null, null, 0);
				mainPageBiedribaDarbojasRepo.save(biedribadarbojas1);

				MainPage_BiedribaDarbojas biedribadarbojas2 = new MainPage_BiedribaDarbojas(null, null, 0);
				mainPageBiedribaDarbojasRepo.save(biedribadarbojas2);

				MainPage_BiedribaDarbojas biedribadarbojas3 = new MainPage_BiedribaDarbojas(null, null, 0);
				mainPageBiedribaDarbojasRepo.save(biedribadarbojas3);

				MainPage_BiedribaDarbojas biedribadarbojas4 = new MainPage_BiedribaDarbojas(null, null, 0);
				mainPageBiedribaDarbojasRepo.save(biedribadarbojas4);


				Informacija info1 = new Informacija("Apmaksas veidi","Iespejams norekinaties ar Swedbank, citadele, u.c.","https://www.hobbyset.lv/images/pages/01ea917331c5fe0bcca60bb1f1f5ab4f.jpg");
				infoRepo.save(info1);
				Informacija info2 = new Informacija("Naudas un preces atgriešana","Varet nest atpakal uz veikalu!","https://static.vecteezy.com/system/resources/previews/008/013/016/original/payment-by-cash-for-express-delivery-flat-illustration-how-people-deliver-package-and-pay-for-the-delivery-by-cash-human-hand-holds-money-and-pay-for-the-package-courier-get-payment-for-it-vector.jpg");
				infoRepo.save(info2);
				Informacija info3 = new Informacija("Piegādes veidi","Pakomāts, uz vietas, kurjers!","https://st3.depositphotos.com/3332767/33164/i/450/depositphotos_331649150-stock-photo-delivery-guy-holding-a-box.jpg");
				infoRepo.save(info3);
				Informacija info4 = new Informacija("Mērķis","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa","https://lpr.gov.lv/wp-content/uploads/2021/biedriba-ceribu-sparni-pieredzes-apmaina-dienas-aprupes-centra-preilos-015-1024x683-1.jpg");
				infoRepo.save(info4);
				Informacija info5 = new Informacija("Biedrības Struktūra","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa","https://muzejs.ventspils.lv/wp-content/uploads/pagast.jpg");
				infoRepo.save(info5);

			}
		};

	}
}
