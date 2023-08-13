package org.hulyam.controller;

import lombok.RequiredArgsConstructor;
import static org.hulyam.constant.EndPoints.*;

import org.hulyam.service.SalesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(API+VERSION+SALES)
public class SalesController {
    private final SalesService salesService;
}
