SET @MonthDataVar = 06,
    @DayDataVar = 15;

select *
from myDB.Data
WHERE YearData != ''
    and MonthData != ''
    and MonthData*30 + DayData >= @MonthDataVar*30 + @DayDataVar
ORDER BY MonthData ASC, DayData ASC
Limit 1;