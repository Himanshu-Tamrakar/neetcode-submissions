-- -- Write your query below
WITH all_dates AS (
    SELECT fail_date AS event_date, false AS state
    FROM failed WHERE fail_date BETWEEN '2019-01-01' AND '2019-12-31'
    UNION ALL
    SELECT success_date AS event_date, true AS state
    FROM succeeded WHERE success_date BETWEEN '2019-01-01' AND '2019-12-31'
),
ranked AS (
    SELECT *,
        ROW_NUMBER() OVER (ORDER BY event_date) AS rn,
        ROW_NUMBER() OVER (PARTITION BY state ORDER BY event_date) AS state_rn
    FROM all_dates
),
grouped AS (
    SELECT *,
        rn - state_rn AS grp
    FROM ranked
)

SELECT 
    CASE WHEN state = true THEN 'succeeded' ELSE 'failed' END AS period_state,
    MIN(event_date) AS start_date,
    MAX(event_date) AS end_date
FROM grouped
GROUP BY state, grp
ORDER BY start_date;