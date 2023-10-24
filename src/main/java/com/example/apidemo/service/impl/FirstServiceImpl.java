package com.example.apidemo.service.impl;

import com.example.apidemo.service.FirstService;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class FirstServiceImpl implements FirstService {
    @Override
    public Map<String, Object> getFirstData() {
        Map<String, Object> firstData = new HashMap<>();
        firstData.put("key1","value1");
        firstData.put("key2","value2");
        firstData.put("key3","value3");

        return firstData;
    }
}
