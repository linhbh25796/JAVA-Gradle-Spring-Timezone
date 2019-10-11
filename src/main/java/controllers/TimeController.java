package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/worldclock")
    public String getTimeByTimeZone(ModelMap modelMap, @RequestParam(name = "city", required = false,
            defaultValue = "Aisa/Ho_Chi_Minh") String city) {
        // Get current time at local
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        // Get timezone by the local
        TimeZone locale = TimeZone.getTimeZone(city);

        // Calculate the current time in the specified city

        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        //Reset the date by the locale time
        date.setTime(locale_time);

        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);




        return "index";
    }

}
