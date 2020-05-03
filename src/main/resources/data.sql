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
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (1, 'P_ACTIVE', 'P Active', '2016-12-05 23:21:16', '2016-12-05 23:21:16', NULL, 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (2, 'P_ACTIVE_2', 'P Active 2', '2016-12-05 23:21:16', '2016-12-05 23:21:16', NULL, 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (3, 'P_ACTIVE_3', 'P Active 3', '2016-12-05 23:21:16', '2016-12-05 23:21:16', NULL, 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (4, 'P_DELETED', 'P Deleted', '2016-12-05 23:21:16', '2016-12-05 23:21:46', '2016-12-05 23:21:16', 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (5, 'P_DELETED_2', 'P Deleted 2', '2016-12-05 23:21:16', '2016-12-05 23:21:46', '2016-12-05 23:21:16', 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (6, 'P_DELETED_3', 'P Deleted 3', '2016-12-05 23:21:16', '2016-12-05 23:21:46', '2016-12-05 23:21:16', 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (7, 'P_SCHEDULED_DELETE', 'P Scheduled Delete', '2016-12-05 23:21:16', '2016-12-05 23:21:46',
        '2100-12-05 23:21:16', 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (8, 'P_SCHEDULED_DELETE_2', 'P Scheduled Delete 2', '2016-12-05 23:21:16', '2016-12-05 23:21:46',
        '2100-12-05 23:21:16', 0);
INSERT INTO permission (id, code, name, created_on, updated_on, deleted_on, version)
VALUES (9, 'P_SCHEDULED_DELETE_3', 'P Scheduled Delete 3', '2016-12-05 23:21:16', '2016-12-05 23:21:46',
        '2100-12-05 23:21:16', 0);
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
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (1, 1, '2016-12-05 23:26:46', '2016-12-05 23:26:46', NULL, 0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (2, 1, '2016-12-05 23:26:46', '2016-12-05 23:27:17', '2016-12-05 23:26:46', 0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (3, 1, '2016-12-05 23:26:46', '2016-12-05 23:27:17', '2100-12-05 23:26:46', 0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (4, 1, '2016-12-05 23:26:46', '2016-12-05 23:26:46', NULL, 0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (7, 1, '2016-12-05 23:26:46', '2016-12-05 23:27:17', '2100-12-05 23:26:46', 0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (8, 1, '2016-12-05 23:26:46', '2016-12-05 23:27:17', '2100-12-05 23:26:46', 0);
INSERT INTO permission_role (permission_id, role_id, created_on, updated_on, deleted_on, version)
VALUES (9, 1, '2016-12-05 23:26:46', '2016-12-05 23:27:17', '2016-12-05 23:26:46', 0);
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
INSERT INTO role (id, code, name, description, created_on, updated_on, deleted_on, version)
VALUES (1, 'ROLE_ACTIVE', 'Role Active', NULL, '2016-12-05 23:19:40', '2016-12-05 23:19:40', NULL, 0);
INSERT INTO role (id, code, name, description, created_on, updated_on, deleted_on, version)
VALUES (2, 'ROLE_ACTIVE_2', 'Role Active 2', NULL, '2016-12-05 23:19:40', '2016-12-05 23:19:40', NULL, 0);
INSERT INTO role (id, code, name, description, created_on, updated_on, deleted_on, version)
VALUES (3, 'ROLE_DELETED', 'Role Deleted', NULL, '2016-12-05 23:19:40', '2016-12-05 23:20:03', '2016-12-05 23:19:40',
        0);
INSERT INTO role (id, code, name, description, created_on, updated_on, deleted_on, version)
VALUES (4, 'ROLE_DELETED_2', 'Role Deleted 2', NULL, '2016-12-05 23:19:40', '2016-12-05 23:20:03',
        '2016-12-05 23:19:40', 0);
INSERT INTO role (id, code, name, description, created_on, updated_on, deleted_on, version)
VALUES (5, 'ROLE_SCHEDULED_DELETE', 'Role Scheduled Delete', NULL, '2016-12-05 23:19:40', '2016-12-05 23:20:03',
        '2100-12-05 23:19:40', 0);
INSERT INTO role (id, code, name, description, created_on, updated_on, deleted_on, version)
VALUES (6, 'ROLE_SCHEDULED_DELETE_2', 'Role Scheduled Delete 2', NULL, '2016-12-05 23:19:40', '2016-12-05 23:20:03',
        '2100-12-05 23:19:40', 0);
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
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (1, 1, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (1, 2, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (1, 3, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (2, 1, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (2, 2, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (2, 3, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (3, 1, '2016-12-05 23:24:32', '2016-12-05 23:25:29', '2016-12-05 23:24:32', 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (3, 2, '2016-12-05 23:24:32', '2016-12-05 23:24:32', NULL, 0);
INSERT INTO role_user (role_id, user_id, created_on, updated_on, deleted_on, version)
VALUES (3, 3, '2016-12-05 23:24:32', '2016-12-05 23:25:29', '2100-12-05 23:24:32', 0);
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
INSERT INTO user (id, username, password, email, created_on, updated_on, deleted_on, version)
VALUES (1, 'userActive', '$2a$10$xdjoYQgKNnlAWV.vBd4jC.wpLlbkW0FkOzZPEHhZN37OiySuQQ6wi', 'useractive@example.com',
        '2016-12-05 23:16:22', '2016-12-05 23:16:22', NULL, 0);
INSERT INTO user (id, username, password, email, created_on, updated_on, deleted_on, version)
VALUES (2, 'userDeleted', '$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.', 'userdeleted@example.com',
        '2016-12-05 23:16:22', '2016-12-05 23:16:50', '2016-12-05 23:16:22', 0);
INSERT INTO user (id, username, password, email, created_on, updated_on, deleted_on, version)
VALUES (3, 'userScheduledDelete', '$2a$10$GPcf0/6W3yOB5UPNl3FxHuXSqKZA3Y3/9VLWonLfLstwFJk8enRcS',
        'userscheduled@example.com', '2016-12-05 23:16:22', '2016-12-05 23:16:50', '2100-12-05 23:16:22', 0);
ALTER TABLE permission_role
    ADD CONSTRAINT permission_role_fk1 FOREIGN KEY (permission_id) REFERENCES permission (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE permission_role
    ADD CONSTRAINT permission_role_fk2 FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE role_user
    ADD CONSTRAINT role_user_fk1 FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE role_user
    ADD CONSTRAINT role_user_fk2 FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;