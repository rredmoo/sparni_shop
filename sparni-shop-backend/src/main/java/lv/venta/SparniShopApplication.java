package lv.venta;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Discount;
import lv.venta.model.Information;
import lv.venta.model.Basket;
import lv.venta.model.BasketItem;
import lv.venta.model.Contacts;
import lv.venta.model.MainPage_BiedribaDarbojas;
import lv.venta.model.Event;
import lv.venta.model.EventsCategory;
import lv.venta.model.StoreCategory;
import lv.venta.model.Product;
import lv.venta.repo.IDiscountRepo;
import lv.venta.repo.IInformationRepo;
import lv.venta.repo.IBasketItemRepo;
import lv.venta.repo.IBasketRepo;
import lv.venta.repo.IContactRepo;
import lv.venta.repo.IIMainPageBiedribasDarbojasRepo;
import lv.venta.repo.IEventCategoryRepo;
import lv.venta.repo.IEventRepo;
import lv.venta.repo.IDeliveryOptionsRepo;
import lv.venta.repo.IProductRepo;
import lv.venta.repo.IStoreCategoryRepo;
import lv.venta.repo.security.IAccessUsersRepo;
import lv.venta.repo.security.IUserAuthorityRepo;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lv.venta.model.security.AccessUsers;
import lv.venta.model.security.UserAuthority;

@SpringBootApplication
public class SparniShopApplication {

        public static void main(String[] args) {
                SpringApplication.run(SparniShopApplication.class, args);
        }

        @Bean
        public CommandLineRunner testDatabase(IDiscountRepo atlaideRepo, IEventRepo pasakumiRepo,
                        IProductRepo preceRepo,
                        IStoreCategoryRepo veikalsKategorijasRepo, IContactRepo kontaktiRepo,
                        IIMainPageBiedribasDarbojasRepo mainPageBiedribaDarbojasRepo,
                        IEventCategoryRepo pasakumiKategorijasRepo,
                        IDeliveryOptionsRepo piegadesVeidiRepo,
                        IInformationRepo infoRepo, IAccessUsersRepo accessUsersRepo,
                        IUserAuthorityRepo userAuthorityRepo, IBasketRepo basketRepo, IBasketItemRepo basketItemRepo) {
                return new CommandLineRunner() {

                        @Override
                        public void run(String... args) throws Exception {

                                // USERS
                                UserAuthority auth1 = new UserAuthority("ADMIN");
                                userAuthorityRepo.save(auth1);
                                UserAuthority auth2 = new UserAuthority("MODERATOR");
                                userAuthorityRepo.save(auth2);
                                PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                                AccessUsers user1 = new AccessUsers("admin", encoder.encode("CZFhgOcHSb"), auth1);
                                accessUsersRepo.save(user1);
                                AccessUsers user2 = new AccessUsers("moderator", encoder.encode("pZh4WH2dXB"), auth2);
                                accessUsersRepo.save(user2);

                                Discount a1 = new Discount(70, LocalDateTime.of(2024, 05, 10, 15, 30),
                                                LocalDateTime.of(2024, 05, 15, 15, 31));
                                atlaideRepo.save(a1);
                                Discount a2 = new Discount(50, LocalDateTime.of(2024, 05, 10, 15, 30),
                                                LocalDateTime.of(2024, 05, 15, 15, 31));
                                atlaideRepo.save(a2);
                                Discount a3 = new Discount(50, LocalDateTime.of(2024, 05, 10, 15, 30),
                                                LocalDateTime.of(2024, 05, 15, 15, 31));
                                atlaideRepo.save(a3);
                                Discount a4 = new Discount(50, LocalDateTime.of(2024, 05, 10, 15, 30),
                                                LocalDateTime.of(2024, 05, 15, 15, 31));
                                atlaideRepo.save(a4);

                                Contacts kontakti1 = new Contacts("Facebook", "https://www.facebook.com/Ventinpurlad/");
                                kontaktiRepo.save(kontakti1);

                                Contacts kontakti2 = new Contacts("tālruņa nr.", "+371 20000001");
                                kontaktiRepo.save(kontakti2);

                                Contacts kontakti3 = new Contacts("E-pasts", "ventinpurlad@inbox.lv");
                                kontaktiRepo.save(kontakti3);

                                Contacts kontakti4 = new Contacts("Adrese",
                                                "Skolas iela - 3, Ventspils, LV-3601, Latvija ");
                                kontaktiRepo.save(kontakti4);

                                // pasakumu kategorijas
                                EventsCategory pk1 = new EventsCategory("Nodarbības",
                                                "Viss par nodarbībām");
                                pasakumiKategorijasRepo.save(pk1);
                                EventsCategory pk2 = new EventsCategory("Informācija",
                                                "Informatīvie ieraksti");
                                pasakumiKategorijasRepo.save(pk2);
                                EventsCategory pk3 = new EventsCategory("Pasākumi", "Par pasākumiem");
                                pasakumiKategorijasRepo.save(pk3);

                                // Pasakumi
                                Event pasakumi1 = new Event(
                                                pk1,
                                                LocalDateTime.of(2024, 6, 30, 18, 0),
                                                LocalDateTime.of(2024, 6, 30, 20, 0),
                                                "Summer Concert",
                                                LocalDateTime.of(2024, 6, 30, 19, 0),
                                                "Riga Concert Hall",
                                                "Join us for an evening of music!",
                                                "https://oak-islandnc.com/wp-content/uploads/2020/06/Oak-Island-Summer-Concerts.jpg");
                                pasakumiRepo.save(pasakumi1);
                                Event pasakumi2 = new Event(
                                                pk1,
                                                LocalDateTime.of(2024, 7, 15, 19, 30),
                                                LocalDateTime.of(2024, 7, 15, 22, 0),
                                                "Summer Jazz Night",
                                                LocalDateTime.of(2024, 7, 15, 20, 0),
                                                "Riga Jazz Club",
                                                "Enjoy an evening of smooth jazz melodies!",
                                                "https://media-cdn.tripadvisor.com/media/photo-s/10/21/7c/c3/pashkevich-jazz-club.jpg");
                                pasakumiRepo.save(pasakumi2);
                                Event pasakumi3 = new Event(
                                                pk2,
                                                LocalDateTime.of(2024, 8, 5, 18, 0),
                                                LocalDateTime.of(2024, 8, 5, 21, 0),
                                                "Art Exhibition",
                                                LocalDateTime.of(2024, 8, 5, 19, 0),
                                                "Riga Art Gallery",
                                                "Explore captivating artworks by local artists.,Explore captivating artworks by local artists",
                                                "https://cdn11.bigcommerce.com/s-81oa1bc/images/stencil/1600x700/t/print%20decor%20gallery%2020__22187.original.jpg");
                                pasakumiRepo.save(pasakumi3);
                                Event pasakumi4 = new Event(
                                                pk2,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Food Festival",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Riga Central Park",
                                                "Savor delicious dishes from around the world!",
                                                "https://us.123rf.com/450wm/ynos999/ynos9991909/ynos999190900126/142675619-city-riga-latvia-republic-riga-central-park-with-tourists-and-flowers-resting-place-18-aug-2019.jpg");
                                pasakumiRepo.save(pasakumi4);

                                Event pasakumi5 = new Event(
                                                pk3,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Zeķu adīšana",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Majas",
                                                "Stradajam un adam!Stradajam un adam!",
                                                "https://gitaozola.wordpress.com/wp-content/uploads/2014/11/wpid-dsc_01172.jpg");
                                pasakumiRepo.save(pasakumi5);

                                Event pasakumi6 = new Event(
                                                pk3,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Maratons",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Lemberga hūte",
                                                "Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!Skrienam daudz!",
                                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmPVsGwzGHhaZcq6c4xvoV8AzdoNa4G0bG5w&s");
                                pasakumiRepo.save(pasakumi6);

                                Event pasakumi7 = new Event(
                                                pk1,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Pikniks",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Plava",
                                                "Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!Ēdam!",
                                                "https://www.greatbritishfoodawards.com/assets/images/main/picnic_photo.jpg");
                                pasakumiRepo.save(pasakumi7);

                                Event pasakumi8 = new Event(
                                                pk1,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Radošās darbnīcas",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Plava",
                                                "Radoši darbi ar zeķēm!Radoši darbi ar zeķēm!",
                                                "https://altona.riga.lv/wp-content/uploads/2022/10/Meistarklases_2.jpg");
                                pasakumiRepo.save(pasakumi8);

                                Product prece1 = new Product(
                                                "Pilnīgs Gaļaks Cepure",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                74,
                                                19.99f,
                                                null,                                       
                                                "https://printtoo.com/cdn/shop/files/pilnigsgalaks-melnaziemascepure.png?v=1705062180&width=640",
                                                null);
                                preceRepo.save(prece1);

                                Product prece2 = new Product(
                                                "Darba cimdi ECO",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                50,
                                                7.99f,
                                                null,
                                                "https://www.gandrs.lv/content/items/2024-01/cimdi-yaras-warm-gloves-2000x1400.jpg",
                                                null);
                                preceRepo.save(prece2);

                                Product prece3 = new Product(
                                                "Ŗudens Šalle",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                20,
                                                25.99f,
                                                null,
                                                "https://milbaza.lv/wp-content/uploads/2022/12/eng_pl_Mil-Tec-Shemagh-Scarf-Skull-Coyote-19103_1.jpg",
                                                null);

                                preceRepo.save(prece3);
                                Product prece4 = new Product(
                                                "Aproce Latvija",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                100,
                                                2.99f,
                                                null,
                                                "https://visivar.lv/cdn/shop/products/EJP_7173._Visi_var_jpg_1024x1024.jpg?v=1635360889",
                                                null);
                                preceRepo.save(prece4);

                                Product prece5 = new Product(
                                                "Dzintars S izmērs",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                3,
                                                7.00f,
                                                null,
                                                "https://pic.latvijasradio.lv/public/assets/media/f/9/mlarge_5ca30e1d.jpg",
                                                null);
                                preceRepo.save(prece5);

                                Product prece6 = new Product(
                                                "Koka pulkstenis #7",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                1,
                                                24.99f,
                                                null,
                                                "https://www.parsteigumuagentura.lv/assets/images/Klasisks%20koka%20sienas%20pulkstenis%20ar%20grav%C4%93jumu%20nr.3.png",
                                                null);
                                preceRepo.save(prece6);

                                Product prece7 = new Product(
                                                "Adīts spilvens",
                                                "tas ir teksta salikums, kuru izmanto poligrāfijā un maketēšanas darbos. Lorem Ipsum ir kļuvis par vispārpieņemtu teksta aizvietotāju kopš 16. gadsimta sākuma. Tajā laikā kāds nezināms iespiedējs izveidoja teksta fragmentu, lai nodrukātu grāmatu ar burtu paraugiem. Tas ir ne tikai pārdzīvojis piecus gadsimtus, bet bez ievērojamām izmaiņām saglabājies arī mūsdienās, pārejot uz datorizētu teksta apstrādi. Tā popularizēšanai 60-tajos gados kalpoja Letraset burtu paraugu publicēšana ar Lorem Ipsum teksta fragmentiem un, nesenā pagātnē, tādas maketēšanas programmas kā Aldus PageMaker, kuras šablonu paraugos ir izmantots Lorem Ipsum teksts.",
                                                20,
                                                25.99f,
                                                null,
                                                "https://lv2.pigugroup.eu/colours/132/252/69/13225269/spilvenu-spilvendranas-ar-rokam-adita-dizaina-3e906_reference.jpg",
                                                null);
                                preceRepo.save(prece7);

                                Basket basket = new Basket();
                                basketRepo.save(basket);

                                BasketItem testBaskedItem1 = new BasketItem(basket, prece7, 2);
                                basketItemRepo.save(testBaskedItem1);
                                BasketItem testBaskedItem2 = new BasketItem(basket, prece4, 1);
                                basketItemRepo.save(testBaskedItem2);

                                // Veikals kategorijas
                                StoreCategory kategorijas1 = new StoreCategory(
                                                "Elektropreces",
                                                "Visa veida Elektropreces");

                                veikalsKategorijasRepo.save(kategorijas1);

                                StoreCategory kategorijas2 = new StoreCategory(
                                                "Apģērbs",
                                                "Visa veida apģērbs");
                                veikalsKategorijasRepo.save(kategorijas2);

                                StoreCategory kategorijas3 = new StoreCategory(
                                                "Grāmatas",
                                                "Visa veida grāmatas");
                                veikalsKategorijasRepo.save(kategorijas3);

                                StoreCategory kategorijas4 = new StoreCategory(
                                                "Mājai",
                                                "Viss mājai");
                                veikalsKategorijasRepo.save(kategorijas4);

                                // MainPage_BiedribaDarbojas
                                MainPage_BiedribaDarbojas biedribadarbojas1 = new MainPage_BiedribaDarbojas(null, null,
                                                0);
                                mainPageBiedribaDarbojasRepo.save(biedribadarbojas1);

                                MainPage_BiedribaDarbojas biedribadarbojas2 = new MainPage_BiedribaDarbojas(null, null,
                                                0);
                                mainPageBiedribaDarbojasRepo.save(biedribadarbojas2);

                                MainPage_BiedribaDarbojas biedribadarbojas3 = new MainPage_BiedribaDarbojas(null, null,
                                                0);
                                mainPageBiedribaDarbojasRepo.save(biedribadarbojas3);

                                MainPage_BiedribaDarbojas biedribadarbojas4 = new MainPage_BiedribaDarbojas(null, null,
                                                0);
                                mainPageBiedribaDarbojasRepo.save(biedribadarbojas4);

                                Information info1 = new Information("Apmaksas veidi",
                                                "Iespejams norekinaties ar Swedbank, citadele, u.c.",
                                                "https://www.hobbyset.lv/images/pages/01ea917331c5fe0bcca60bb1f1f5ab4f.jpg");
                                infoRepo.save(info1);
                                Information info2 = new Information("Naudas un preces atgriešana",
                                                "Varet nest atpakal uz veikalu!",
                                                "https://static.vecteezy.com/system/resources/previews/008/013/016/original/payment-by-cash-for-express-delivery-flat-illustration-how-people-deliver-package-and-pay-for-the-delivery-by-cash-human-hand-holds-money-and-pay-for-the-package-courier-get-payment-for-it-vector.jpg");
                                infoRepo.save(info2);
                                Information info3 = new Information("Piegādes veidi", "Pakomāts, uz vietas, kurjers!",
                                                "https://st3.depositphotos.com/3332767/33164/i/450/depositphotos_331649150-stock-photo-delivery-guy-holding-a-box.jpg");
                                infoRepo.save(info3);
                                Information info4 = new Information("Mērķis", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                                                "https://lpr.gov.lv/wp-content/uploads/2021/biedriba-ceribu-sparni-pieredzes-apmaina-dienas-aprupes-centra-preilos-015-1024x683-1.jpg");
                                infoRepo.save(info4);
                                Information info5 = new Information("Biedrības Struktūra",
                                                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                                                "https://muzejs.ventspils.lv/wp-content/uploads/pagast.jpg");
                                infoRepo.save(info5);

                        }
                };

        }

}
