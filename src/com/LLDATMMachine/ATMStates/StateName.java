package com.LLDATMMachine.ATMStates;

public enum StateName {
    IDLE,
    HAS_CARD,
    SELECT_OPERATION,
    CHECK_BALANCE,
    CASH_WITHDRAWAL
}
