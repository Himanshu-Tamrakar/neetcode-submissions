-- Write your query below
WITH experience_ordering AS(
    SELECT 
        p.project_id, 
        p.employee_id, 
        e.name, 
        e.experience_years,
        RANK() OVER(PARTITION BY p.project_id ORDER BY e.experience_years DESC) AS rn
    FROM project p
    JOIN employee e ON p.employee_id = e.employee_id
)

SELECT project_id, employee_id
FROM experience_ordering
WHERE rn = 1;