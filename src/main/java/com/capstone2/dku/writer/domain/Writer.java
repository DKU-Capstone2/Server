package com.capstone2.dku.writer.domain;

import com.capstone2.dku.user.domain.User;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@DiscriminatorValue("w")
@PrimaryKeyJoinColumn(name = "writer_id")
@Entity
public class Writer extends User {

    @Column(name = "role")
    private String role; // 작가 = "w", 독자 = "r"

    public Writer(String name, String email, String password, String phoneNumber, String role){
        super(name,email,password,phoneNumber);
        this.role = role;
    }
}
