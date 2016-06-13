package org.arquillian.example;

import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by goja288 on 6/13/2016.
 */
@RunWith(Arquillian.class)
public class TicketServiceTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(org.arquillian.example.TicketService.class.getPackage())
                //.addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    TicketService ticketService;

    @Test
    public void shouldCreateSeatType() throws Exception {
        // given
        final SeatType seatType = new SeatType();
        seatType.setDescription("Balcony");
        seatType.setPrice(11);
        seatType.setQuantity(5);

        // when
        ticketService.createSeatType(seatType);

        // then
        Assert.assertNotNull(seatType.getId());

    }

}
