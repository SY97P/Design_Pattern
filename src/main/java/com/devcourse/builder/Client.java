package com.devcourse.builder;

import com.devcourse.builder.builder.PackageTourBuilder;
import com.devcourse.builder.builder.model.AirlineTicket;
import com.devcourse.builder.builder.model.Hotel;
import com.devcourse.builder.builder.model.Meal;
import com.devcourse.builder.builder.model.PackageTour;

public class Client {
    public static void main(String[] args) {
        PackageTourBuilder builder = new PackageTourBuilder();

        PackageTour myPackageTour = builder
                .addAirlineTicket(new AirlineTicket("한국행"))
                .addHotel(new Hotel("신라호텔"))
                .addMeal(new Meal("고오급 스테끼"))
                .getPackageTour();
    }
}