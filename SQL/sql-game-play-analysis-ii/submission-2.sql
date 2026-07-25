-- Write your query below
SELECT player_id, device_id
FROM (
    SELECT player_id, device_id,
    ROW_NUMBER() OVER(PARTITION BY player_id ORDER BY event_date) AS rnk
    FROM activity
) t
WHERE rnk = 1;




-- SELECT player_id, device_id
-- FROM activity 
-- WHERE (player_id, event_date) IN (
--     SELECT player_id, MIN(event_date)
--     FROM activity
--     GROUP BY player_id
-- );