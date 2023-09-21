package com.hanium.seeku.Service;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplicasetService {

    private final KubernetesClient kubernetesClient;

    public ReplicaSetList getReplicaList() {
        return kubernetesClient.apps().replicaSets().list();
    }
}
