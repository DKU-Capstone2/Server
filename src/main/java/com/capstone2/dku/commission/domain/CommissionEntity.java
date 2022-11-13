package com.capstone2.dku.commission.domain;

import javax.persistence.*;

@Table(name = "commissions")
@Entity
public class CommissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commission_id")
    private Long postId;


}
