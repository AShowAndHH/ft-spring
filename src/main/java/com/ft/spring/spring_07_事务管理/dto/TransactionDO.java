package com.ft.spring.spring_07_事务管理.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Setter
@Getter
@ToString(of = {"code", "name"})
@RequiredArgsConstructor
@TableName("SPRING_TEST_TRANSACTION")
public class TransactionDO {
    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    String id;

    /**
     * code
     */
    @NonNull
    @TableField("CODE")
    String code;

    /**
     * name
     */
    @NonNull
    @TableField("NAME")
    String name;
}
