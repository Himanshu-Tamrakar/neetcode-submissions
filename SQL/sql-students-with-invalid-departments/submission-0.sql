-- Write your query below
SELECT id, name
FROM students s
WHERE NOT EXISTS (
    SELECT 1 FROM departments WHERE id = department_id
);