package com.capstone2.dku.commission.domain;

import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.writer.domain.Writer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter // 엔티티에는 "@Getter", "@Setter"를 사용하면 안되지만 시간이 없어 사용했습니다.
@Table(name = "commissions")
@Entity
public class CommissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commission_id")
    private Long commissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Writer writer;

    // 커미션 상태가 "신청", "수락", "거절"과 같은 값은 은유님이 만드시길 바랍니다.
    @Column(name = "commission_sate")
    private String commissionState;

    // 커미션 내용
    @Column(name = "commission_content")
    private String commissionContent;

    @Builder
    public CommissionEntity(User user, Writer writer, String commissionState, String commissionContent){
        this.user = user;
        this.writer = writer;
        this.commissionState = commissionState;
        this.commissionContent = commissionContent;
    }
}
