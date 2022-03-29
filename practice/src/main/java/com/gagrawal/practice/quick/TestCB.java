package com.gagrawal.practice.quick;

import com.chargebee.Environment;
import com.chargebee.models.Customer;
import com.chargebee.models.Item;
import com.chargebee.models.ItemPrice;
import com.chargebee.models.Subscription;
import com.chargebee.models.enums.AutoCollection;

/**
 * @author Gaurav
 * 23/02/22
 */
public class TestCB {
    public static void main(String[] args) throws Exception {
        Environment.configure("abcc-test", "test_fgPRezGVMhqRQametFZQ5wc2pyiLVm7s");
        //products();
        Customer.create()
                .id("Sai")
                .autoCollection(AutoCollection.OFF)
                .param("channel","app_store")
                .request();
        subscription(false);
        subscription(true);
//        Customer.delete("Sai").request();
    }

    private static void subscription(boolean isGoogle) throws Exception {
        for(int i = 0; i < 25; i++) {
            System.out.println("Creating subscription - " + (i+1));
            String itemPriceId;
            String channel = "app_store";
            if(i%2 == 0) {
                itemPriceId = "weekly-plan-USD";
            }
            else {
                itemPriceId = "monthly-plan-USD";
            }
            if(isGoogle) {
                if(i%2 == 0) {
                    itemPriceId = "weekly-plan-gps-USD";
                }
                else {
                    itemPriceId = "monthly-plan-gps-USD";
                }
                channel = "play_store";
            }

            Subscription.createWithItems("Sai")
                    .subscriptionItemItemPriceId(0, itemPriceId)
                    .param("channel", channel)
                    .request();
        }
    }

    private static void products() throws Exception {
        Item.create()
                .itemFamilyId("Google-Play-store")
                .id("weekly-plan-gps")
                .name("Weekly GPS Demo plan")
                .type(Item.Type.PLAN)
                .itemApplicability(Item.ItemApplicability.ALL)
                .param("channel","play_store")
                .request();

        ItemPrice.create()
                .id("weekly-plan-gps-USD")
                .name("Weekly GPS USD Plan")
                .itemId("weekly-plan-gps")
                .currencyCode("USD")
                .price(1000)
                .periodUnit(ItemPrice.PeriodUnit.WEEK)
                .period(1)
                .param("channel","play_store")
                .request();

        Item.create()
                .itemFamilyId("Google-Play-store")
                .id("monthly-plan-gps")
                .name("Monthly GPS Demo plan")
                .type(Item.Type.PLAN)
                .itemApplicability(Item.ItemApplicability.ALL)
                .param("channel","play_store")
                .request();
        ItemPrice.create()
                .id("monthly-plan-gps-USD")
                .name("Monthly GPS USD Plan")
                .itemId("monthly-plan-gps")
                .currencyCode("USD")
                .price(5000)
                .periodUnit(ItemPrice.PeriodUnit.MONTH)
                .period(1)
                .param("channel","play_store")
                .request();
    }
}
