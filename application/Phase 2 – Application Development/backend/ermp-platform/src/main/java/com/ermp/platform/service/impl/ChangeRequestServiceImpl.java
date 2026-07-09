package com.ermp.platform.service.impl;


import com.ermp.platform.entity.ChangeRequest;
import com.ermp.platform.repository.ChangeRequestRepository;
import com.ermp.platform.service.ChangeRequestService;
import org.springframework.stereotype.Service;


@Service
public class ChangeRequestServiceImpl implements ChangeRequestService {


    private final ChangeRequestRepository changeRequestRepository;


    public ChangeRequestServiceImpl(ChangeRequestRepository changeRequestRepository) {
        this.changeRequestRepository = changeRequestRepository;
    }


    @Override
    public ChangeRequest createChangeRequest(ChangeRequest changeRequest) {

        return changeRequestRepository.save(changeRequest);

    }

}