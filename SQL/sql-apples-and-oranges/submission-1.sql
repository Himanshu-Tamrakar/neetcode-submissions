SELECT sale_date,
       SUM(CASE WHEN fruit = 'apples' THEN sold_num ELSE 0 END) -
       SUM(CASE WHEN fruit = 'oranges' THEN sold_num ELSE 0 END) AS diff
FROM sales
GROUP BY sale_date
ORDER BY sale_date;

---------OR---------

SELECT a.sale_date, a.sold_num - o.sold_num AS diff
FROM sales a
JOIN sales o ON a.sale_date = o.sale_date
WHERE a.fruit = 'apple' AND o.fruit = 'orange'
ORDER BY a.sale_date;