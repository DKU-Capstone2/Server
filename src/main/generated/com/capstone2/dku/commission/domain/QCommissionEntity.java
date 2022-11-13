package com.capstone2.dku.commission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommissionEntity is a Querydsl query type for CommissionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommissionEntity extends EntityPathBase<CommissionEntity> {

    private static final long serialVersionUID = 2045690033L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommissionEntity commissionEntity = new QCommissionEntity("commissionEntity");

    public final StringPath commissionContent = createString("commissionContent");

    public final NumberPath<Long> commissionId = createNumber("commissionId", Long.class);

    public final StringPath commissionState = createString("commissionState");

    public final com.capstone2.dku.user.domain.QUser user;

    public final com.capstone2.dku.writer.domain.QWriter writer;

    public QCommissionEntity(String variable) {
        this(CommissionEntity.class, forVariable(variable), INITS);
    }

    public QCommissionEntity(Path<? extends CommissionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommissionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommissionEntity(PathMetadata metadata, PathInits inits) {
        this(CommissionEntity.class, metadata, inits);
    }

    public QCommissionEntity(Class<? extends CommissionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.capstone2.dku.user.domain.QUser(forProperty("user")) : null;
        this.writer = inits.isInitialized("writer") ? new com.capstone2.dku.writer.domain.QWriter(forProperty("writer")) : null;
    }

}

