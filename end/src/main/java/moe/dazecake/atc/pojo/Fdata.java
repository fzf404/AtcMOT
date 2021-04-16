package moe.dazecake.atc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fdata {
    String cid;
    String rtmp;
    HashMap<Integer,ArrayList<Double>> fdata;
}
