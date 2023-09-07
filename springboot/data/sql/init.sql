CREATE DATABASE IF NOT EXISTS springboot;
USE springboot;

CREATE TABLE IF NOT EXISTS credential (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    create_time DATETIME,
    update_time DATETIME
);

CREATE TABLE IF NOT EXISTS machine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    credential_id BIGINT,
    name VARCHAR(255),
    outer_ip VARCHAR(32),
    inner_ip  VARCHAR(32),
    create_time DATETIME,
    update_time DATETIME
);

INSERT INTO credential (id, name, type, create_time, update_time)
SELECT 1, 'jaronnie', 'k8s', '2023-09-01 10:00:00', '2023-09-01 10:00:00'
FROM DUAL
WHERE NOT EXISTS (
    SELECT 1
    FROM credential
    WHERE id = 1
);

INSERT INTO machine (id, credential_id, name, outer_ip, inner_ip, create_time, update_time)
SELECT 1, 1, 'k8s', "10.1.43.157", "192.168.0.1", '2023-09-01 10:00:00', '2023-09-01 10:00:00'
FROM DUAL
WHERE NOT EXISTS (
    SELECT 1
    FROM machine
    WHERE id = 1
);