SELECT ANIMAL_ID
     , NAME
     , SEX_UPON_INTAKE
FROM   ANIMAL_INS AS I
WHERE  I.NAME IN ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID;