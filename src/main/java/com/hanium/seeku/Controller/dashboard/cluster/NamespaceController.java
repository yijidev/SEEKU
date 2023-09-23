package com.hanium.seeku.Controller.dashboard.cluster;

import com.hanium.seeku.Model.NamespaceData;
import com.hanium.seeku.Service.NamespaceService;
import io.fabric8.kubernetes.api.model.Namespace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("dashboard/cluster/namespace")
@RequiredArgsConstructor
public class NamespaceController {
    private final NamespaceService namespaceService;
    @GetMapping
    public String Namespace(Model model){
        List<NamespaceData> namespaceList = namespaceService.getNamespaceList();
        model.addAttribute("namespaceList", namespaceList);

        return "dashboard/cluster/Namespace";
    }

}
