package com.hanium.seeku.Repository;

import com.hanium.seeku.Model.PodUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodUsageRepository extends JpaRepository<PodUsage, Long> {
}
