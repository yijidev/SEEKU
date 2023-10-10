package com.hanium.seeku.Controller.dashboard.cluster;

import com.hanium.seeku.Model.NamespaceData;
import com.hanium.seeku.Model.NodeData;
import com.hanium.seeku.Service.NamespaceService;
import com.hanium.seeku.Service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("dashboard/cluster/nodes")
@Controller
public class NodesController {
    private final NodeService nodeService;

    @GetMapping
    public String Nodes(Model model){
        List<NodeData> nodList = nodeService.getNodList();
        model.addAttribute("nodeList", nodList);
        // 노드 상세 페이지는 나중에 구현
        return "dashboard/cluster/Nodes";
    }

}
