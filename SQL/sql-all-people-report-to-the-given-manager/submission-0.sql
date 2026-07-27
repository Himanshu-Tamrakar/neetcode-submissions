WITH direct_manager AS (
    SELECT employee_id
    FROM employees
    WHERE manager_id = 1 AND employee_id != 1
),
direct_manager_2 AS (
    SELECT employee_id
    FROM employees
    WHERE manager_id IN (SELECT employee_id FROM direct_manager)
),
direct_manager_3 AS (
    SELECT employee_id
    FROM employees
    WHERE manager_id IN (SELECT employee_id FROM direct_manager_2)
)
SELECT employee_id FROM direct_manager
UNION
SELECT employee_id FROM direct_manager_2
UNION
SELECT employee_id FROM direct_manager_3
ORDER BY employee_id;