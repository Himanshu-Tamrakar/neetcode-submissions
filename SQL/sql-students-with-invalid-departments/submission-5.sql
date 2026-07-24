-- Write your query below
-- SELECT id, name
-- FROM students s
-- WHERE NOT EXISTS (
--     SELECT 1 FROM departments WHERE id = department_id
-- );


SELECT id, name
FROM students
WHERE (department_id IS NULL) 
OR department_id NOT IN (SELECT id FROM departments);