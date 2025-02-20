package br.luciano.ArquivoMultiplosFormatos_batch.step;

import br.luciano.ArquivoMultiplosFormatos_batch.dominio.Cliente;
import br.luciano.ArquivoMultiplosFormatos_batch.reader.ArquivoClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public Step leituraArquivoMultiplosFormatosStep(
            FlatFileItemReader leituraArquivoMultiplosFormatosReader,
            ItemWriter leituraArquivoMultiplosFormatosItemWriter, JobRepository jobRepository) {
        return new StepBuilder("leituraArquivoMultiplosFormatosStep", jobRepository)
                .chunk(1, transactionManager)
                .reader(new ArquivoClienteTransacaoReader(leituraArquivoMultiplosFormatosReader))
                .writer(leituraArquivoMultiplosFormatosItemWriter)
                .build();
    }
}
