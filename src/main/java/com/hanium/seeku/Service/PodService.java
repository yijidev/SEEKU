package com.hanium.seeku.Service;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PodService {

    private final KubernetesClient kubernetesClient;
    public DeploymentList getDeploymentsList() {
        return kubernetesClient.apps().deployments().list();
    }

    public PodList getPodList() {
        return kubernetesClient.pods().list();
    }
}
