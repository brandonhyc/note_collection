# Write your MySQL query statement below
SELECT a.Email AS Email
FROM Person a
GROUP BY a.Email
HAVING COUNT(a.Email) > 1;