package com.ft.spring.f7_事务管理.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @Description
 * @Author fangt
 * @CreateTime 2022/10/26 9:32
 */
@Setter @Getter @ToString(of = {"code", "name", "creatTime"})
@TableName("SPRING_TEST_TRANSACTION")
public class TransactionDO {
    public TransactionDO(@NonNull String code, @NonNull String info) {
        this.code = code;
        this.info = info;
        creatTime = LocalDateTime.now();
    }

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    String id;

    @NonNull
    @TableField("CODE")
    String code;

    @NonNull
    @TableField("INFO")
    String info;

    @NonNull
    @TableField("CREATTIME")
    LocalDateTime creatTime;
}
