select subject from marks
where subject in
(
select subject from marks
where fio in 
(select fio from marks
where mark in ('5')
group by fio
having count(mark) >= 10)

except

select subject from marks
where fio not in (select fio from marks
where mark in ('5')
group by fio
having count(mark) >= 10)
)
group by subject
order by count(case when mark='2' then 1 end) desc