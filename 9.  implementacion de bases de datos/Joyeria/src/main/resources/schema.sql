create table joya (
    id bigint not null,
    nombre varchar(255),
    material varchar(255),
    peso decimal(10, 2),
    particularidad varchar(255),
    poseePiedra boolean,
    vendida boolean,

    primary key (id)
);