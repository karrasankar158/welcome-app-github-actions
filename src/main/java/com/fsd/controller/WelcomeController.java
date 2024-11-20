package com.fsd.controller;

import com.fsd.controller.service.WelcomeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/greetings")
@Slf4j
public class WelcomeController {


    @Autowired
    private WelcomeServiceImpl welcomeServiceImpl;

    /**
     * Processes and updates the greetings map.
     * @param inputMap input map sent in the POST request.
     * @return updated greetings Map
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendingGreetings(@RequestBody Map<String,Object> inputMap){
        log.info("calling send  end point");
        String welcomeMessage=welcomeServiceImpl.sendingGreetings(inputMap);
        return new ResponseEntity<>(welcomeMessage,HttpStatus.CREATED);
    }

    /**
     * Retrieves the current greetings map.
     * @return
     */
    @GetMapping("/retrieve")
    public ResponseEntity<Map<String,Object>> retrieveGreetings(){
        log.info("calling send  retrieve point");
        Map<String,Object> greetingsReceived=welcomeServiceImpl.retrievesGreetings();
        return new ResponseEntity<>(greetingsReceived,HttpStatus.OK);
    }
}
