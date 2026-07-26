SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_count NUMBER := 0;
BEGIN
    FOR rec IN loan_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ' || rec.LoanID ||
            ' for ' || rec.Name ||
            ' is due on ' || TO_CHAR(rec.EndDate,'DD-MON-YYYY')
        );

        v_count := v_count + 1;
    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due within the next 30 days.');
    END IF;
END;
/