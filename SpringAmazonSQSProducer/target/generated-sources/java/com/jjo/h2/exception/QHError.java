package com.jjo.h2.exception;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHError is a Querydsl query type for HError
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHError extends EntityPathBase<HError> {

    private static final long serialVersionUID = -34017513L;

    public static final QHError hError = new QHError("hError");

    public final NumberPath<Integer> code = createNumber("code", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> eventTime = createDateTime("eventTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath techMessage = createString("techMessage");

    public final StringPath userMessage = createString("userMessage");

    public QHError(String variable) {
        super(HError.class, forVariable(variable));
    }

    public QHError(Path<? extends HError> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHError(PathMetadata metadata) {
        super(HError.class, metadata);
    }

}

