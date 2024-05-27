package com.itacademy;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FakerData {
    @Test
    public void fake(){
        Faker faker = new Faker();
        System.out.println(faker.address());
    }
    @Test
    public void fakeDate(){
        Date date = new Date();
        date.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, 2);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd YYYY");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
