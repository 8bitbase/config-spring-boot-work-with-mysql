package lcd.tool.bootstrap;

import lcd.tool.domain.Product;
import lcd.tool.repositories.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Random rand = new Random();
        int i;
        for (i = 0; i < 5; i++) {
            // int randValue = rand.nextInt(12);
            // String randValue = "" + randValue;
            Product shirt = new Product();
            shirt.setDescription("Product as shit " + i);
            shirt.setPrice(new BigDecimal("18.95"));
            shirt.setImageUrl("http://lcdung.top/wp-content/uploads/2017/09/shit.jpg");
            shirt.setProductId("1");
            productRepository.save(shirt);

            log.info("Saved Shirt - id: " + shirt.getId());
        }
    }
}
