package com.xpf.imoney.mapper;

import com.xpf.imoney.exception.MapperException;

import java.util.List;
import java.util.Map;

public interface BaseMapper {

    /**
     * 创建信息
     *
     * @param map
     * @return
     */
    Integer insert(Map<String, Object> map) throws MapperException;

    /**
     * 删除单个
     *
     * @param id
     * @return
     */
    Integer deleteById(int id) throws MapperException;

    /**
     * 条件删除
     *
     * @param condition
     * @return
     */
    int deleteByCondition(Map<String, Object> condition) throws MapperException;

    /**
     * 批量条件删除
     * 通过主键集合批量删除记录
     *
     * @param list
     * @return
     */
    int remove(List<Integer> list) throws MapperException;


    /**
     * 获取全量信息
     *
     * @param id
     * @return
     */
    Map<String, Object> getInfo(int id) throws MapperException;

    /**
     * 条件获取单个信息
     *
     * @param condition
     * @return
     */
    Map<String, Object> getInfoByCondition(Map<String, Object> condition);

    /**
     * 条件获取列表信息
     *
     * @param condition
     * @return
     */
    List<Map<String, Object>> findByCondition(Map<String, Object> condition) throws MapperException;

    /**
     * 修改基本信息
     *
     * @param condition
     */
    Integer updateInfo(Map<String, Object> condition) throws MapperException;

    /**
     * 批量修改基本信息
     *
     * @param list
     */
    Integer updateInfoBatch(List<Map<String, Object>> list) throws MapperException;

    /**
     * 获取总数
     *
     * @return
     */
    int count() throws MapperException;

    /**
     * 获取条件总数
     *
     * @param condition
     * @return
     */
    int countByCondition(Map<String, Object> condition) throws MapperException;

    /**
     * 条件下信息是否存在
     *
     * @param condition
     * @return
     */
    int isExist(Map<String, Object> condition) throws MapperException;
}
