-- Write your query below


WITH numbers AS(
    SELECT 1 AS n
    UNION ALL
    SELECT 2
    UNION ALL
    SELECT 3
    UNION ALL
    SELECT 4
    UNION ALL
    SELECT 5
    UNION ALL
    SELECT 6
    UNION ALL
    SELECT 7
    UNION ALL
    SELECT 8
    UNION ALL
    SELECT 9
    UNION ALL
    SELECT 10
    UNION ALL
    SELECT 11
    UNION ALL
    SELECT 12
    UNION ALL
    SELECT 13
    UNION ALL
    SELECT 14
    UNION ALL
    SELECT 15
    UNION ALL
    SELECT 16
    UNION ALL
    SELECT 17
    UNION ALL
    SELECT 18
    UNION ALL
    SELECT 19
    UNION ALL
    SELECT 20
)


SELECT t.task_id, n.n AS subtask_id
FROM tasks t
CROSS JOIN numbers n
LEFT JOIN executed exe ON exe.task_id = t.task_id AND exe.subtask_id = n.n
WHERE n.n <= t.subtasks_count AND exe.subtask_id IS NULL
ORDER BY t.task_id, subtask_id;

--  1 | 3 | 1 | 
--  1 | 3 | 2 | 1 | 2
--  1 | 3 | 3
 
 
--  2 | 2 | 1
--  2 | 2 | 2

--  3 | 4 | 1 | 3 | 1
--  3 | 4 | 2 | 3 | 2
--  3 | 4 | 3 | 3 | 3
--  3 | 4 | 4 | 4 | 4
--  3 | 4 | 5 | null | null
