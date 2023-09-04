package product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("StockService")
public interface StockFeignClient {
    @GetMapping("/stock/{id}")
     public Long getProductStoc(@PathVariable("id") Long productId);
}
