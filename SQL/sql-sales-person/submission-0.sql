-- Write your query below
-- 1 - Himanshu - 500000 - 20% - 2020


-- 10 - Sales Force - Gurugram
-- 11 - CRIMSON - Hyderabas

-- 100 - 2021 - 10 - 1 - 1000000

-- order_id	order_date	com_id	sales_id	amount com_id	name	city
-- 1	        2021-01-10	  3	      4	          15000  3     EMERALD   Chicago

WITH crimson_com AS (
    SELECT com_id
    FROM company
    WHERE name = 'CRIMSON'
)

SELECT s.name
FROM sales_person s
WHERE NOT EXISTS (
    SELECT 1
    FROM orders o
    JOIN crimson_com ON o.com_id = crimson_com.com_id
    WHERE o.sales_id = s.sales_id
);

