package com.p2p;

import com.p2p.domain.*;
import com.p2p.service.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        logger.info("=== TC-01: shouldRejectLoanWhenBorrowerNotVerified ===");
        //=====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        //=====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);
        logger.debug("[TC-01] Arrange: borrower dibuat, verified=false, creditScore=700");

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);
        logger.debug("[TC-01] Arrange: amount={}", amount);

        // =========================
        // Act (Action)
        // =========================
        // Borrower mencoba mengajukan loan
        logger.debug("[TC-01] Act: memanggil createLoan dengan borrower tidak terverifikasi...");
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });

        logger.info("[TC-01] PASSED ✓");
        logger.info("==============================");
    }

    @Test // TEST CASE 2
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        logger.info("=== TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative ===");
        // SKENARIO:
        // Borrower terverifikasi
        // Ketika borrower mengajukan pinjaman dengan nilai 0 atau negatif
        // Sistem harus menolak dan melempar exception

        // =========================
        // Arrange
        // =========================
        // Borrower sudah lolos KYC
        Borrower borrower = new Borrower(true, 700);
        logger.debug("[TC-02] Arrange: borrower dibuat, verified=true, creditScore=700");

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman tidak valid (0 atau negatif)
        BigDecimal invalidAmount = BigDecimal.ZERO;
        logger.debug("[TC-02] Arrange: invalidAmount={}", invalidAmount);

        // =========================
        // Act + Assert (expect exception)
        // =========================
        // Ketika borrower mencoba mengajukan loan dengan jumlah tidak valid
        logger.debug("[TC-02] Act: memanggil createLoan dengan amount=0...");
        assertThrows(IllegalArgumentException.class,
            () -> loanService.createLoan(borrower, invalidAmount));

        logger.info("[TC-02] PASSED ✓");
        logger.info("==============================");
    }

    @Test // TEST CASE 3
    void shouldApproveLoanWhenCreditScoreHigh() {
        logger.info("=== TC-03: shouldApproveLoanWhenCreditScoreHigh ===");
        // SKENARIO:
        // Borrower terverifikasi dengan credit score >= 600
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menyetujui pinjaman tersebut karena memenuhi kriteria

        // =========================
        // Arrange
        // =========================
        // Borrower sudah lolos KYC dengan credit score tinggi
        Borrower borrower = new Borrower(true, 700); // score >= 600
        logger.debug("[TC-03] Arrange: borrower dibuat, verified=true, creditScore=700");

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(5000);
        logger.debug("[TC-03] Arrange: amount={}", amount);

        // =========================
        // Act
        // =========================
        // Borrower mencoba mengajukan loan
        logger.debug("[TC-03] Act: memanggil createLoan...");
        Loan loan = loanService.createLoan(borrower, amount);
        logger.info("[TC-03] Act: loan berhasil dibuat, status={}", loan.getStatus());

        // =========================
        // Assert
        // =========================
        // Sistem harus menyetujui pinjaman karena credit score memenuhi kriteria
        assertEquals(Loan.Status.APPROVED, loan.getStatus());

        logger.info("[TC-03] PASSED ✓");
        logger.info("==============================");
    }

    @Test // TEST CASE 4
    void shouldRejectLoanWhenCreditScoreLow() {
        logger.info("=== TC-04: shouldRejectLoanWhenCreditScoreLow ===");
        // SKENARIO:
        // Borrower terverifikasi KYC dengan credit score < 600
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak pinjaman tersebut karena credit score tidak memenuhi kriteria

        // =========================
        // Arrange
        // =========================
        // Borrower sudah lolos KYC dengan credit score rendah
        Borrower borrower = new Borrower(true, 450); // score < 600
        logger.debug("[TC-04] Arrange: borrower dibuat, verified=true, creditScore=450");

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(3000);
        logger.debug("[TC-04] Arrange: amount={}", amount);

        // =========================
        // Act
        // =========================
        // Borrower mencoba mengajukan loan
        logger.debug("[TC-04] Act: memanggil createLoan...");
        Loan loan = loanService.createLoan(borrower, amount);
        logger.info("[TC-04] Act: loan berhasil dibuat, status={}", loan.getStatus());

        // =========================
        // Assert
        // =========================
        // Sistem harus menolak pinjaman karena credit score tidak memenuhi kriteria
        assertEquals(Loan.Status.REJECTED, loan.getStatus());

        logger.info("[TC-04] PASSED ✓");
        logger.info("==============================");
    }
}