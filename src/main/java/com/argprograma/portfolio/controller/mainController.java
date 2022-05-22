
package com.argprograma.portfolio.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class mainController {
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> saludar(){
        System.out.println("LLEGO UN REQUEST");
        return new ResponseEntity<>("que onda", HttpStatus.OK);
    }
}
