CREATE DATABASE IF NOT EXISTS myDB;
DROP TABLE IF EXISTS myDB.Data;
CREATE TABLE IF NOT EXISTS myDB.Data (
    PersonID int NOT NULL AUTO_INCREMENT,
    FirstName varchar(255),
    LastName varchar(255),
    YearData int,
    MonthData int,
    DayData int,
    PRIMARY KEY (PersonID)
);
-- Reikia padryti intid. paversti visus datas i skaicius.
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Jonas",
        "Petukauskas",
        2003,
        06,
        24
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Karinutė",
        "Zbitka",
        2003,
        11,
        25
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Egle",
        "Petukauskaitė",
        2005,
        06,
        15
    );
-- ---------------------
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Simona",
        "Lukaševičiūtė",
        2004,
        07,
        5
    );
-- ---------------------
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Grigory",
        "Shilov",
        2003,
        03,
        19
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Ūla",
        "Vazgytė",
        2005,
        08,
        3
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Domas",
        NULL,
        NULL,
        NULL,
        NULL
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Giedrius",
        "Vazgytė",
        NULL,
        NULL,
        NULL
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Ūlos sesė",
        "Vazgytė",
        NULL,
        NULL,
        NULL
    );
-- ---------------------
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Tomas",
        "Stankūnas",
        Null,
        06,
        06
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Greta",
        "Stankūnaitė",
        1998,
        7,
        18
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Ausra",
        "Stankūnienė",
        Null,
        06,
        06
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Justinas",
        "Stankūnas",
        2003,
        06,
        06
    );
INSERT INTO myDB.Data(
        FirstName,
        LastName,
        YearData,
        MonthData,
        DayData
    ) value (
        "Lara",
        "Stankūnaitė",
        NULL,
        NULL,
        NULL
    );
-- ---------------------