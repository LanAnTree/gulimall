package com.lanan.gulimallsearch.entity;

import lombok.Data;

/**
 * @author LanAn
 * @date 2022/8/21-6:39
 */
@Data
public class Account {
    public Integer accountNumber;
    public Long balance;
    public String firstname;
    public String lastname;
    public Integer age;
    public String gender;
    public String address;
    public String employer;
    public String email;
    public String city;
    public String state;
}

