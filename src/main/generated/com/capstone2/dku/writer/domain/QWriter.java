package com.capstone2.dku.writer.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWriter is a Querydsl query type for Writer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWriter extends EntityPathBase<Writer> {

    private static final long serialVersionUID = 412517310L;

    public static final QWriter writer = new QWriter("writer");

    public final com.capstone2.dku.user.domain.QUser _super = new com.capstone2.dku.user.domain.QUser(this);

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final StringPath phoneNumber = _super.phoneNumber;

    public final StringPath role = createString("role");

    //inherited
    public final ListPath<String, StringPath> roles = _super.roles;

    public final StringPath type = createString("type");

    public QWriter(String variable) {
        super(Writer.class, forVariable(variable));
    }

    public QWriter(Path<? extends Writer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWriter(PathMetadata metadata) {
        super(Writer.class, metadata);
    }

}

