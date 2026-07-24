-- Write your query below
SELECT DISTINCT a.account_id
FROM log_info a
JOIN log_info b 
ON a.account_id = b.account_id 
AND a.ip_address <> b.ip_address
WHERE a.login <= b.logout 
AND b.login <= a.logout;
