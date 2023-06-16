SET    @HOUR = -1;
SELECT @HOUR := @HOUR + 1 AS HOUR
     , (SELECT COUNT(*)
        FROM   ANIMAL_OUTS
        WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM   ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN 0 AND 23;