SELECT * FROM T1 WHERE T1.name NOT IN (SELECT name FROM T2)
ORDER BY T1.name;