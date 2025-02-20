package br.luciano.ArquivoMultiplosFormatos_batch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosWriterConfig {

    @Bean
    public ItemWriter leituraArquivoMultiplosFormatosItemWriter() {
        return items -> items.forEach(System.out::println);
    }
}
