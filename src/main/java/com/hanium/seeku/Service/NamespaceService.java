package com.hanium.seeku.Service;

import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NamespaceService {

    private final KubernetesClient kubernetesClient;
    public int getNamespaceList() {
        return kubernetesClient.namespaces().list().getItems().size();
    }
}
