package com.capstone2.dku.reader.domain;

import com.capstone2.dku.user.domain.User;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@DiscriminatorValue("r")
@PrimaryKeyJoinColumn(name = "reader_id")
@Entity
public class Reader extends User {

    @Column(name = "role")
    private String role; // 작가 = "w", 독자 = "r"

    public Reader(String name, String email, String password, String phoneNumber, String role){
        super(name,email,password,phoneNumber);
        this.role = role;
    }
}
