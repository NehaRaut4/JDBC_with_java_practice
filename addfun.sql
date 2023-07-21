DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `function1`(n1 integer,n2 integer) RETURNS int
    DETERMINISTIC
BEGIN
declare n3 integer;
set n3 = n1 + n2;
RETURN n3;
END$$
DELIMITER ;
