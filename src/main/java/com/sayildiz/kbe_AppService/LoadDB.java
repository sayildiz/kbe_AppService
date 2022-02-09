package com.sayildiz.kbe_AppService;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sayildiz.kbe_AppService.file_transfer.CsvExport;
import com.sayildiz.kbe_AppService.file_transfer.FileTransferService;
import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class LoadDB {
    private static final Logger logger = LoggerFactory.getLogger(LoadDB.class);
    private File csvFileStorageData;

    @Autowired
    private FileTransferService fileTransferService;

    @Autowired
    private CsvExport csvExport;

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

    @Scheduled(fixedDelay = 3600, timeUnit = TimeUnit.SECONDS)
    public void exportDatabasetoCSVAndUpload() {
        logger.info("Start exporting database");
        try{
            boolean isExported = csvExport.writeCsvFromProduct(Paths.get(csvExport.CSV_LOCATION));
            logger.info("uploading file...");
            boolean isUploaded = fileTransferService.uploadFile(csvExport.CSV_LOCATION, "/upload/" + csvExport.CSV_LOCATION);
            if(!isExported || !isUploaded){
                logger.error("Export error");
                return;
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}


