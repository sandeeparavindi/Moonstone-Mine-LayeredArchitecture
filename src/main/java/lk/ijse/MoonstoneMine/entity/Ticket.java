package lk.ijse.MoonstoneMine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ticket {
    private String code;
    private String type;
    private double Price;
    private int qtyOnHand;
}
