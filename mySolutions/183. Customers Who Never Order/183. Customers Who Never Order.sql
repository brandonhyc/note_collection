# Write your MySQL query statement below
SELECT a.NAME AS Customers
FROM Customers AS a
LEFT JOIN Orders AS b
ON a.Id = b.CustomerId
WHERE b.Id is NULL;
