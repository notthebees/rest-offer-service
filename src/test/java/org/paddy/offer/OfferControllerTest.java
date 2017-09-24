package org.paddy.offer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfferRepository offerRepository;

    @Test
    public void getAllOffers() throws Exception {
        String description1 = "Offer 1";
        String description2 = "Offer 2";
        int price1 = 50;
        int price2 = 100;
        Offer offer1 = new Offer(description1, price1);
        Offer offer2 = new Offer(description2, price2);
        ArrayList<Offer> offers = newArrayList(offer1, offer2);

        when(offerRepository.findAll()).thenReturn(offers);

        mockMvc.perform(get("/offers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is(description1)))
                .andExpect(jsonPath("$[0].price", is(price1)))
                .andExpect(jsonPath("$[1].description", is(description2)))
                .andExpect(jsonPath("$[1].price", is(price2)));
    }

    @Test
    public void getOffer() throws Exception {
        String description = "Offer";
        int price = 50;
        Offer offer = new Offer(description, price);

        when(offerRepository.findOne(1L)).thenReturn(offer);

        mockMvc.perform(get("/offers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is(description)))
                .andExpect(jsonPath("$.price", is(price)));
    }
}