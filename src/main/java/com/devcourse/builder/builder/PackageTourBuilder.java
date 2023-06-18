package com.devcourse.builder.builder;


import com.devcourse.builder.builder.model.*;

public class PackageTourBuilder implements Builder {

    private PackageTour packageTour;

    public PackageTourBuilder() {
        reset();
    }

    @Override
    public void reset() {
        this.packageTour = new PackageTour();
    }

    @Override
    public Builder addGuide(Guide guide) {
        System.out.println("가이드 옵션 추가");
        packageTour.setGuide(guide);
        return this;
    }

    @Override
    public Builder addAirlineTicket(AirlineTicket airlineTicket) {
        System.out.println("항공권 옵션 추가");
        packageTour.setAirlineTicket(airlineTicket);
        return this;
    }

    @Override
    public Builder addHotel(Hotel hotel) {
        System.out.println("호텔 옵션 포함");
        packageTour.setHotel(hotel);
        return this;
    }

    @Override
    public Builder addMeal(Meal meal) {
        System.out.println("식사 옵션 포함");
        packageTour.setMeal(meal);
        return this;
    }

    @Override
    public PackageTour getPackageTour() {
        System.out.println("패키지 투어 완성!");
        PackageTour customedPackageTour = this.packageTour;
        reset();
        return customedPackageTour;
    }
}
