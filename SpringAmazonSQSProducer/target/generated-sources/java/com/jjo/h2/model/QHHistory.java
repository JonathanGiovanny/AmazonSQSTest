package com.jjo.h2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHHistory is a Querydsl query type for HHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHHistory extends EntityPathBase<HHistory> {

    private static final long serialVersionUID = -1714479031L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHHistory hHistory = new QHHistory("hHistory");

    public final StringPath creationBy = createString("creationBy");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final QH h;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QHHistory(String variable) {
        this(HHistory.class, forVariable(variable), INITS);
    }

    public QHHistory(Path<? extends HHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHHistory(PathMetadata metadata, PathInits inits) {
        this(HHistory.class, metadata, inits);
    }

    public QHHistory(Class<? extends HHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.h = inits.isInitialized("h") ? new QH(forProperty("h"), inits.get("h")) : null;
    }

}

