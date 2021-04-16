package moe.dazecake.atc.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Solution {
    private DataCenter dataCenter = new DataCenter();

    private Solution() {
    }

    public DataCenter returnObject(){
        return dataCenter;
    }
}
