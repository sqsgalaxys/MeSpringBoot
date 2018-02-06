SHOW TABLES;

-- noinspection SqlResolve
SELECT *
FROM MEUSER;
-- noinspection SqlResolve
SELECT *
FROM TASK;
DROP TABLE IF EXISTS MEUSER;

-- noinspection SqlResolve
SELECT *
FROM ME_USER;
-- noinspection SqlResolve
INSERT INTO ME_USER (me_Id, me_Name, me_Password) VALUES (1, 'test', 'test');


