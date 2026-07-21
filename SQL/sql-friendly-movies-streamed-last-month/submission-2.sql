-- Write your query below
SELECT DISTINCT c.title
FROM tv_program tv
JOIN content c ON c.content_id = tv.content_id
WHERE tv.program_date LIKE '2020-06-%' 
    AND c.kids_content = 'Y' 
    AND c.content_type = 'Movies';