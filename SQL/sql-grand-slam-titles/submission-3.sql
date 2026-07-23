-- WITH unvipited AS (
--     SELECT wimbledon AS player_id FROM championships
--     UNION ALL
--     SELECT fr_open AS player_id FROM championships
--     UNION ALL
--     SELECT us_open AS player_id FROM championships
--     UNION ALL
--     SELECT au_open AS player_id FROM championships
-- )

-- SELECT  p.player_id, 
--         p.player_name, 
--         COUNT(*) AS grand_slams_count
-- FROM unvipited u
-- JOIN players p ON u.player_id = p.player_id
-- GROUP BY p.player_id, p.player_name;


SELECT  p.player_id, 
        p.player_name, 
        COUNT(*) AS grand_slams_count
FROM players p
JOIN  (
    SELECT wimbledon AS player_id FROM championships
    UNION ALL
    SELECT fr_open AS player_id FROM championships
    UNION ALL
    SELECT us_open AS player_id FROM championships
    UNION ALL
    SELECT au_open AS player_id FROM championships
) AS winners ON winners.player_id = p.player_id
GROUP BY p.player_id, player_name;

-- year | slam    |  player_id
-- 2016 |wimbledon|1 
-- 2016 |fr_open  |1
-- 2016 |us_open  |1
-- 2016 |au_open  |1
-- 2017 |wimbledon|1 
-- 2017 |fr_open  |1
-- 2017 |us_open  |2
-- 2017 |au_open  |2
-- 2018 |wimbledon|2
-- 2018 |fr_open  |1
-- 2018 |us_open  |2
-- 2018 |au_open  |2



