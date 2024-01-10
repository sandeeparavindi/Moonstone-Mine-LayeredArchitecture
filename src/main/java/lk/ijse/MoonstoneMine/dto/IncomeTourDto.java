package lk.ijse.MoonstoneMine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class IncomeTourDto {
    private String date;
    private int numberOfBooking;
    private int numberOfSoldTicket;
    private double finalCost;

    public IncomeTourDto(String date, int numberOfSoldTicket) {
        this.date = date;
        this.numberOfSoldTicket = numberOfSoldTicket;
    }
}
