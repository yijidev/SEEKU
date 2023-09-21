package com.hanium.seeku.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@Entity
@Table(name="pod_usage")
public class PodUsage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pod_usage_seq")
    @SequenceGenerator(name = "pod_usage_seq", sequenceName = "pod_usage_seq", allocationSize = 1)
    @Column
    private long podUsageId;

    @Column
    private double cpuUsage;

    @Column
    private double memoryUsage;

    @Column
    private double processCpuUsage;

    @Column
    private double networkUsage;

    @Column
    private String name;
}
