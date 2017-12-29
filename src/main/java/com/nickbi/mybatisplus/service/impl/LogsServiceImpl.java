package com.nickbi.mybatisplus.service.impl;

import com.nickbi.mybatisplus.model.Logs;
import com.nickbi.mybatisplus.dao.LogsMapper;
import com.nickbi.mybatisplus.service.ILogsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请求操作日志表 服务实现类
 * </p>
 *
 * @author nickBi
 * @since 2017-12-29
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements ILogsService {
	
}
