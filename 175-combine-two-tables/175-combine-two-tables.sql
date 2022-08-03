# Write your MySQL query statement below
SELECT p1.lastName, p1.firstName, a1.city, a1.state 
FROM Person p1 left join Address a1
ON p1.personId = a1.personId;