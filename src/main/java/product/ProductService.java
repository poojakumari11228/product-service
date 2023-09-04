package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepo productRepo;
    StockFeignClient stockFeignClient;
    @Autowired
    ProductService(ProductRepo productRepo, StockFeignClient stockFeignClient){
        this.productRepo = productRepo;
        this.stockFeignClient = stockFeignClient;
    }
    public Product getProduct(long id){
        Product product = productRepo.getProduct(id);
        Long productQuantity = stockFeignClient.getProductStoc(id);
        product.setNumberOnStock(productQuantity);
        return product;
    }
}
