-- Write your query below
WITH ordering AS(
    SELECT 
        user_id,
        visit_date,
        RANK() OVER(PARTITION BY user_id ORDER BY visit_Date) AS rnk
    FROM user_visits
    GROUP BY user_id, visit_date
)


SELECT 
    o1.user_id,
    MAX(COALESCE(o2.visit_date, '2021-01-01':: DATE) - o1.visit_date) AS biggest_window
FROM ordering o1
LEFT JOIN ordering o2 ON o1.user_id = o2.user_id AND o1.rnk + 1 = o2.rnk
GROUP BY o1.user_id
ORDER BY o1.user_id;



-- 1	2020-11-28

-- 1	2020-10-20

-- 1	2020-12-3

-- 2	2020-10-5

-- 2	2020-12-9

-- 3	2020-11-11


-- 1	2020-10-20 - 1

-- 1	2020-11-28 - 2

-- 1	2020-12-3 - 3

-- 2	2020-10-5 - 1

-- 2	2020-12-9 - 2

-- 3	2020-11-11 - 1
-- 