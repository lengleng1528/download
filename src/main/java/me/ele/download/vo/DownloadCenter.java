package me.ele.download.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiahuizhai.zjh
 * @create 2021-08-23 11:31 上午
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadCenter {

    /**
     * 文件hash
     */
    private String fileName;
}
