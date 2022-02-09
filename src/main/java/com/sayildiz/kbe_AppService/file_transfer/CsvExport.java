package com.sayildiz.kbe_AppService.file_transfer;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.sayildiz.kbe_AppService.model.Product;
import com.sayildiz.kbe_AppService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

@Service
public class CsvExport {
    public final String CSV_LOCATION = "ExportedAppData.csv";

    @Autowired
    private ProductRepository repository;

    public Boolean writeCsvFromProduct(Path path){
        try{
        FileWriter writer  = new FileWriter(path.toString());
        StatefulBeanToCsv<Product> builder = new StatefulBeanToCsvBuilder<Product>(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        List<Product> list = repository.findAll();

        builder.write(list);
        writer.close();
        return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
