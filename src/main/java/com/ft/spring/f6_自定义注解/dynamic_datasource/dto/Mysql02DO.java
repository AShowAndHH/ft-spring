package com.ft.spring.f6_自定义注解.dynamic_datasource.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2023/8/16 16:36
 */

@Setter @Getter @ToString
@TableName("spring_test_table_02")
public class Mysql02DO {
    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    String id;

    /**
     * 测试字段1
     */
    @TableField("FIELD01")
    String field01;

    /**
     * 测试字段2
     */
    @TableField("FIELD02")
    String field02;
}
