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
import lv.venta.model.Pasakumi_kategorijas;
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
        public CommandLineRunner testDatabase(IAtlaideRepo atlaideRepo, IPasakumiRepo pasakumiRepo,
                        IPreceRepo preceRepo,
                        IVeikalsKategorijasRepo veikalsKategorijasRepo, IKontaktiRepo kontaktiRepo,
                        IMainPageBiedribasDarbojasRepo mainPageBiedribaDarbojasRepo,
                        IPasakumiKategorijasRepo pasakumiKategorijasRepo,
                        IPiegadesVeidiRepo piegadesVeidiRepo, ISamaksasVeidsRepo samakasasVeidRepo,
                        IInformacijasRepo infoRepo, IAccessUsersRepo accessUsersRepo,
                        IUserAuthorityRepo userAuthorityRepo) {
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

                                Kontakti kontakti1 = new Kontakti("Facebook", "https://www.facebook.com/Ventinpurlad/");
                                kontaktiRepo.save(kontakti1);

                                Kontakti kontakti2 = new Kontakti("tālruņa nr.", "+371 20000001");
                                kontaktiRepo.save(kontakti2);

                                Kontakti kontakti3 = new Kontakti("E-pasts", "ventinpurlad@inbox.lv");
                                kontaktiRepo.save(kontakti3);

                                Kontakti kontakti4 = new Kontakti("Adrese", "Skolas iela - 3, Ventspils, LV-3601, Latvija ");
                                kontaktiRepo.save(kontakti4);

                                // pasakumu kategorijas
                                Pasakumi_kategorijas pk1 = new Pasakumi_kategorijas("Nodarbības","Classes",
                                                "Viss par nodarbībām","All about classes");
                                pasakumiKategorijasRepo.save(pk1);
                                Pasakumi_kategorijas pk2 = new Pasakumi_kategorijas("Informācija","Information",
                                                "Informatīvie ieraksti","Informational purposes");
                                pasakumiKategorijasRepo.save(pk2);
                                Pasakumi_kategorijas pk3 = new Pasakumi_kategorijas("Pasākumi","Events", "Par pasākumiem","About events");
                                pasakumiKategorijasRepo.save(pk3);

                                // Pasakumi
                                Pasakumi pasakumi1 = new Pasakumi(
                                                pk1,
                                                LocalDateTime.of(2024, 6, 30, 18, 0),
                                                LocalDateTime.of(2024, 6, 30, 20, 0),
                                                "Summer Concert","Vasaras Koncerts",
                                                LocalDateTime.of(2024, 6, 30, 19, 0),
                                                "Riga Concert Hall",
                                                "Join us for an evening of music!","Pievienojies mums uzmuziku!",
                                                "https://oak-islandnc.com/wp-content/uploads/2020/06/Oak-Island-Summer-Concerts.jpg"
                                );
                                pasakumiRepo.save(pasakumi1);
                                Pasakumi pasakumi2 = new Pasakumi(
                                                pk1,
                                                LocalDateTime.of(2024, 7, 15, 19, 30),
                                                LocalDateTime.of(2024, 7, 15, 22, 0),
                                                "Summer Jazz Night","Vasaraks džeza nakts",
                                                LocalDateTime.of(2024, 7, 15, 20, 0),
                                                "Riga Jazz Club",
                                                "Enjoy an evening of smooth jazz melodies!","Izbaudi džeza melodijas!",
                                                "https://media-cdn.tripadvisor.com/media/photo-s/10/21/7c/c3/pashkevich-jazz-club.jpg"
                                );
                                pasakumiRepo.save(pasakumi2);
                                Pasakumi pasakumi3 = new Pasakumi(
                                                pk2,
                                                LocalDateTime.of(2024, 8, 5, 18, 0),
                                                LocalDateTime.of(2024, 8, 5, 21, 0),
                                                "Art Exhibition","Mākslas izstāde",
                                                LocalDateTime.of(2024, 8, 5, 19, 0),
                                                "Riga Art Gallery",
                                                "Explore captivating artworks by local artists.,Explore captivating artworks by local artists","izbaudi makslu ar maklsiniekiem",
                                                "https://cdn11.bigcommerce.com/s-81oa1bc/images/stencil/1600x700/t/print%20decor%20gallery%2020__22187.original.jpg"
                                );
                                pasakumiRepo.save(pasakumi3);
                                Pasakumi pasakumi4 = new Pasakumi(
                                                pk2,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Food Festival","uzēdam festivāls",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Riga Central Park",
                                                "Savor delicious dishes from around the world!","nac uzēd ar draugiem!",
                                                "https://us.123rf.com/450wm/ynos999/ynos9991909/ynos999190900126/142675619-city-riga-latvia-republic-riga-central-park-with-tourists-and-flowers-resting-place-18-aug-2019.jpg"
                                );
                                pasakumiRepo.save(pasakumi4);

                                Pasakumi pasakumi5 = new Pasakumi(
                                                pk3,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Sock making", "Zeķu adīšana",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Majas",
                                                "come and work for socks!","Stradajam un adam!Stradajam un adam!",
                                                "https://gitaozola.wordpress.com/wp-content/uploads/2014/11/wpid-dsc_01172.jpg"
                                );
                                pasakumiRepo.save(pasakumi5);

                                Pasakumi pasakumi6 = new Pasakumi(
                                                pk3,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Run bro", "Maratons",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Lemberga hūte",
                                                "rush b!","skrienam b",
                                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRmPVsGwzGHhaZcq6c4xvoV8AzdoNa4G0bG5w&s"
                                );
                                pasakumiRepo.save(pasakumi6);

                                Pasakumi pasakumi7 = new Pasakumi(
                                                pk1,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "Picnic","Pikniks",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Plava",
                                                "Eat nam nam","ēdam!!!!!!!!!!!",
                                                "https://www.greatbritishfoodawards.com/assets/images/main/picnic_photo.jpg"
                                );
                                pasakumiRepo.save(pasakumi7);

                                Pasakumi pasakumi8 = new Pasakumi(
                                                pk1,
                                                LocalDateTime.of(2024, 9, 10, 17, 0),
                                                LocalDateTime.of(2024, 9, 10, 21, 0),
                                                "BadEsArEnglishIdk","Radošās darbnīcas",
                                                LocalDateTime.of(2024, 9, 10, 18, 0),
                                                "Plava",
                                                "socks as entertainment","Radoši darbi ar zeķēm!Radoši darbi ar zeķēm!",
                                                "https://altona.riga.lv/wp-content/uploads/2022/10/Meistarklases_2.jpg"
                                );
                                pasakumiRepo.save(pasakumi8);

                                Veikals_prece prece1 = new Veikals_prece(
                                                "Pilnīgs Gaļaks Cepure",
                                                "100% cotton",
                                                74,
                                                19.99f,
                                                null,
                                                null,
                                                "https://printtoo.com/cdn/shop/files/pilnigsgalaks-melnaziemascepure.png?v=1705062180&width=640",
                                                null
                                );
                                preceRepo.save(prece1);

                                Veikals_prece prece2 = new Veikals_prece(
                                                "Darba cimdi ECO",
                                                "Labi darba cimdi",
                                                50,
                                                7.99f,
                                                null,
                                                null,
                                                "https://www.gandrs.lv/content/items/2024-01/cimdi-yaras-warm-gloves-2000x1400.jpg",
                                                null
                                );
                                preceRepo.save(prece2);

                                Veikals_prece prece3 = new Veikals_prece(
                                                "Ŗudens Šalle",
                                                "Laba rudens šalle",
                                                20,
                                                25.99f,
                                                null,
                                                null,
                                                "https://milbaza.lv/wp-content/uploads/2022/12/eng_pl_Mil-Tec-Shemagh-Scarf-Skull-Coyote-19103_1.jpg",
                                                null
                                );

                                preceRepo.save(prece3);
                                Veikals_prece prece4 = new Veikals_prece(
                                                "Aproce Latvija",
                                                "Laba aproce",
                                                100,
                                                2.99f,
                                                null,
                                                null,
                                                "https://visivar.lv/cdn/shop/products/EJP_7173._Visi_var_jpg_1024x1024.jpg?v=1635360889",
                                                null
                                );
                                preceRepo.save(prece4);

                                Veikals_prece prece5 = new Veikals_prece(
                                                "Dzintars S izmērs",
                                                "Labi saglabājies, apstrādāts dzintars",
                                                3,
                                                7.00f,
                                                null,
                                                null,
                                                "https://pic.latvijasradio.lv/public/assets/media/f/9/mlarge_5ca30e1d.jpg",
                                                null
                                );
                                preceRepo.save(prece5);

                                Veikals_prece prece6 = new Veikals_prece(
                                                "Koka pulkstenis #7",
                                                "Amatnieku veidots koka pulkstenis",
                                                1,
                                                24.99f,
                                                null,
                                                null,
                                                "https://www.parsteigumuagentura.lv/assets/images/Klasisks%20koka%20sienas%20pulkstenis%20ar%20grav%C4%93jumu%20nr.3.png",
                                                null
                                );
                                preceRepo.save(prece6);

                                Veikals_prece prece7 = new Veikals_prece(
                                                "Adīts spilvens",
                                                "100% vilnas spilvens",
                                                20,
                                                25.99f,
                                                null,
                                                null,
                                                "https://lv2.pigugroup.eu/colours/132/252/69/13225269/spilvenu-spilvendranas-ar-rokam-adita-dizaina-3e906_reference.jpg",
                                                null
                                );
                                preceRepo.save(prece7);

                                // Veikals kategorijas
                                Veikals_kategorijas kategorijas1 = new Veikals_kategorijas(
                                                "Elektropreces",
                                                "Visa veida Elektropreces"
                                );

                                veikalsKategorijasRepo.save(kategorijas1);

                                Veikals_kategorijas kategorijas2 = new Veikals_kategorijas(
                                                "Apģērbs",
                                                "Visa veida apģērbs"
                                );
                                veikalsKategorijasRepo.save(kategorijas2);

                                Veikals_kategorijas kategorijas3 = new Veikals_kategorijas(
                                                "Grāmatas",
                                                "Visa veida grāmatas"
                                );
                                veikalsKategorijasRepo.save(kategorijas3);

                                Veikals_kategorijas kategorijas4 = new Veikals_kategorijas(
                                                "Mājai",
                                                "Viss mājai"
                                );
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

                                Informacija info1 = new Informacija("Apmaksas veidi",
                                                "Iespejams norekinaties ar Swedbank, citadele, u.c.",
                                                "https://www.hobbyset.lv/images/pages/01ea917331c5fe0bcca60bb1f1f5ab4f.jpg");
                                infoRepo.save(info1);
                                Informacija info2 = new Informacija("Naudas un preces atgriešana",
                                                "Varet nest atpakal uz veikalu!",
                                                "https://static.vecteezy.com/system/resources/previews/008/013/016/original/payment-by-cash-for-express-delivery-flat-illustration-how-people-deliver-package-and-pay-for-the-delivery-by-cash-human-hand-holds-money-and-pay-for-the-package-courier-get-payment-for-it-vector.jpg");
                                infoRepo.save(info2);
                                Informacija info3 = new Informacija("Piegādes veidi", "Pakomāts, uz vietas, kurjers!",
                                                "https://st3.depositphotos.com/3332767/33164/i/450/depositphotos_331649150-stock-photo-delivery-guy-holding-a-box.jpg");
                                infoRepo.save(info3);
                                Informacija info4 = new Informacija("Mērķis", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                                                "https://lpr.gov.lv/wp-content/uploads/2021/biedriba-ceribu-sparni-pieredzes-apmaina-dienas-aprupes-centra-preilos-015-1024x683-1.jpg");
                                infoRepo.save(info4);
                                Informacija info5 = new Informacija("Biedrības Struktūra",
                                                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                                                "https://muzejs.ventspils.lv/wp-content/uploads/pagast.jpg");
                                infoRepo.save(info5);

                        }
                };

        }

}
