CREATE DATABASE IF NOT EXISTS springboot;
USE springboot;

CREATE TABLE IF NOT EXISTS credential (
    id BIGINT,
    name VARCHAR(255),
    type VARCHAR(255)
);

INSERT INTO credential (id, name, type)
SELECT 1, 'jaronnie', 'k8s'
FROM DUAL
WHERE NOT EXISTS (
    SELECT 1
    FROM credential
    WHERE id = 1
);