-- Write your query below
-- nlog(n)
-- SELECT MIN(p2.x - p1.x) AS shortest
-- FROM point p1
-- JOIN point p2 On p1.x < p2.x;


-- o(n) compares
SELECT MIN(next_x - x) AS shortest
FROM (
        SELECT x, LEAD(x) OVER (ORDER BY x) AS next_x
        FROM point
) t
WHERE next_x IS NOT NULL;
