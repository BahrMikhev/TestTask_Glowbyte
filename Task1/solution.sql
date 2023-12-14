select id+1 as missed_ids
from (
SELECT id, LEAD(id)OVER(ORDER BY Id) as next_id
  FROM SampleTest
)
where (id+1 <> next_id)
and (id+2 = next_id)