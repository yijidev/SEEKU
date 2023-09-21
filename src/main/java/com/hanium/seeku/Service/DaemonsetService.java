package com.hanium.seeku.Service;

import io.fabric8.kubernetes.api.model.apps.DaemonSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DaemonsetService {

    private final KubernetesClient kubernetesClient;
    public DaemonSetList getDemonList() {
        return kubernetesClient.apps().daemonSets().list();
    }
}
