WITH 
total AS (
    SELECT COUNT(*) AS cnt FROM delivery
),
immediate AS (
    SELECT COUNT(*) AS cnt FROM delivery
    WHERE order_date = customer_pref_delivery_date
)
SELECT ROUND(
    100.0 * (SELECT cnt FROM immediate) / (SELECT cnt FROM total),
    2
) AS immediate_percentage;