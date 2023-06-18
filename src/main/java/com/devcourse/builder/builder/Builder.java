package com.devcourse.builder.builder;


import com.devcourse.builder.builder.model.*;

public interface Builder {
    void reset();
    Builder addGuide(Guide guide);
    Builder addAirlineTicket(AirlineTicket airlineTicket);
    Builder addHotel(Hotel hotel);
    Builder addMeal(Meal meal);

    PackageTour getPackageTour();
}
