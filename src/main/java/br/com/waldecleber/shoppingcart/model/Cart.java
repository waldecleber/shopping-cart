package br.com.waldecleber.shoppingcart.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("cart")
public class Cart {

    @Id
    private Integer id;
    private List<Item> items;

}
