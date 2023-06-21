SELECT A.APNT_NO  -- 진료예약번호
     , P.PT_NAME  -- 환자이름
     , P.PT_NO    -- 환자번호
     , A.MCDP_CD  -- 진료과코드
     , D.DR_NAME  -- 의사이름
     , A.APNT_YMD -- 진료예약일시
FROM   APPOINTMENT A
JOIN   PATIENT P
ON     A.PT_NO = P.PT_NO
JOIN   DOCTOR D
ON     A.MDDR_ID = D.DR_ID
WHERE  A.APNT_YMD LIKE '2022-04-13%'
AND    APNT_CNCL_YN = 'N'
AND    A.MCDP_CD = 'CS'
ORDER BY A.APNT_YMD;