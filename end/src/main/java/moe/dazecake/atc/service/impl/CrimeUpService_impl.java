package moe.dazecake.atc.service.impl;

import moe.dazecake.atc.pojo.CrimeUper;
import moe.dazecake.atc.pojo.DataCenter;
import moe.dazecake.atc.pojo.Solution;
import moe.dazecake.atc.service.CrimeUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;

@Service
public class CrimeUpService_impl implements CrimeUpService {
    @Autowired
    Solution solution;

    @Override
    public void addCrime(CrimeUper crimeUper) throws IOException {
        solution.returnObject().setCtotal(solution.returnObject().getCtotal() + 1);
        HashMap<Integer ,Integer> map = new HashMap<>();
        map.put(crimeUper.getCid(), crimeUper.getPid());
        solution.returnObject().setCpid(map);

        //存储路径
        String path = "/opt/crime/" + crimeUper.getCid();
        String fileName = crimeUper.getPid() + ".jpg";

        File file = new File(path);
        String pathFile = path + File.separator + fileName;
        File newFile = new File(pathFile);
        //判断文件夹是否存在，不存在则创建
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        try {
            //文件传输到本地
            crimeUper.getPhoto().transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
