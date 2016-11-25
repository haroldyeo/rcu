
    create table DEMO.CLIENT_UNIQUE_OCIT (
        PHONE varchar2(20 char) not null,
        DATE_CESSATION date,
        DATE_CREATION date,
        MASTER_ID number(22,0) not null,
        TYPE_MATCH varchar2(20 char),
        TYPESERVICE number(22,0),
        primary key (PHONE)
    );

    create table DEMO.LIST_SELECTION_STG (
        IDCLIENT number(10,0) not null,
        ADRESSPOSTAL varchar2(255 char),
        CONTACT varchar2(25 char),
        CPOSTAL_BP varchar2(8 char),
        DATNAI varchar2(255 char),
        DESCRIPTION varchar2(255 char),
        EMAIL varchar2(100 char),
        IDENTITE varchar2(512 char),
        LIEUNAI varchar2(255 char),
        NOM varchar2(255 char),
        NUMERO_MOBILE varchar2(20 char),
        NUMEROBP varchar2(8 char),
        PHONE varchar2(32 char),
        PHONE_PRINCIPAL varchar2(1 char),
        PIECEIDENTITE varchar2(255 char),
        PRENOM varchar2(255 char),
        REF_CLIENT_EXT varchar2(100 char),
        STATUT varchar2(4000 char),
        TYPE_PIECE varchar2(3 char),
        TYPESERVICE number(22,0),
        primary key (IDCLIENT)
    );

    create table DEMO.T_FINAL (
        id number(19,0) not null,
        compteId varchar2(255 char),
        dateCessation varchar2(255 char),
        dateCreation varchar2(255 char),
        master_id varchar2(255 char) not null,
        masterIdB2C varchar2(255 char),
        systemSourceCode varchar2(255 char),
        typeMatch varchar2(255 char),
        typerService varchar2(255 char),
        primary key (id)
    );

    create table DEMO.T_USERS (
        ID number(22,0) not null,
        ADRESSE varchar2(40 char),
        AVISO varchar2(40 char),
        DATE_NAISSANCE varchar2(50 char),
        EMAIL varchar2(40 char),
        LIEU_NAISSANCE varchar2(40 char),
        NOM varchar2(20 char),
        ORANGE_MONEY varchar2(40 char),
        PRENOMS varchar2(40 char),
        SERVICE varchar2(40 char),
        TEL_FIXE varchar2(10 char),
        TEL_MOBILE varchar2(10 char),
        TYPE_SERVICE varchar2(40 char),
        primary key (ID)
    );
