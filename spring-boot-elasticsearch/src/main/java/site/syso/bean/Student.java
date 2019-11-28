package site.syso.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Document(indexName = "student", type = "_doc")
public class Student {

    @Id
    private Long id;

    private String name;

    private String hobby;

    private Date birthday;

}
