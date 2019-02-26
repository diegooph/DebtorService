package com.debtorService.DebtorService.dao

import com.debtorService.DebtorService.entity.Debtor
import org.springframework.data.jpa.repository.JpaRepository

interface DebtorRepository :JpaRepository<Debtor , Long>