package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
// 在企业中，我们的所有 pojo 都会序列化！SpringBoot
public class User implements Serializable {

    private String name;
    private int age;
}
