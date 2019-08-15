# Write your MySQL query statement below


SELECT prs.FirstName, prs.LastName, adrs.City, adrs.State 
FROM Person prs 
left join Address adrs ON prs.PersonId = adrs.PersonId;
