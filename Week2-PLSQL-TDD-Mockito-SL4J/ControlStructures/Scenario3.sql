BEGIN
    DBMS_OUTPUT.ENABLE;
END;
/

DECLARE
    CURSOR loan_cur IS SELECT LoanID, CustomerID, EndDate FROM Loans;
    v_loan_id Loans.LoanID%TYPE;
    v_cust_id Loans.CustomerID%TYPE;
    v_due_date DATE;
    v_found BOOLEAN := FALSE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- CHECKING LOANS DUE IN NEXT 30 DAYS ---');

    OPEN loan_cur;
    LOOP
        FETCH loan_cur INTO v_loan_id, v_cust_id, v_due_date;
        EXIT WHEN loan_cur%NOTFOUND;

        BEGIN
            IF v_due_date BETWEEN SYSDATE AND SYSDATE + 30 THEN
                v_found := TRUE;

                DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || v_loan_id ||
                                     ' for Customer ' || v_cust_id ||
                                     ' is due on ' || TO_CHAR(v_due_date, 'DD-Mon-YYYY'));
            END IF;
        EXCEPTION
            WHEN OTHERS THEN
                DBMS_OUTPUT.PUT_LINE('Error with loan ID ' || v_loan_id);
        END;
    END LOOP;
    CLOSE loan_cur;

    IF NOT v_found THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    END IF;

    DBMS_OUTPUT.PUT_LINE('--- LOAN CHECK COMPLETE ---');
END;
/
