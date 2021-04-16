package moe.dazecake.atc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataCenter {
    Integer total = 0;
    Integer ctotal = 0;
    boolean rflag = false;
    HashMap<String, Integer> time = new HashMap<>();
    ArrayList<String> device = new ArrayList<>();
    ArrayList<Fdata> fdataCenter = new ArrayList<>();
    HashMap<String, String> rtmp = new HashMap<>();
    HashMap<Integer, ArrayList<Double>> fdata = new HashMap<>();
    HashMap<Integer ,Integer > cpid = new HashMap<>();
}
