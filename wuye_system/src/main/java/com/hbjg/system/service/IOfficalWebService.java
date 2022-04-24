package com.hbjg.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.mapper.OfficalWebMapper;
import com.hbjg.system.pojo.OfficalWeb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IOfficalWebService extends IService<OfficalWeb> {

    List<OfficalWeb> selectByTitle(OfficalWeb officalWeb);
}
