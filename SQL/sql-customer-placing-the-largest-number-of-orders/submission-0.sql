-- Write your query below
-- SELECT customer_number, COUNT(*) AS total
-- FROM orders
-- GROUP BY customer_number
-- ORDER BY total DESC
-- LIMIT 1;


SELECT customer_number
FROM orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;