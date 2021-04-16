package moe.dazecake.atc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveReturn {
    Integer cid;
    Integer total;
    Integer ctotal;
    HashMap<String, Integer> time;
    List<String> device;
    Fdata fdata;
    String crime;

}
