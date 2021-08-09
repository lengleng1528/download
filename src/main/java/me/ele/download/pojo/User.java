package me.ele.download.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String username;

    private String password;

    private Integer status;

    private Date createAt;

    private Date updateAt;

    private Integer isDeleted;

    private Integer type;


}
