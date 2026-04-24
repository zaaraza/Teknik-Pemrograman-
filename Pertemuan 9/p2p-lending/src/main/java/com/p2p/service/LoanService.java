package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    private static final int CREDIT_SCORE_THRESHOLD = 600;  // Refactor: Ekstrak threshold ke konstanta

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        // =========================
        // VALIDASI UTAMA (TC-01)
        // =========================
        // Jika borrower belum terverifikasi,
        // maka proses harus dihentikan
        logger.info("=== Memulai proses createLoan ===");
        logger.debug("verified={}, score={}, amount={}", 
            borrower.isVerified(), borrower.getCreditScore(), amount);

        validateBorrower(borrower);
        validateAmount(amount);

        Loan loan = new Loan();
        if (borrower.getCreditScore() >= CREDIT_SCORE_THRESHOLD) {
            loan.approve();
            logger.info("Loan APPROVED. score={}", borrower.getCreditScore());
        } else {
            loan.reject();
            logger.info("Loan REJECTED. score={}", borrower.getCreditScore());
        }

        logger.info("Status akhir: {}", loan.getStatus());
        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        logger.debug("Validasi KYC borrower...");
        if (!borrower.canApplyLoan()) {
            logger.warn("Borrower tidak terverifikasi!");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        logger.debug("Validasi amount: {}", amount);
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.warn("Amount tidak valid: {}", amount);
            throw new IllegalArgumentException("Loan amount must be greater than 0");
        }
    }
}