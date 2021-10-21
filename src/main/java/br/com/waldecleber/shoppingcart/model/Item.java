package br.com.waldecleber.shoppingcart.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("item")
public class Item {

    private Integer productId;
    private Integer amount;
}
