package com.it235.seata.storage.service.impl;

import com.it235.seata.storage.mapper.StorageMapper;
import com.it235.seata.storage.model.Storage;
import com.it235.seata.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jianjun.ren
 * @since 2021/02/16
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    @Transactional
    public boolean updateUseNum(long productId , long used) {
//        int a = 100/0;
        int index = storageMapper.updateUsed(productId, used);
        return index > 0;
    }
}
