-- Write your query below
WITH highest_salary_in_department AS(
    SELECT department_id, MAX(salary) AS max_salary
    FROM employee
    GROUP BY department_id
)

SELECT d.name AS department, e.name AS employee, e.salary
FROM employee e
JOIN department d ON e.department_id = d.id
JOIN highest_salary_in_department hs ON e.department_id = hs.department_id
WHERE e.salary = hs.max_salary;


-- OR


SELECT d.name AS department, e.name AS employee, e.salary
FROM employee e
JOIN department d ON e.department_id = d.id
WHERE e.salary = (
    SELECT MAX(e2.salary)
    FROM employee e2
    WHERE e2.department_id = e.department_id
);
