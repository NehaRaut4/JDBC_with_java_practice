
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure2`(in eid int,out ename varchar(20),out esal float)
BEGIN
select name,salary into ename,esal from emp where id=eid;

END$$
DELIMITER ;

