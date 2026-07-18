-- Write your query below

-- WITH crimson_com AS (
--     SELECT com_id
--     FROM company
--     WHERE name = 'CRIMSON'
-- )

-- SELECT s.name
-- FROM sales_person s
-- WHERE NOT EXISTS (
--     SELECT 1
--     FROM orders o
--     JOIN crimson_com ON o.com_id = crimson_com.com_id
--     WHERE o.sales_id = s.sales_id
-- );

SELECT sp.name
FROM sales_person sp
WHERE sp.sales_id NOT IN (
    SELECT o.sales_id
    FROM orders o
    JOIN company c ON c.com_id = o.com_id
    WHERE c.name = 'CRIMSON'
);

