package moe.dazecake.atc.controller;

import com.google.gson.Gson;
import moe.dazecake.atc.pojo.CrimeReturn;
import moe.dazecake.atc.pojo.CrimeUper;
import moe.dazecake.atc.service.impl.CrimeUpService_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@ResponseBody
@RestController
public class CrimeUpController {
    @Autowired
    CrimeUpService_impl crimeUpService_impl;


    @PostMapping("/api/crime")
    public String test(CrimeUper crimeUper) throws IOException {
        crimeUpService_impl.addCrime(crimeUper);
        Gson gson = new Gson();
        return gson.toJson(new CrimeReturn("200"));
    }
}
