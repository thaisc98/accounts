package bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Account Number of Bank account", example="3454431122"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType not be null or empty")
    @Schema(
            description = "Account Type of Bank account", example = "Savings"
    )
    private String accountType;


    @NotEmpty(message = "BranchAddress can not be null or empty")
    @Schema(
            description = "Bank branch address", example = "100 New York City"
    )
    private String branchAddress;
}
