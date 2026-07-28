-- SELECT c.name AS country
-- FROM person p
-- JOIN country c ON SUBSTRING(p.phone_number, 1, 3) = c.country_code
-- JOIN calls ca ON ca.caller_id = p.id OR ca.callee_id = p.id
-- GROUP BY c.name
-- HAVING AVG(ca.duration) > (SELECT AVG(duration) FROM calls);

-- OR

SELECT 
    CASE
        WHEN AVG(ca.duration) > (SELECT AVG(duration) FROM calls)
        THEN c.name
    END AS country
FROM person p
JOIN country c ON SUBSTRING(p.phone_number, 1, 3) = c.country_code
JOIN calls ca ON ca.caller_id = p.id OR ca.callee_id = p.id
GROUP BY c.name
HAVING AVG(ca.duration) > (SELECT AVG(duration) FROM calls);

-- Where will run before group by
-- having runs after group by