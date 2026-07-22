-- Write your query below
-- WITH all_user1_friends AS (
--     SELECT user1_id as user_id
--     FROM friendship
--     WHERE user2_id = 1
--     UNION
--     SELECT user2_id as user_id
--     FROM friendship
--     WHERE user1_id = 1
-- )

-- SELECT DISTINCT page_id AS recommended_page
-- FROM likes
-- WHERE user_id IN (
--     SELECT user_id FROM all_user1_friends
-- )
-- AND page_id NOT IN (
--     SELECT page_id FROM likes WHERE user_id = 1
-- );


SELECT DISTINCT l.page_id AS recommended_page
FROM likes l
JOIN (
    SELECT user1_id AS friend_id FROM friendship WHERE user2_id = 1
    UNION
    SELECT user2_id AS friend_id FROM friendship WHERE user1_id = 1
) AS f ON l.user_id = f.friend_id
WHERE l.page_id NOT IN (
    SELECT page_id FROM likes WHERE user_id = 1
);
