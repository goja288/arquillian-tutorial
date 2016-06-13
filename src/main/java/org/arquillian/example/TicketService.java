package org.arquillian.example;

import javax.inject.Inject;
import java.io.PrintStream;

/**
 * Created by goja288 on 6/13/2016.
 */
public class TicketService {



    public TicketService() {
    }

    public void createSeatType(SeatType seatType) {
        seatType.setId(40);
    }
}
