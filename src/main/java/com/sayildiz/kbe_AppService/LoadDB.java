package com.sayildiz.kbe_AppService;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileReader;
import java.util.List;

@Configuration
public class LoadDB {
    private static final Logger logger = LoggerFactory.getLogger(LoadDB.class);
    private File csvFileStorageData;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository){
        return args -> {
            csvFileStorageData = ResourceUtils.getFile("classpath:AppServiceData.csv");
            List<Product> beans = new CsvToBeanBuilder<Product>(new FileReader(csvFileStorageData))
                    .withType(Product.class).build().parse();
            beans.forEach(x -> logger.info("loading Product for Product API " + repository.save(x)));
        };
    }
}


