-- Write your query below
-- id 0
-- p_id null

-- id 1
-- p_id 0


-- id 2
-- p_id 0

-- 0 -> 1
--   -> 2


SELECT t1.id, 
        CASE
            WHEN t1.p_id IS NULL THEN 'Root'
            WHEN EXISTS (SELECT 1 FROM tree t2 WHERE t2.p_id = t1.id) THEN 'Inner'
            ELSE 'Leaf'
        END AS type
FROM tree t1;

