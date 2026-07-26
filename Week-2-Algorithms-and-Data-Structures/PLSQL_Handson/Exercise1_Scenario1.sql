SET SERVEROUTPUT ON;

DECLARE
    CURSOR loan_cursor IS
        SELECT c.CustomerID,
               c.Name,
               c.DOB,
               l.LoanID,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID;

    v_age NUMBER;
BEGIN
    FOR rec IN loan_cursor LOOP

        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Updated interest rate for ' || rec.Name
            );

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 1 completed.');

END;
/