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


-- OR

SELECT transaction_id
FROM (
    SELECT 
            transaction_id,
            RANK() OVER(PARTITION BY DATE(day) ORDER BY amount DESC) AS rn
    FROM transactions
) AS t
WHERE t.rn = 1
ORDER BY t.transaction_id;

-- or

WITH RankedData AS (
    SELECT transaction_id, 
           RANK() OVER(PARTITION BY DATE(day) ORDER BY amount DESC) as rn
    FROM transactions
)
SELECT transaction_id 
FROM RankedData 
WHERE rn = 1;
