package moe.dazecake.atc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrameUper {
    private String cid;
    private String rtmp;
    private HashMap<Integer, ArrayList<Double>> fdata;
}
