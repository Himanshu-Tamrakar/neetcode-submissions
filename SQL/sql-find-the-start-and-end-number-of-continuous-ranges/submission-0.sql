-- Write your query below
WITH grouping_on_sequence AS(
    SELECT 
        log_id,
        log_id - ROW_NUMBER() OVER(ORDER BY log_id) AS grn
    FROM logs
)
-- log_id - ROW_NUMBER()
-- 1 - 1 = 0
-- 2 - 2 = 0
-- 3 - 3 = 0

-- 5 - 4 = 1
-- 6 - 5 = 1

-- 8 - 6 = 2
-- 9 - 7 = 2


-- 11 - 8 = 3

SELECT MIN(log_id) AS start_id, MAX(log_id) AS end_id
FROM grouping_on_sequence
GROUP BY grn
ORDER BY start_id;


