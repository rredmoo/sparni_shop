package lv.venta;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Atlaide;
import lv.venta.model.Pasakumi;
import lv.venta.model.Veikals_kategorijas;
import lv.venta.model.Veikals_prece;
import lv.venta.repo.IAtlaideRepo;
import lv.venta.repo.IPasakumiRepo;
import lv.venta.repo.IPreceRepo;
import lv.venta.repo.IVeikalsKategorijasRepo;

@SpringBootApplication
public class SparniShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SparniShopApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner testDatabase(IAtlaideRepo atlaideRepo, IPasakumiRepo pasakumiRepo, IPreceRepo preceRepo,
			IVeikalsKategorijasRepo veikalsKategorijasRepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {


				Atlaide a1 = new Atlaide(70, LocalDateTime.of(2024,05,10,15,30), LocalDateTime.of(2024,05,15,15,31), true);
				atlaideRepo.save(a1);

				Atlaide a2 = new Atlaide(50, LocalDateTime.of(2024,05,10,15,30), LocalDateTime.of(2024,05,15,15,31), true);
				atlaideRepo.save(a2);

				
				
				
			
			
			
			
			}
		};

	}
}
