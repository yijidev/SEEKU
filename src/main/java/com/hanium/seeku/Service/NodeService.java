package com.hanium.seeku.Service;
import com.hanium.seeku.Model.NodeData;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeCondition;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NodeService {

    private final KubernetesClient kubernetesClient;
    private final DateUtils dateUtils;
    public DeploymentList getDeploymentsList() {
        return kubernetesClient.apps().deployments().list();
    }
    public List<NodeData> getNodList() {
        List<NodeData> nodeDataList = new ArrayList<>();
        for (Node node : kubernetesClient.nodes().list().getItems()) {
            NodeData nodeData = new NodeData();

            nodeData.setName(node.getMetadata().getName());

            nodeData.setLabels(node.getMetadata().getLabels());

            for (NodeCondition condition : node.getStatus().getConditions()) {
                if ("Ready".equals(condition.getType())) {
                    nodeData.setReady("True".equals(condition.getStatus()));
                    break;
                }
            }

            Map<String, Quantity> allocatableResources = node.getStatus().getAllocatable();

            Quantity cpuQuantity = allocatableResources.get("cpu");

            System.out.println("cpuQuantity = " + cpuQuantity);cpuQuantity.toString();
            if (cpuQuantity != null) {
                nodeData.setCpuCapacity(Double.parseDouble(cpuQuantity.getAmount()));
            }
            //메모리 양 보여주는 것에 문제가 있는거같은데 나중에 수정
            Quantity memoryQuantity = allocatableResources.get("memory");
            if (memoryQuantity != null) {
                nodeData.setMemoryCapacity(memoryQuantity.getAmount());
            }

            nodeData.setCreationTime(dateUtils.formatDuration(node.getMetadata().getCreationTimestamp()));

            nodeDataList.add(nodeData);
        }
        return nodeDataList;
    }
}
