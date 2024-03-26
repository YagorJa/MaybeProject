package by.ankudovich.mapper;

import by.ankudovich.api.Basket.BasketResponse;
import by.ankudovich.entity.Basket;

public class BasketMapper {
    public BasketResponse toResponse(Basket basket) {
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setOrderId(basket.getOrderId());
        basketResponse.setProductId(basket.getProductId());
        basketResponse.setCount(basket.getCount());
        return basketResponse;
    }
}
