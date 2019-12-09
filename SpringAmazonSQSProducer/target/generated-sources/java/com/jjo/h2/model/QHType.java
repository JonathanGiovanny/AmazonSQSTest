package com.jjo.h2.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHType is a Querydsl query type for HType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHType extends EntityPathBase<HType> {

    private static final long serialVersionUID = 1679751077L;

    public static final QHType hType = new QHType("hType");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QHType(String variable) {
        super(HType.class, forVariable(variable));
    }

    public QHType(Path<? extends HType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHType(PathMetadata metadata) {
        super(HType.class, metadata);
    }

}

