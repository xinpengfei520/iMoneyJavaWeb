package com.xpf.imoney.mapper;

import com.xpf.imoney.bean.User;
import com.xpf.imoney.exception.MapperException;

/**
 * Created by Vance on 2019/07/09 :)
 * Function:DAO 层
 */
public interface UserMapper extends BaseMapper {

    /**
     * 查看账户id
     *
     * @param id
     * @return
     * @throws MapperException
     */
    User findUserById(int id) throws MapperException;
}
