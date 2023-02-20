CREATE TABLE IF NOT EXISTS `users` (
    `username` varchar(50) NOT NULL,
    `password` varchar(100) NOT NULL,
    `enabled` tinyint(1) NOT NULL,

    PRIMARY KEY (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `authorities` (
    `username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,

    UNIQUE KEY `ix_auth_username` (`username`,`authority`),
    CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `users` (`username`, `password`, `enabled`) VALUES
    ('user', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1),
    ('root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 1);

INSERT IGNORE INTO `authorities` (`username`, `authority`) VALUES
    ('root', 'ROLE_ADMIN'),
    ('user', 'ROLE_USER');