package com.capstone2.dku.commission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommissionEntity is a Querydsl query type for CommissionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommissionEntity extends EntityPathBase<CommissionEntity> {

    private static final long serialVersionUID = 2045690033L;

    public static final QCommissionEntity commissionEntity = new QCommissionEntity("commissionEntity");

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public QCommissionEntity(String variable) {
        super(CommissionEntity.class, forVariable(variable));
    }

    public QCommissionEntity(Path<? extends CommissionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommissionEntity(PathMetadata metadata) {
        super(CommissionEntity.class, metadata);
    }

}

