package moe.dazecake.atc.controller;

import com.google.gson.Gson;
import moe.dazecake.atc.pojo.FrameReturn;
import moe.dazecake.atc.pojo.FrameUper;
import moe.dazecake.atc.pojo.Solution;
import moe.dazecake.atc.service.impl.FrameUpService_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
public class FrameUpController {
    @Autowired
    FrameUpService_impl frameUpService_impl;

    @Autowired
    Solution solution;


    @PostMapping("/api/frame")
    public String test(@RequestBody FrameUper frameUper) {
        frameUpService_impl.addFrame(frameUper);
        Gson gson = new Gson();
        return gson.toJson(new FrameReturn("200", solution.returnObject().isRflag()));
//        System.out.println(gson.toJson(frameUper));
//        return gson.toJson(frameUper);
    }
}
