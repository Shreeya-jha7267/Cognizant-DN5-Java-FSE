SET SERVEROUTPUT ON;

BEGIN

    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE Balance > 10000;

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' customer(s) marked as VIP.');

    COMMIT;

END;
/