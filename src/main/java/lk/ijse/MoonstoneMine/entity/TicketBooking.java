package lk.ijse.MoonstoneMine.entity;

import lk.ijse.MoonstoneMine.view.tm.TicketCartTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TicketBooking {
    private String bookingId;
    private String cusId;
    private LocalDate date;
    private List<TicketCartTm> tmList = new ArrayList<>();
}
