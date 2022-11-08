package com.capstone2.dku.writer.domain;

import com.capstone2.dku.user.domain.User;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "writer_id")
@DiscriminatorValue("w")
@Entity
public class Writer extends User {

    @Column(name = "role")
    private String role; // 작가 = "w", 독자 = "r"

    @Column(name = "type")
    private String type;

    public Writer(String name, String email, String password, String phoneNumber, String role, String type){
        super(name,email,password,phoneNumber);
        this.role = role;
        this.type = type;
    }
}
