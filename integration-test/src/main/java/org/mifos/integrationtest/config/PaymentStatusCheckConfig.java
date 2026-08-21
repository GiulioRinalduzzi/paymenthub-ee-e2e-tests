package org.mifos.integrationtest.config;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PaymentStatusCheckConfig {

    public List<String> requestIds = new ArrayList<>();

    @PostConstruct
    public void setup() {

    }
}
