CREATE DATABASE IF NOT EXISTS springboot;
USE springboot;

CREATE TABLE IF NOT EXISTS credential (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
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