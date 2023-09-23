package com.hanium.seeku.Model;

import lombok.Data;

import java.util.Map;
@Data
public class NodeData {
    private String name;
    private Map<String, String> labels;
    private Boolean ready;
    private Double cpuCapacity;
    private String memoryCapacity;
    private String creationTime;
}
