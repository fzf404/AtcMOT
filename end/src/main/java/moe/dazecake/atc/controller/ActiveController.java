package moe.dazecake.atc.controller;

import com.google.gson.Gson;
import moe.dazecake.atc.pojo.ActiveReturn;
import moe.dazecake.atc.pojo.ActiveGetter;
import moe.dazecake.atc.service.ActiveGetService;
import moe.dazecake.atc.service.impl.AcitveGetService_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
public class ActiveController {
    @Autowired
    AcitveGetService_impl acitveGetService_impl;

    @GetMapping("/api/active")
    public String active(ActiveGetter activeGetter) {
        Gson gson = new Gson();
        return acitveGetService_impl.getActive(activeGetter);
    }
}
