-- Write your query below
WITH exam_min_max_score AS(
    SELECT exam_id, 
            MIN(score) AS min_score, 
            MAX(score) AS max_score
    FROM exam 
    GROUP BY exam_id
),
loud_students AS(
    SELECT DISTINCT e.student_id
    FROM exam e
    JOIN exam_min_max_score emn 
    ON e.exam_id = emn.exam_id 
    AND (e.score = emn.min_score OR e.score = emn.max_score)
)

SELECT DISTINCT s.student_id, s.student_name
FROM student s
JOIN exam e ON e.student_id = s.student_id
WHERE s.student_id NOT IN (SELECT student_id FROM loud_students)
ORDER BY s.student_id;

-- exam_id min max
-- 10      70   90
-- 20      80   80
-- 30      70   90
-- 40      60   80
