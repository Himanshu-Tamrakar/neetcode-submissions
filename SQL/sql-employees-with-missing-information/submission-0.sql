-- Write your query below
SELECT COALESCE(e.employee_id, s.employee_id) AS employee_id
FROM employees e
FULL JOIN salaries s ON s.employee_id = e.employee_id
WHERE e.name IS NULL OR s.salary IS NULL
ORDER BY employee_id ASC;