WITH product_counts AS (
    SELECT
        o.customer_id,
        o.product_id,
        p.product_name,
        -- Calculate rank based on the frequency of each product
        RANK() OVER (
            PARTITION BY o.customer_id 
            ORDER BY COUNT(*) DESC
        ) AS rnk
    FROM orders o
    JOIN products p ON o.product_id = p.product_id
    JOIN customers c ON o.customer_id = c.customer_id
    GROUP BY o.customer_id, o.product_id, p.product_name
)
SELECT 
    customer_id, 
    product_id, 
    product_name
FROM product_counts
WHERE rnk = 1;