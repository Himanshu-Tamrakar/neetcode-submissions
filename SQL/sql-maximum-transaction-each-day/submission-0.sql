-- Write your query below
WITH day_wise_max_amount AS(
    SELECT DATE(day) AS day, MAX(amount) AS max_amount
    FROM transactions
    GROUP BY DATE(day)
)

SELECT transaction_id
FROM transactions t
JOIN day_wise_max_amount mx ON DATE(t.day) = mx.day AND t.amount = mx.max_amount
ORDER BY transaction_id ASC;

