package com.hanium.seeku.Service;

import com.hanium.seeku.Model.PodUsage;
import com.hanium.seeku.Repository.PodUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsageService {
    private final PodUsageRepository podUsageRepository;
    public void savePodUsageForm(PodUsage podUsage){
        podUsageRepository.save(podUsage);
    }
}
