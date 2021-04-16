package moe.dazecake.atc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrimeUper {
    private Integer cid;
    private Integer pid;
    private MultipartFile photo;
}
