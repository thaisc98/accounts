package bank.accounts.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class Loans {

    private int loanNumber;
    private int customerId;
    private Date startDt;
    private String loanType;
    private String createDt;

}
