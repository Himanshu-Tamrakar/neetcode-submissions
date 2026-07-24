-- Write your query below
WITH recent_product_order AS(
    SELECT product_id, MAX(order_date) AS recent_order_date
    FROM orders o2
    GROUP BY o2.product_id
)

SELECT p.product_name, p.product_id, o.order_id, o.order_date
FROM orders o
JOIN products p ON o.product_id = p.product_id
JOIN recent_product_order ro ON o.product_id = ro.product_id
WHERE o.order_date = ro.recent_order_date
ORDER BY p.product_name ASC, p.product_id ASC, o.order_id ASC;

-- or

SELECT p.product_name, p.product_id, o.order_id, o.order_date
FROM orders o
JOIN products p ON o.product_id = p.product_id
WHERE o.order_date = (
    SELECT MAX(order_date)
    FROM orders o2
    WHERE o2.product_id = o.product_id
)

