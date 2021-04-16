package moe.dazecake.atc.service.impl;

import moe.dazecake.atc.pojo.DataCenter;
import moe.dazecake.atc.pojo.Fdata;
import moe.dazecake.atc.pojo.FrameUper;
import moe.dazecake.atc.pojo.Solution;
import moe.dazecake.atc.service.FrameUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class FrameUpService_impl implements FrameUpService {

    @Autowired
    Solution solution;

    @Autowired
    Fdata fdata;

    @Override
    public void addFrame(FrameUper frameUper) {

        solution.returnObject().setFdata(frameUper.getFdata());
        fdata = new Fdata(frameUper.getCid(), frameUper.getRtmp(), frameUper.getFdata());
        solution.returnObject().getFdataCenter().add(fdata);

        //遍历获取人数
        int total = 0;
        for (Map.Entry<Integer, ArrayList<Double>> entry : frameUper.getFdata().entrySet()) {
            if (total< entry.getKey()){
                total = entry.getKey();
            }
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        solution.returnObject().setTotal(total);
//        solution.returnObject().setTotal(frameUper.getFdata().size());
        return;
    }


}
