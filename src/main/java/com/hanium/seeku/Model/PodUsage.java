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
    @Column
    private long usedBookId;

    @Column
    private long cpuUsage;

    @Column
    private long memoryUsage;

    @Column
    private long processCpuUsage;

    @Column
    private long networkUsage;

    @Column
    private String name;
}
