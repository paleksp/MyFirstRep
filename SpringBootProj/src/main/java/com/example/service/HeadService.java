package com.example.service;

import com.example.model.NVHead;
import com.example.model.NVCumDue;
import com.example.repository.NVHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class HeadService {
    private final NVHeadRepository headRepository;

    @Autowired
    public HeadService(NVHeadRepository headRepository) {
        this.headRepository = headRepository;
    }

    public NVHead getHead(String descr) {
        NVHead nvHead = headRepository.findNVHeadByDescription(descr);
        nvHead.setDescription("New description!");
        headRepository.save(nvHead);

        return headRepository.findNVHeadByDescription(descr);
    }

    public NVHead findByCumId(Integer cumId) {
        return headRepository.findNVHeadByCumId(cumId);
    }

    @Transactional
    public NVHead addNewEntry() {

        NVHead nvHead = new NVHead();
        nvHead.setDescription("Test new entry1");

        NVCumDue nvCumDue = new NVCumDue(5, "This my test123!!");
        nvHead.setCumDueList(new ArrayList<>(Collections.singletonList(nvCumDue)));

        headRepository.save(nvHead);
        return nvHead;
    }

}
