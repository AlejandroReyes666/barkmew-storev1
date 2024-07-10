package com.barkmew.store.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class Purchase {
    private int purshaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymenthMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;

}
