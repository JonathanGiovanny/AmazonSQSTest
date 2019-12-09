package com.jjo.h2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QH is a Querydsl query type for H
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QH extends EntityPathBase<H> {

    private static final long serialVersionUID = -1264922165L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QH h = new QH("h");

    public final com.jjo.h2.model.audit.QAuditable _super = new com.jjo.h2.model.audit.QAuditable(this);

    public final NumberPath<Long> clicks = createNumber("clicks", Long.class);

    public final StringPath cover = createString("cover");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> creationDate = _super.creationDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final NumberPath<Double> score = createNumber("score", Double.class);

    public final SetPath<Tags, QTags> tags = this.<Tags, QTags>createSet("tags", Tags.class, QTags.class, PathInits.DIRECT2);

    public final QHType type;

    public final StringPath url = createString("url");

    public QH(String variable) {
        this(H.class, forVariable(variable), INITS);
    }

    public QH(Path<? extends H> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QH(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QH(PathMetadata metadata, PathInits inits) {
        this(H.class, metadata, inits);
    }

    public QH(Class<? extends H> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.type = inits.isInitialized("type") ? new QHType(forProperty("type")) : null;
    }

}

