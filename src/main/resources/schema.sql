DROP TABLE IF EXISTS permission;
CREATE TABLE permission
(
    id         bigint unsigned NOT NULL AUTO_INCREMENT,
    code       varchar(255)                       NOT NULL,
    name       varchar(255)                       NOT NULL,
    created_on datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_on datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted_on datetime,
    version    bigint unsigned DEFAULT '0' NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT permission_ix1 UNIQUE (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS permission_role;
CREATE TABLE permission_role
(
    permission_id bigint unsigned NOT NULL,
    role_id       bigint unsigned NOT NULL,
    created_on    datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_on    datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted_on    datetime,
    version       bigint unsigned DEFAULT '0' NOT NULL,
    PRIMARY KEY (permission_id, role_id),
    INDEX         permission_role_fk2(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS role;
CREATE TABLE role
(
    id          bigint unsigned NOT NULL AUTO_INCREMENT,
    code        varchar(255)                       NOT NULL,
    name        varchar(255)                       NOT NULL,
    description varchar(255),
    created_on  datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_on  datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted_on  datetime,
    version     bigint unsigned DEFAULT '0' NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT role_ix1 UNIQUE (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS role_user;
CREATE TABLE role_user
(
    role_id    bigint unsigned NOT NULL,
    user_id    bigint unsigned NOT NULL,
    created_on datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_on datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted_on datetime,
    version    bigint unsigned DEFAULT '0' NOT NULL,
    PRIMARY KEY (role_id, user_id),
    INDEX      role_user_fk2(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id         bigint unsigned NOT NULL AUTO_INCREMENT,
    username   varchar(24)                        NOT NULL,
    password   varchar(255)                       NOT NULL,
    email      varchar(255)                       NOT NULL,
    created_on datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_on datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    deleted_on datetime,
    version    bigint unsigned DEFAULT '0' NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT user_ix1 UNIQUE (username),
    CONSTRAINT user_ix2 UNIQUE (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE permission_role
    ADD CONSTRAINT permission_role_fk1 FOREIGN KEY (permission_id) REFERENCES permission (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE permission_role
    ADD CONSTRAINT permission_role_fk2 FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE role_user
    ADD CONSTRAINT role_user_fk1 FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE role_user
    ADD CONSTRAINT role_user_fk2 FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;