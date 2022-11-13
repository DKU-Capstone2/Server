package com.capstone2.dku.reader.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReader is a Querydsl query type for Reader
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReader extends EntityPathBase<Reader> {

    private static final long serialVersionUID = -397008802L;

    public static final QReader reader = new QReader("reader");

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

    public QReader(String variable) {
        super(Reader.class, forVariable(variable));
    }

    public QReader(Path<? extends Reader> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReader(PathMetadata metadata) {
        super(Reader.class, metadata);
    }

}

