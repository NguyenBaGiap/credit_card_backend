CREATE TABLE customer
(
    id                          BIGINT AUTO_INCREMENT NOT NULL,
    cif                         VARCHAR(255) NULL,
    mobile_number               VARCHAR(20) NULL,
    email                       VARCHAR(255) NULL,
    full_name                   VARCHAR(255) NULL,
    profile_customer_type       VARCHAR(255) NULL,
    customer_status             VARCHAR(255) NULL,
    marital_status              VARCHAR(255) NULL,
    education_level_code        VARCHAR(255) NULL,
    customer_type               VARCHAR(255) NULL,
    pid                         VARCHAR(255) NULL,
    pid_issued_date             datetime NULL,
    pid_issued_place            VARCHAR(255) NULL,
    gender                      VARCHAR(255) NULL,
    dob                         datetime NULL,
    country_code                VARCHAR(255) NULL,
    residential_province_code   VARCHAR(255) NULL,
    residential_district_code   VARCHAR(255) NULL,
    residential_ward_code       VARCHAR(255) NULL,
    residential_address_details VARCHAR(255) NULL,
    current_province_code       VARCHAR(255) NULL,
    current_district_code       VARCHAR(255) NULL,
    current_ward_code           VARCHAR(255) NULL,
    current_address_details     VARCHAR(255) NULL,
    created_at                  datetime NULL,
    updated_at                  datetime NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE adsense
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    customer_id  BIGINT NULL,
    utm_source   VARCHAR(255) NULL,
    utm_medium   VARCHAR(255) NULL,
    utm_campaign VARCHAR(255) NULL,
    utm_content  VARCHAR(255) NULL,
    created_at   datetime NULL,
    CONSTRAINT pk_adsense PRIMARY KEY (id)
);

CREATE TABLE consultancy_request_ticket
(
    id                        BIGINT AUTO_INCREMENT NOT NULL,
    customer_id               BIGINT NULL,
    full_name                 VARCHAR(255) NULL,
    email                     VARCHAR(255) NULL,
    mobile_number             VARCHAR(255) NULL,
    consultancy_chanel        INT NULL,
    information_additional    VARCHAR(255) NULL,
    time_receive_consultancy  VARCHAR(255) NULL,
    transaction_location_code VARCHAR(255) NULL,
    created_at                datetime NULL,
    updated_at                datetime NULL,
    CONSTRAINT pk_consultancyrequestticket PRIMARY KEY (id)
);
CREATE TABLE credit_card
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    code VARCHAR(255) NULL,
    CONSTRAINT pk_creditcard PRIMARY KEY (id)
);
CREATE TABLE credit_card_rating
(
    comment        VARCHAR(255) NULL,
    customer_id    BIGINT NOT NULL,
    credit_card_id BIGINT NOT NULL,
    CONSTRAINT pk_creditcardrating PRIMARY KEY (customer_id, credit_card_id)
);
CREATE TABLE credit_card_registration_profile
(
    id                               BIGINT AUTO_INCREMENT NOT NULL,
    customer_id                      BIGINT NULL,
    ekyc_profile_id                  BIGINT NULL,
    finance_profile_id               BIGINT NULL,
    name_in_card                     VARCHAR(255) NULL,
    credit_limit                     VARCHAR(255) NULL,
    card_activation_code             VARCHAR(255) NULL,
    is_receive_physical_card         BIT(1) NULL,
    is_receive_electronic_statement  BIT(1) NULL,
    is_receive_approval_notification BIT(1) NULL,
    transaction_location_code        VARCHAR(255) NULL,
    time_receive_consultancy         VARCHAR(255) NULL,
    created_at                       datetime NULL,
    updated_at                       datetime NULL,
    CONSTRAINT pk_creditcardregistrationprofile PRIMARY KEY (id)
);

CREATE TABLE ekyc_profile
(
    id                  BIGINT AUTO_INCREMENT NOT NULL,
    customer_id         BIGINT NULL,
    id_front_image      VARCHAR(255) NULL,
    id_back_image       VARCHAR(255) NULL,
    id_face_image       VARCHAR(255) NULL,
    id_face_up_image    VARCHAR(255) NULL,
    id_face_left_image  VARCHAR(255) NULL,
    id_face_right_image VARCHAR(255) NULL,
    id_face_video       VARCHAR(255) NULL,
    created_at          datetime NULL,
    updated_at          datetime NULL,
    CONSTRAINT pk_ekycprofile PRIMARY KEY (id)
);

CREATE TABLE finance_profile
(
    id                            BIGINT AUTO_INCREMENT NOT NULL,
    customer_id                   BIGINT NULL,
    employment_type               VARCHAR(255) NULL,
    job_code                      VARCHAR(255) NULL,
    position_code                 VARCHAR(255) NULL,
    working_time_at_position_code VARCHAR(255) NULL,
    company_name                  VARCHAR(255) NULL,
    company_address               VARCHAR(255) NULL,
    company_size                  VARCHAR(255) NULL,
    contract_type                 VARCHAR(255) NULL,
    average_monthly_income        VARCHAR(255) NULL,
    form_of_receive_income        VARCHAR(255) NULL,
    evaluation_criteria_code      VARCHAR(255) NULL,
    CONSTRAINT pk_financeprofile PRIMARY KEY (id)
);
CREATE TABLE document_reference
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    id_reference_image VARCHAR(255) NULL,
    document_code      VARCHAR(255) NULL,
    finance_profile_id BIGINT NOT NULL,
    CONSTRAINT pk_documentreference PRIMARY KEY (id)
);

ALTER TABLE finance_profile
    ADD CONSTRAINT FK_FINANCEPROFILE_ON_CUSTOMERID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE document_reference
    ADD CONSTRAINT FK_DOCUMENTREFERENCE_ON_FINANCEPROFILEID FOREIGN KEY (finance_profile_id) REFERENCES finance_profile (id);

ALTER TABLE ekyc_profile
    ADD CONSTRAINT FK_EKYCPROFILE_ON_CUSTOMERID FOREIGN KEY (customer_id) REFERENCES customer (id);


ALTER TABLE customer
    ADD CONSTRAINT uc_f4984e8a6728658fde6092969 UNIQUE (mobile_number);
ALTER TABLE credit_card_rating
    ADD CONSTRAINT FK_CREDITCARDRATING_ON_CREDITCARDID FOREIGN KEY (credit_card_id) REFERENCES credit_card (id);

ALTER TABLE credit_card_rating
    ADD CONSTRAINT FK_CREDITCARDRATING_ON_CUSTOMERID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE consultancy_request_ticket
    ADD CONSTRAINT FK_CONSULTANCYREQUESTTICKET_ON_CUSTOMERID FOREIGN KEY (customer_id) REFERENCES customer (id);
ALTER TABLE adsense
    ADD CONSTRAINT FK_ADSENSE_ON_CUSTOMERID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE credit_card_registration_profile
    ADD CONSTRAINT FK_CREDITCARDREGISTRATIONPROFILE_ON_CUSTOMERID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE credit_card_registration_profile
    ADD CONSTRAINT FK_CREDITCARDREGISTRATIONPROFILE_ON_EKYCPROFILEID FOREIGN KEY (ekyc_profile_id) REFERENCES ekyc_profile (id);

ALTER TABLE credit_card_registration_profile
    ADD CONSTRAINT FK_CREDITCARDREGISTRATIONPROFILE_ON_FINANCEPROFILEID FOREIGN KEY (finance_profile_id) REFERENCES finance_profile (id);