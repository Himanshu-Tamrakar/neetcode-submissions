-- Write your query below
SELECT e.event_day AS day, e.emp_id, SUM(e.out_time - e.in_time) AS total_time
FROM employees e
GROUP BY emp_id, event_day
ORDER BY e.event_day;