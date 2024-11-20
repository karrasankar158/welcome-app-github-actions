package com.fsd.controller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;   

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
@Slf4j
public class WelcomeServiceImpl {

    private final Map<String,Object> greetingsMap=new LinkedHashMap<>(); //Insertion Order

    /**
     * Update the greetings map with input and dynamic data.
     * @param inputMap
     * @return updated greetings map
     */
    public String sendingGreetings(Map<String,Object> inputMap){
        //Add entries from input to greetings map
        inputMap.forEach(greetingsMap::put);
        log.info("request data processed.");

        //Add current date-time and status, static values
        String dateAndTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        greetingsMap.put("Date and Time",dateAndTime);
        greetingsMap.put("status", "success");

        return "Greetings send successfully";
    }    

    /**
     * Returns the current greetings map.
     */
    public Map<String,Object> retrievesGreetings(){
        log.info("updated greetings.");
      return greetingsMap;
    }
}
