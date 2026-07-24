-- Write your query below
-- WITH team AS(
--     SELECT team_id, COUNT(*) AS team_size
--     FROM employee
--     GROUP BY team_id
-- )

-- SELECT e.employee_id, ts.team_size
-- FROM employee e
-- JOIN team ts ON e.team_id = ts.team_id;



-- SELECT e.employee_id, ts.team_size
-- FROM employee e
-- JOIN (
--     SELECT team_id, COUNT(*) AS team_size
--     FROM employee
--     GROUP BY team_id
-- ) AS ts
-- ON e.team_id = ts.team_id;

-- team_id | team_size
-- 8       | 3
-- 7       | 1
-- 9       | 2



SELECT e.employee_id, COUNT(*) OVER (PARTITION BY e.team_id) AS team_size
FROM employee e;
