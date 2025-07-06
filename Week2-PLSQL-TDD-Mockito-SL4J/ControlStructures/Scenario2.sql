BEGIN
    DBMS_OUTPUT.ENABLE;
END;
/

DECLARE
    CURSOR cust_cur IS SELECT CustomerID, Balance FROM Customers;
    v_id Customers.CustomerID%TYPE;
    v_bal Customers.Balance%TYPE;
    v_found BOOLEAN := FALSE;  -- Flag to track VIP eligibility
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- VIP STATUS CHECK STARTED ---');

    OPEN cust_cur;
    LOOP
        FETCH cust_cur INTO v_id, v_bal;
        EXIT WHEN cust_cur%NOTFOUND;

        BEGIN
            IF v_bal > 10000 THEN
                v_found := TRUE;

                UPDATE Customers
                SET IsVIP = 'TRUE'
                WHERE CustomerID = v_id;

                DBMS_OUTPUT.PUT_LINE('Customer ID ' || v_id || ' marked as VIP.');
            END IF;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error updating VIP status for ID ' || v_id);
        END;
    END LOOP;
    CLOSE cust_cur;

    IF NOT v_found THEN
        DBMS_OUTPUT.PUT_LINE('No customers found with balance above 10000.');
    END IF;

    DBMS_OUTPUT.PUT_LINE('--- VIP STATUS CHECK COMPLETE ---');
END;
/
