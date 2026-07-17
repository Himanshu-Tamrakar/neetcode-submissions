SELECT c.customer_id, c.customer_name
FROM customers c
WHERE EXISTS (
    SELECT 1 FROM orders o
    WHERE o.customer_id = c.customer_id AND o.product_name = 'A'
)
AND EXISTS (
    SELECT 1 FROM orders o
    WHERE o.customer_id = c.customer_id AND o.product_name = 'B'
)
AND NOT EXISTS (
    SELECT 1 FROM orders o
    WHERE o.customer_id = c.customer_id AND o.product_name = 'C'
)
ORDER BY c.customer_name;


-- SELECT c.customer_id, c.customer_name
-- FROM customers c
-- WHERE c.customer_id IN (
--     SELECT customer_id
--     FROM orders
--     WHERE product_name = 'A'
-- )
-- AND c.customer_id IN (
--     SELECT customer_id
--     FROM orders
--     WHERE product_name = 'B'
-- )
-- AND c.customer_id NOT IN (
--     SELECT customer_id
--     FROM orders
--     WHERE product_name = 'C'
-- )
-- ORDER BY c.customer_name ASC;