package com.yinqifang.mushroom.server.service.impl;

import com.yinqifang.mushroom.server.service.VersionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author Chris Yin
 * @date 2021-08-07
 */
@Service
@Configuration
public class VersionServiceImpl implements VersionService {

    @Value("${version.latest}")
    private String latestVersion;

    @Override
    public String getLatest() {
        return latestVersion;
    }
}
