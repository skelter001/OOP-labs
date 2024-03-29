package model.transaction;

import lombok.Builder;
import lombok.Getter;
import model.account.Account;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Transaction implements AbstractTransaction {
    private final UUID transferId;
    private final LocalDateTime transDate;
    protected final Account fromAcc;
    protected final Account toAcc;
    protected final double moneyAmount;

    @Builder
    public Transaction(Account fromAcc, Account toAcc, double moneyAmount) {
        this.transDate = LocalDateTime.now();
        this.moneyAmount = moneyAmount;
        this.transferId = UUID.randomUUID();
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
    }

    @Override
    public void cancelTopUpTransaction() {
        toAcc.UndoTransaction(-moneyAmount);
    }

    @Override
    public void cancelWithdrawingTransaction() {
        fromAcc.UndoTransaction(moneyAmount);
    }
}
