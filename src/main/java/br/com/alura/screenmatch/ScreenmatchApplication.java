package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI(); //Instanciando a classe
		var json = consumoAPI.obterDados("http://www.omdbapi.com/?t=Modern+Family&apikey=f5514f48");
		System.out.println(json);

		ConverteDados converteDados = new ConverteDados();
		DadosSerie dados =converteDados.obterDados(json,DadosSerie.class);
	}
}
