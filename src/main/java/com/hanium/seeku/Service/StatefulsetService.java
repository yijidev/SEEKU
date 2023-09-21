package com.hanium.seeku.Service;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatefulsetService {

    private final KubernetesClient kubernetesClient;

    public StatefulSetList getStatefulList() {
        return kubernetesClient.apps().statefulSets().list();
    }
}
