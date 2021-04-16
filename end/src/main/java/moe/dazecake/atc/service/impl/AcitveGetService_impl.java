package moe.dazecake.atc.service.impl;

import com.google.gson.Gson;
import moe.dazecake.atc.pojo.*;
import moe.dazecake.atc.service.ActiveGetService;
import moe.dazecake.atc.util.TimeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AcitveGetService_impl implements ActiveGetService {
    @Autowired
    Solution solution;

    @Autowired
    TimeSet timeSet;

    @Override
    public String getActive(ActiveGetter activeGetter) {
        solution.returnObject().setRflag(activeGetter.isRflag());
        HashMap<String, Object> map = new HashMap<>();
        ActiveReturn activeReturn = new ActiveReturn();
        activeReturn.setCid(activeGetter.getCid());
        solution.returnObject().setTime(timeSet.getTimeSet());
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        map.put("cid", activeReturn.getCid());
        map.put("total", solution.returnObject().getTotal());
        map.put("ctotal", solution.returnObject().getCtotal());
        map.put("time", solution.returnObject().getTime());
        map.put("device", list);
        map.put("fdata", solution.returnObject().getFdataCenter().get(solution.returnObject().getFdataCenter().size() - 1));
        String path = "/" + activeGetter.getCid();
        ArrayList crimelist = new ArrayList();
        if (solution.returnObject().getCpid().get(activeGetter.getCid())==null){
            solution.returnObject().getCpid().put(activeGetter.getCid(), 0);
        }
        Integer num = solution.returnObject().getCpid().get(activeGetter.getCid());
        if (num < 9) {
            for (Integer i = 1; i <= num; i++) {
                crimelist.add(path + File.separator + i.toString() + ".jpg");
            }
        } else {
            for (int i = 0; i < 9; i++) {
                crimelist.add(path + File.separator + (num - i) + ".jpg");
            }
        }
        map.put("crime", crimelist);

        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
