SELECT CONCAT('/home/grep/src/', FL.BOARD_ID, '/', FL.FILE_ID, FL.FILE_NAME, FL.FILE_EXT) FILE_PATH
FROM   USED_GOODS_BOARD BRD
JOIN   USED_GOODS_FILE FL
ON     BRD.BOARD_ID = FL.BOARD_ID
WHERE  BRD.VIEWS = (
        SELECT MAX(VIEWS)
        FROM   USED_GOODS_BOARD)
ORDER BY FILE_PATH DESC;