package com.chanchal.futurestradeservice.bo;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "tbl_application_error", schema = "futures")
@Builder
public class ApplicationErrorBO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String source;
    private String messageType;
    @Column(columnDefinition="text")
    private String message;
    @Column(columnDefinition="text")
    private String error;
}
