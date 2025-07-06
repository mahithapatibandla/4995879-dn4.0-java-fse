DECLARE
    CURSOR cust_cur IS SELECT CustomerID, DOB FROM Customers;
    v_id Customers.CustomerID%TYPE;
    v_dob DATE;
    v_age NUMBER;
    v_rate NUMBER;
BEGIN
    OPEN cust_cur;
    LOOP
        FETCH cust_cur INTO v_id, v_dob;
        EXIT WHEN cust_cur%NOTFOUND;

        BEGIN
            v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, v_dob) / 12);

            IF v_age > 60 THEN
                BEGIN
                    SELECT InterestRate INTO v_rate
                    FROM Loans
                    WHERE CustomerID = v_id;

                    UPDATE Loans
                    SET InterestRate = InterestRate - 1
                    WHERE CustomerID = v_id;

                    DBMS_OUTPUT.PUT_LINE('1% discount applied to customer ID ' || v_id);
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN
                        DBMS_OUTPUT.PUT_LINE('No loan found for customer ID ' || v_id);
                END;
            END IF;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error with customer ID ' || v_id);
        END;
    END LOOP;
    CLOSE cust_cur;
END;
/
